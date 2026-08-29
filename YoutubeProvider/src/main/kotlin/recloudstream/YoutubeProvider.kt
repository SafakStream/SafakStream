package recloudstream

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*
import org.schabi.newpipe.extractor.InfoItem
import org.schabi.newpipe.extractor.ListExtractor
import org.schabi.newpipe.extractor.Page
import org.schabi.newpipe.extractor.kiosk.KioskExtractor
import org.schabi.newpipe.extractor.stream.StreamInfo
import org.schabi.newpipe.extractor.ServiceList

class YoutubeProvider : MainAPI() {
    override var mainUrl = "https://www.youtube.com"
    override var name = "YouTube"
    override var lang = "en"
    override val hasMainPage = true
    override val hasQuickSearch = true

    override val supportedTypes = setOf(
        TvType.Others,
        TvType.Live,
        TvType.TvSeries
    )

    private val service = ServiceList.YouTube

    override val mainPage = mainPageOf(
        "Trending" to "Trending",
        "trending_movies_and_shows" to "Movies & Shows",
        "trending_music" to "Music",
        "trending_gaming" to "Gaming",
        "trending_podcasts_episodes" to "Podcasts",
        "live" to "Live"
    )

    /*
     * NewPipeExtractor 0.25.2:
     * - getInitialPage() / getPage(Page) return ListExtractor.InfoItemsPage<T>
     * - InfoItemsPage.getNextPage() returns Page?
     *
     * CloudStream uses page numbers, while NewPipe uses Page tokens.
     * Therefore we cache only the NewPipe Page token.
     */
    private val pageCache = mutableMapOf<String, Page?>()

    override suspend fun getMainPage(
        page: Int,
        request: MainPageRequest
    ): HomePageResponse {
        val key = request.data

        if (page == 1) {
            pageCache.remove(key)
        }

        val extractor = getKioskExtractor(request.data)

        val pageData: ListExtractor.InfoItemsPage<out InfoItem> = try {
            if (page == 1) {
                extractor.fetchPage()
                extractor.getInitialPage().also {
                    pageCache[key] = it.getNextPage()
                }
            } else {
                val next = pageCache[key]
                    ?: return newHomePageResponse(emptyList(), false)

                extractor.getPage(next).also {
                    pageCache[key] = it.getNextPage()
                }
            }
        } catch (e: Exception) {
            return newHomePageResponse(emptyList(), false)
        }

        val results = pageData.getItems().map { item: InfoItem ->
            item.toSearchResponse()
        }

        val headerName = try {
            extractor.getName().ifEmpty { request.name }
        } catch (e: Exception) {
            request.name
        }.ifEmpty { "Trending" }

        return newHomePageResponse(
            listOf(
                HomePageList(
                    headerName,
                    results,
                    true
                )
            ),
            pageData.hasNextPage()
        )
    }

    private val searchPageCache = mutableMapOf<String, Page?>()

    override suspend fun search(
        query: String,
        page: Int
    ): SearchResponseList {
        /*
         * Keep the existing cache behaviour: CloudStream requests page numbers,
         * NewPipe needs the Page token from the previous result.
         */
        if (page == 1) {
            searchPageCache.remove(query)
        }

        val extractor = service.getSearchExtractor(query)

        val pageData: ListExtractor.InfoItemsPage<out InfoItem> = try {
            if (page == 1) {
                extractor.fetchPage()
                extractor.getInitialPage().also {
                    searchPageCache[query] = it.getNextPage()
                }
            } else {
                val next = searchPageCache[query]
                    ?: return newSearchResponseList(emptyList(), false)

                extractor.getPage(next).also {
                    searchPageCache[query] = it.getNextPage()
                }
            }
        } catch (e: Exception) {
            return newSearchResponseList(emptyList(), false)
        }

        val results = pageData.getItems().map { item: InfoItem ->
            item.toSearchResponse()
        }

        return newSearchResponseList(
            results,
            pageData.hasNextPage()
        )
    }

    private fun getKioskExtractor(kioskId: String?): KioskExtractor<out InfoItem> {
        return if (kioskId.isNullOrBlank()) {
            service.kioskList.getDefaultKioskExtractor(null)
        } else {
            service.kioskList.getExtractorById(kioskId, null)
        }
    }

    private fun InfoItem.toSearchResponse(): SearchResponse {
        return newMovieSearchResponse(
            getName().ifBlank { "Unknown" },
            getUrl(),
            TvType.Others
        ) {
            posterUrl = getThumbnails().lastOrNull()?.url
        }
    }

    override suspend fun load(url: String): LoadResponse {
        return when (getUrlType(url)) {
            UrlType.Video -> loadVideo(url)
            UrlType.Channel -> loadChannel(url)
            UrlType.Playlist -> loadPlaylist(url)
            UrlType.Unknown -> throw RuntimeException("Unsupported YouTube URL")
        }
    }

    private enum class UrlType {
        Video,
        Channel,
        Playlist,
        Unknown
    }

    private fun getUrlType(url: String): UrlType {
        /*
         * Check playlist before video because a playlist URL can also contain
         * "watch?v=...&list=...".
         */
        return when {
            url.contains("/playlist?list=") -> UrlType.Playlist
            url.contains("/watch?v=") && url.contains("&list=") -> UrlType.Playlist
            url.contains("/watch?v=") || url.contains("youtu.be/") -> UrlType.Video
            url.contains("/channel/") ||
                url.contains("/@") ||
                url.contains("/c/") ||
                url.contains("/user/") -> UrlType.Channel
            else -> UrlType.Unknown
        }
    }

    private suspend fun loadVideo(url: String): LoadResponse {
        val extractor = service.getStreamExtractor(url)
        extractor.fetchPage()

        val info = StreamInfo.getInfo(extractor)

        return newMovieLoadResponse(
            info.getName(),
            url,
            if (info.getStreamType().name.contains("LIVE")) {
                TvType.Live
            } else {
                TvType.Others
            },
            url
        ) {
            plot = info.getDescription().getContent()
            posterUrl = info.getThumbnails().lastOrNull()?.url
            duration = info.getDuration().toInt()

            info.getUploaderName()
                ?.takeIf { it.isNotBlank() }
                ?.let { uploader ->
                    actors = listOf(
                        ActorData(
                            Actor(
                                uploader,
                                info.getUploaderAvatars().lastOrNull()?.url ?: ""
                            )
                        )
                    )
                }

            tags = info.getTags()?.take(5)?.toList()
        }
    }

    private suspend fun loadChannel(url: String): LoadResponse {
        val extractor = service.getChannelExtractor(url)
        extractor.fetchPage()

        val channelName = extractor.getName()
        val channelDescription = extractor.getDescription()
        val channelAvatar = extractor.getAvatars().lastOrNull()?.url
        val channelBanner = extractor.getBanners().lastOrNull()?.url

        val tabs = extractor.getTabs()
        val videosTab = tabs.firstOrNull {
            it.getUrl().contains("/videos")
        } ?: tabs.firstOrNull()
            ?: throw RuntimeException("No videos tab found")

        val videosExtractor = service.getChannelTabExtractor(videosTab)
        videosExtractor.fetchPage()

        val episodes = mutableListOf<Episode>()

        var page = videosExtractor.getInitialPage()

        episodes.addAll(
            page.getItems().map { item: InfoItem ->
                newEpisode(item.getUrl(), fix = true) {
                    name = item.getName()
                    posterUrl = item.getThumbnails().lastOrNull()?.url
                }
            }
        )

        /*
         * Limit the number of pages fetched to prevent massive API overhead.
         */
        var pagesLoaded = 1
        val maxPagesToLoad = 5

        while (page.hasNextPage() && pagesLoaded < maxPagesToLoad) {
            page = videosExtractor.getPage(page.getNextPage())

            episodes.addAll(
                page.getItems().map { item: InfoItem ->
                    newEpisode(item.getUrl(), fix = true) {
                        name = item.getName()
                        posterUrl = item.getThumbnails().lastOrNull()?.url
                    }
                }
            )

            pagesLoaded++
        }

        return newTvSeriesLoadResponse(
            channelName,
            url,
            TvType.TvSeries,
            episodes
        ) {
            plot = channelDescription
            posterUrl = channelBanner
            backgroundPosterUrl = channelBanner
            tags = listOf("Channel")
            actors = listOf(
                ActorData(
                    Actor(
                        channelName,
                        channelAvatar ?: ""
                    )
                )
            )
        }
    }

    private suspend fun loadPlaylist(url: String): LoadResponse {
        val extractor = service.getPlaylistExtractor(url)
        extractor.fetchPage()

        val playlistName = extractor.getName()
        val playlistDescription = extractor.getDescription().getContent()
        val playlistThumbnail = extractor.getThumbnails().lastOrNull()?.url
        val uploaderName = extractor.getUploaderName()

        val episodes = mutableListOf<Episode>()

        var page = extractor.getInitialPage()

        episodes.addAll(
            page.getItems().map { item: InfoItem ->
                newEpisode(item.getUrl(), fix = true) {
                    name = item.getName()
                    posterUrl = item.getThumbnails().lastOrNull()?.url
                }
            }
        )

        var pagesLoaded = 1
        val maxPagesToLoad = 5

        while (page.hasNextPage() && pagesLoaded < maxPagesToLoad) {
            page = extractor.getPage(page.getNextPage())

            episodes.addAll(
                page.getItems().map { item: InfoItem ->
                    newEpisode(item.getUrl(), fix = true) {
                        name = item.getName()
                        posterUrl = item.getThumbnails().lastOrNull()?.url
                    }
                }
            )

            pagesLoaded++
        }

        return newTvSeriesLoadResponse(
            playlistName,
            url,
            TvType.TvSeries,
            episodes
        ) {
            plot = playlistDescription
            posterUrl = playlistThumbnail
            tags = if (uploaderName.isNotBlank()) {
                listOf("Channel: $uploaderName")
            } else {
                listOf("Playlist")
            }

            if (uploaderName.isNotBlank()) {
                actors = listOf(
                    ActorData(
                        Actor(
                            uploaderName,
                            extractor.getUploaderAvatars().lastOrNull()?.url ?: ""
                        )
                    )
                )
            }
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        /*
         * data is already the real YouTube URL because loadVideo(), channel
         * episodes and playlist episodes all use the original item URL.
         *
         * The old code prepended "https://youtube.com/watch?v=" here, which
         * could turn an already complete URL into an invalid URL.
         */
        val youtubeUrl = when {
            data.startsWith("http://") || data.startsWith("https://") -> data
            else -> "https://www.youtube.com/watch?v=$data"
        }

        return loadExtractor(
            youtubeUrl,
            subtitleCallback,
            callback
        )
    }
}
