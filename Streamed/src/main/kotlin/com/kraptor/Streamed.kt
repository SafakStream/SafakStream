// ! Bu araç @Kraptor123 tarafından | @cs-Karma için yazılmıştır.

package com.kraptor

import android.util.Log
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*
import com.lagradost.cloudstream3.utils.AppUtils.parseJson
import kotlinx.coroutines.*

class Streamed : MainAPI() {
    override var mainUrl = "https://streamed.pk"
    override var name = "Streamed"
    override val hasMainPage = true
    override var lang = "en"
    override val hasQuickSearch = true
    override val supportedTypes = setOf(TvType.Live)
    override val vpnStatus = VPNStatus.MightBeNeeded

    override val mainPage = mainPageOf(
        "${mainUrl}/api/matches/live/popular" to "Live Popular",
        "${mainUrl}/api/matches/live" to "Live",
        "${mainUrl}/api/matches/all-today/popular" to "Today's Popular Matches",
        "${mainUrl}/api/matches/football/popular" to "Football",
        "${mainUrl}/api/matches/fight/popular" to "Fight",
        "${mainUrl}/api/matches/american-football/popular" to "American Football",
        "${mainUrl}/api/matches/basketball/popular" to "Basketball",
        "${mainUrl}/api/matches/tennis/popular" to "Tennis",
        "${mainUrl}/api/matches/hockey/popular" to "Hockey",
        "${mainUrl}/api/matches/baseball/popular" to "Baseball",
        "${mainUrl}/api/matches/darts/popular" to "Darts",
        "${mainUrl}/api/matches/motor-sports/popular" to "Motor Sports",
        "${mainUrl}/api/matches/golf/popular" to "Golf",
        "${mainUrl}/api/matches/billiards/popular" to "Billiards",
        "${mainUrl}/api/matches/afl/popular" to "AFL",
        "${mainUrl}/api/matches/cricket/popular" to "Cricket",
        "${mainUrl}/api/matches/other/popular" to "Other"
    )

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val textdoc = app.get(request.data).text
        val matches: List<Matches> = parseJson(textdoc)

        val items = matches
            .filter { it.sources?.isNotEmpty() == true }
            .mapNotNull { match ->
                val title = match.title ?: return@mapNotNull null
                val firstSourceId =
                    match.sources?.firstOrNull()?.id ?: match.id ?: return@mapNotNull null
                val href = "$mainUrl/watch/${firstSourceId}"
                val poster = "${match.poster}"
                val posterUrl = if (poster.contains("api")) {
                    "${mainUrl}${match.poster}"
                } else {
                    "${mainUrl}/api/images/badge/${match.id}.webp"
                }
                newLiveSearchResponse(title, href, TvType.Live) {
                    this.posterUrl = posterUrl
                    this.posterHeaders =
                        mapOf("User-Agent" to "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:141.0) Gecko/20100101 Firefox/141.0")
                }
            }

        return newHomePageResponse(
            list = HomePageList(
                request.name,
                list = items,
                isHorizontalImages = true,
            ), hasNext = false
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val matches = mutableListOf<Matches>()
        val txt = app.get("$mainUrl/api/matches/all").text
        val list: List<Matches> = parseJson(txt)
        matches.addAll(list)

        if (matches.isEmpty()) return emptyList()

        val unique = matches
            .associateBy { it.id ?: it.title ?: java.util.UUID.randomUUID().toString() }
            .values
            .toList()

        val q = query.lowercase().trim()
        val normalizedQuery = normalizeTurkish(q)

        val sorted = unique.sortedWith(compareByDescending<Matches> {
            val t = it.title?.lowercase() ?: ""
            when {
                t.startsWith(q) -> 2
                t.contains(q) -> 1
                else -> 0
            }
        }.thenBy { it.title ?: "" })

        val filtered = sorted.filter { match ->
            val titleNorm = normalizeTurkish(match.title ?: "")
            val sourceMatch = match.sources?.any { src ->
                normalizeTurkish(src.id ?: "").contains(normalizedQuery)
            } ?: false

            titleNorm.contains(normalizedQuery) || sourceMatch
        }

        if (filtered.isEmpty()) return emptyList()

        return filtered.mapNotNull { match ->
            val title = match.title ?: return@mapNotNull null
            val firstSourceId =
                match.sources?.firstOrNull()?.id ?: match.id ?: return@mapNotNull null
            val href = "$mainUrl/watch/${firstSourceId}"
            val poster = match.poster ?: ""
            val posterUrl = if (poster.contains("api")) {
                "${mainUrl}${match.poster}"
            } else {
                "${mainUrl}/api/images/badge/${match.id}.webp"
            }

            newLiveSearchResponse(title, href, TvType.Live) {
                this.posterUrl = posterUrl
                this.posterHeaders =
                    mapOf("User-Agent" to "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:141.0) Gecko/20100101 Firefox/141.0")
            }
        }
    }

    private fun normalizeTurkish(s: String): String {
        var res = s.lowercase()
        val map = mapOf(
            'ç' to 'c',
            'ğ' to 'g',
            'ı' to 'i',
            'ö' to 'o',
            'ş' to 's',
            'ü' to 'u',
            'İ' to 'i'
        )
        map.forEach { (k, v) -> res = res.replace(k.toString(), v.toString()) }
        res = java.text.Normalizer.normalize(res, java.text.Normalizer.Form.NFD)
            .replace("\\p{InCombiningDiacriticalMarks}+".toRegex(), "")
        return res.replace("[^a-z0-9 ]".toRegex(), "").trim()
    }

    override suspend fun quickSearch(query: String): List<SearchResponse> {
        return search(query)
    }

    override suspend fun load(url: String): LoadResponse {
        val sourceId = url.substringAfterLast("/")
        val txt = app.get("$mainUrl/api/matches/all").text
        val matches: List<Matches> = parseJson(txt)

        val match = matches.find { m ->
            m.sources?.any { it.id == sourceId } == true || m.id == sourceId
        } ?: throw ErrorLoadingException("Maç bilgisi bulunamadı")

        val title = match.title ?: "Bilinmeyen Başlık"

        val poster = match.poster ?: ""
        val posterUrl = if (poster.contains("api")) {
            "${mainUrl}${match.poster}"
        } else {
            "${mainUrl}/api/images/badge/${match.id}.webp"
        }

        val description = match.date?.let { dateTimestamp ->
            val currentTime = System.currentTimeMillis()
            val matchTime = if (dateTimestamp > 1000000000000L) {
                dateTimestamp
            } else {
                dateTimestamp * 1000
            }

            when {
                matchTime > currentTime -> {
                    val remainingTimeMs = matchTime - currentTime
                    val remainingMinutes = remainingTimeMs / (1000 * 60)
                    val hours = remainingMinutes / 60
                    val minutes = remainingMinutes % 60

                    when {
                        hours > 24 -> "Maça kalan süre: ${hours / 24} gün ${hours % 24} saat"
                        hours > 0 -> "Maça kalan süre: $hours saat $minutes dakika"
                        minutes > 0 -> "Maça kalan süre: $minutes dakika"
                        else -> "Maç yakında başlayacak"
                    }
                }
                else -> "Maç şu anda canlı veya tamamlandı"
            }
        } ?: "Maç zamanı bilgisi bulunamadı"

        val tags = match.category?.let { listOf(it) } ?: emptyList()
        val sourcesCount = match.sources?.size ?: 0
        val finalDescription = if (sourcesCount > 1) {
            "$description\n\nMevcut kaynak sayısı: $sourcesCount"
        } else {
            description
        }

        return newMovieLoadResponse(title, url, TvType.Live, url) {
            this.posterUrl = posterUrl
            this.posterHeaders =
                mapOf("User-Agent" to "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:141.0) Gecko/20100101 Firefox/141.0")
            this.plot = finalDescription
            this.tags = tags
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean = withContext(Dispatchers.IO) {
        val sourceId = data.substringAfterLast("/")

        try {
            val apiUrl = "$mainUrl/api/matches/all"
            val txt = app.get(apiUrl).text
            val matches: List<Matches> = parseJson(txt)

            val match = matches.find { m ->
                val hasSourceId = m.sources?.any { it.id == sourceId } == true
                val isMatchId = m.id == sourceId
                hasSourceId || isMatchId
            } ?: return@withContext false

            val allStreams = mutableListOf<Pair<Stream, String>>()

            match.sources?.forEachIndexed { _, source ->
                val sType = source.source
                val sId = source.id
                if (sType != null && sId != null) {
                    try {
                        val streamApiUrl = "$mainUrl/api/stream/$sType/$sId"
                        val sResponse = app.get(streamApiUrl).text
                        val streams: List<Stream> = parseJson(sResponse)

                        if (streams.isNotEmpty()) {
                            streams.forEach {
                                allStreams.add(Pair(it, sType))
                            }
                        } else {
                            allStreams.add(
                                Pair(
                                    Stream(
                                        id = sId,
                                        streamNo = 1,
                                        language = "English",
                                        embedUrl = "https://embed.st/embed/$sType/$sId/1",
                                        source = sType,
                                        hd = true,
                                        viewers = 0
                                    ),
                                    sType
                                )
                            )
                        }
                    } catch (e: Exception) {
                        allStreams.add(
                            Pair(
                                Stream(
                                    id = sId,
                                    streamNo = 1,
                                    language = "English",
                                    embedUrl = "https://embed.st/embed/$sType/$sId/1",
                                    source = sType,
                                    hd = true,
                                    viewers = 0
                                ),
                                sType
                            )
                        )
                    }
                }
            }

            val processedStreams = mutableSetOf<String>()

            allStreams.forEach { (stream, _) ->
                try {
                    val embedUrl = stream.embedUrl.toString()
                    if (embedUrl.isNotEmpty() && !processedStreams.contains(embedUrl)) {
                        processedStreams.add(embedUrl)

                        loadExtractor(
                            url = embedUrl,
                            referer = mainUrl,
                            subtitleCallback = { sub -> subtitleCallback.invoke(sub) },
                            callback = { link -> callback.invoke(link) }
                        )
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            return@withContext true
        } catch (e: Exception) {
            Log.e("Streamed", "Stream error: ${e.message}")
            return@withContext false
        }
    }

    data class Matches(
        val id: String? = null,
        val title: String? = null,
        val category: String? = null,
        val date: Long? = null,
        val popular: Boolean? = null,
        val sources: List<Sources>? = null,
        val poster: String? = null
    )

    data class Sources(
        val id: String? = null,
        val source: String? = null
    )

    data class Stream(
        val id: String? = null,
        val streamNo: Int? = null,
        val language: String? = null,
        val embedUrl: String? = null,
        val source: String? = null,
        val hd: Boolean? = null,
        val viewers: Int? = null
    )
}
