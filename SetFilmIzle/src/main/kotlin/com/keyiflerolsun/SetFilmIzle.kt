// ! Bu araç @keyiflerolsun tarafından | @KekikAkademi için yazılmıştır.

package com.keyiflerolsun

import android.util.Log
import org.jsoup.nodes.Element
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*
import com.lagradost.cloudstream3.LoadResponse.Companion.addActors
import com.lagradost.cloudstream3.LoadResponse.Companion.addTrailer
import org.json.JSONObject
import org.jsoup.Jsoup
import okhttp3.*

class SetFilmIzle : MainAPI() {
    override var mainUrl              = "https://www.setfilmizle.ltd"
    override var name                 = "SetFilmIzle"
    override val hasMainPage          = true
    override var lang                 = "tr"
    override val hasQuickSearch       = false
    override val supportedTypes       = setOf(TvType.Movie, TvType.TvSeries)

    override val mainPage = mainPageOf(
        "${mainUrl}/film-izle/"        to "Son Eklenen Filmler",
        "${mainUrl}/dizi-izle/"        to "Son Eklenen Diziler",
        "${mainUrl}/tur/aksiyon/"      to "Aksiyon",
        "${mainUrl}/tur/bilim-kurgu/"  to "Bilim-Kurgu",
        "${mainUrl}/tur/komedi/"       to "Komedi",
        "${mainUrl}/tur/korku/"        to "Korku",
        "${mainUrl}/tur/gerilim/"      to "Gerilim",
        "${mainUrl}/tur/dram/"         to "Dram",
        "${mainUrl}/tur/animasyon/"    to "Animasyon",
        "${mainUrl}/tur/belgesel/"     to "Belgesel"
    )

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val url = if (page <= 1) request.data else "${request.data}page/$page/"
        val document = app.get(url).document
        val home = document.select("div.items article, div.poster-media, div.item, article.item").mapNotNull { it.toMainPageResult() }

        return newHomePageResponse(
            list = HomePageList(
                name = request.name,
                list = home,
                isHorizontalImages = false
            ),
            hasNext = home.isNotEmpty()
        )
    }

    private fun Element.toMainPageResult(): SearchResponse? {
        val title = this.selectFirst("h2, h3, .entry-title, .title, img")?.text()?.ifEmpty { null }
            ?: this.selectFirst("img")?.attr("alt")?.ifEmpty { null }
            ?: return null
        val href = fixUrlNull(this.selectFirst("a")?.attr("href")) ?: return null
        val posterUrl = fixUrlNull(
            this.selectFirst("img")?.attr("data-src")
                ?: this.selectFirst("img")?.attr("data-lazy-src")
                ?: this.selectFirst("img")?.attr("src")
        )

        return if (href.contains("/dizi/")) {
            newTvSeriesSearchResponse(title, href, TvType.TvSeries) { this.posterUrl = posterUrl }
        } else {
            newMovieSearchResponse(title, href, TvType.Movie) { this.posterUrl = posterUrl }
        }
    }

    override suspend fun search(query: String): List<SearchResponse> {
        return try {
            val mainPage = app.get(mainUrl).document
            val nonce = Regex("""nonce: '(.*)'""").find(mainPage.html())?.groupValues?.get(1) ?: ""
            val search = app.post(
                url = "${mainUrl}/wp-admin/admin-ajax.php",
                headers = mapOf("X-Requested-With" to "XMLHttpRequest"),
                data = mapOf(
                    "action" to "ajax_search",
                    "nonce"  to nonce,
                    "search" to query
                )
            )
            val document = Jsoup.parse(JSONObject(search.text).getString("html"))
            document.select("div.items article, div.poster-media, div.item, article.item").mapNotNull { it.toSearchResult() }
        } catch (e: Exception) {
            val doc = app.get("${mainUrl}/?s=${query}").document
            doc.select("div.items article, div.poster-media, div.item, article.item").mapNotNull { it.toSearchResult() }
        }
    }

    private fun Element.toSearchResult(): SearchResponse? {
        return toMainPageResult()
    }

    override suspend fun quickSearch(query: String): List<SearchResponse> = search(query)

    override suspend fun load(url: String): LoadResponse? {
        val document = app.get(url).document

        val title = document.selectFirst("h1")?.text()?.substringBefore(" izle")?.trim() ?: return null
        val poster = fixUrlNull(
            document.selectFirst("div.poster img, .poster img")?.attr("data-src")
                ?: document.selectFirst("div.poster img, .poster img")?.attr("src")
        )
        val description = document.selectFirst("div.wp-content p, #info .content p")?.text()?.trim()
        var year = document.selectFirst("div.extra span.C a, span.date")?.text()?.trim()?.toIntOrNull()
        val tags = document.select("div.sgeneros a, .genres a").map { it.text() }
        var duration = document.selectFirst("span.runtime")?.text()?.split(" ")?.first()?.trim()?.toIntOrNull()
        val recommendations = document.select("div.srelacionados article, .related-posts article").mapNotNull { it.toMainPageResult() }
        val actors = document.select("span.valor a, .cast a").map { Actor(it.text()) }
        val trailer = Regex("""embed/(.*)\?rel""").find(document.html())?.groupValues?.get(1)?.let { "https://www.youtube.com/embed/$it" }

        if (url.contains("/dizi/")) {
            year = document.selectFirst("a[href*='/yil/']")?.text()?.trim()?.toIntOrNull()
            duration = document.selectFirst("div#info span:containsOwn(Dakika)")?.text()?.split(" ")?.first()?.trim()?.toIntOrNull()

            val episodes = document.select("div#episodes ul.episodios li, ul.episodios li").mapNotNull {
                val epHref = fixUrlNull(it.selectFirst("h4.episodiotitle a, a")?.attr("href")) ?: return@mapNotNull null
                val epName = it.selectFirst("h4.episodiotitle a, a")?.ownText()?.trim() ?: "Bölüm"
                val epDetail = it.selectFirst("h4.episodiotitle a, a")?.text()?.trim() ?: ""
// ! Bu araç @keyiflerolsun tarafından | @KekikAkademi için yazılmıştır.

package com.keyiflerolsun

import android.util.Log
import org.jsoup.nodes.Element
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*
import com.lagradost.cloudstream3.LoadResponse.Companion.addActors
import com.lagradost.cloudstream3.LoadResponse.Companion.addTrailer
import org.json.JSONObject
import org.jsoup.Jsoup
import okhttp3.*

class SetFilmIzle : MainAPI() {
    override var mainUrl              = "https://www.setfilmizle.ltd"
    override var name                 = "SetFilmIzle"
    override val hasMainPage          = true
    override var lang                 = "tr"
    override val hasQuickSearch       = false
    override val supportedTypes       = setOf(TvType.Movie, TvType.TvSeries)

    override val mainPage = mainPageOf(
        "${mainUrl}/filmler/"          to "Son Filmler",
        "${mainUrl}/diziler/"          to "Son Diziler",
        "${mainUrl}/tur/aksiyon/"      to "Aksiyon",
        "${mainUrl}/tur/bilim-kurgu/"  to "Bilim Kurgu",
        "${mainUrl}/tur/komedi/"       to "Komedi",
        "${mainUrl}/tur/korku/"        to "Korku",
        "${mainUrl}/tur/gerilim/"      to "Gerilim",
        "${mainUrl}/tur/dram/"         to "Dram",
        "${mainUrl}/tur/animasyon/"    to "Animasyon"
    )

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val url = if (page <= 1) request.data else "${request.data}page/$page/"
        val document = app.get(url).document
        
        val elements = document.select("article, .items article, .poster-media, div.item, .item-list .item")
        val home = elements.mapNotNull { it.toMainPageResult() }.distinctBy { it.url }

        return newHomePageResponse(
            list = HomePageList(
                name = request.name,
                list = home,
                isHorizontalImages = false
            ),
            hasNext = home.isNotEmpty()
        )
    }

    private fun Element.toMainPageResult(): SearchResponse? {
        val linkEl = this.selectFirst("a[href*='/film/'], a[href*='/dizi/'], a") ?: return null
        val href = fixUrlNull(linkEl.attr("href")) ?: return null
        if (href == mainUrl || href.endsWith("/tur/") || href.contains("/page/")) return null

        val imgEl = this.selectFirst("img")
        val title = this.selectFirst("h2, h3, .title, .entry-title")?.text()?.ifEmpty { null }
            ?: imgEl?.attr("alt")?.ifEmpty { null }
            ?: linkEl.attr("title").ifEmpty { null }
            ?: return null

        val posterUrl = fixUrlNull(
            imgEl?.attr("data-src")
                ?: imgEl?.attr("data-lazy-src")
                ?: imgEl?.attr("src")
        )

        return if (href.contains("/dizi/")) {
            newTvSeriesSearchResponse(title.trim(), href, TvType.TvSeries) { this.posterUrl = posterUrl }
        } else {
            newMovieSearchResponse(title.trim(), href, TvType.Movie) { this.posterUrl = posterUrl }
        }
    }

    override suspend fun search(query: String): List<SearchResponse> {
        return try {
            val mainPage = app.get(mainUrl).document
            val nonce = Regex("""nonce: '(.*)'""").find(mainPage.html())?.groupValues?.get(1) ?: ""
            val search = app.post(
                url = "${mainUrl}/wp-admin/admin-ajax.php",
                headers = mapOf("X-Requested-With" to "XMLHttpRequest"),
                data = mapOf(
                    "action" to "ajax_search",
                    "nonce"  to nonce,
                    "search" to query
                )
            )
            val document = Jsoup.parse(JSONObject(search.text).getString("html"))
            document.select("article, .items article, div.item").mapNotNull { it.toMainPageResult() }.distinctBy { it.url }
        } catch (e: Exception) {
            val doc = app.get("${mainUrl}/?s=${query}").document
            doc.select("article, .items article, div.item").mapNotNull { it.toMainPageResult() }.distinctBy { it.url }
        }
    }

    override suspend fun quickSearch(query: String): List<SearchResponse> = search(query)

    override suspend fun load(url: String): LoadResponse? {
        val document = app.get(url).document

        val title = document.selectFirst("h1")?.text()?.substringBefore(" izle")?.trim() ?: return null
        val poster = fixUrlNull(
            document.selectFirst("div.poster img, .poster img, .sheader .poster img")?.attr("data-src")
                ?: document.selectFirst("div.poster img, .poster img, .sheader .poster img")?.attr("src")
        )
        val description = document.selectFirst("div.wp-content p, #info .content p, .sinopse p")?.text()?.trim()
        val year = document.selectFirst("div.extra span.C a, span.date, .extra .date")?.text()?.trim()?.toIntOrNull()
        val tags = document.select("div.sgeneros a, .genres a").map { it.text().trim() }
        val duration = document.selectFirst("span.runtime")?.text()?.split(" ")?.firstOrNull()?.trim()?.toIntOrNull()
        val recommendations = document.select("div.srelacionados article, .related-posts article, #single_relacionados article").mapNotNull { it.toMainPageResult() }.distinctBy { it.url }
        val actors = document.select("span.valor a, .cast a, .persons .person").map { Actor(it.text().trim()) }
        val trailer = Regex("""embed/(.*)\?rel""").find(document.html())?.groupValues?.get(1)?.let { "https://www.youtube.com/embed/$it" }

        if (url.contains("/dizi/")) {
            val episodes = document.select("div#episodes ul.episodios li, ul.episodios li, .episodios li").mapNotNull {
                val epHref = fixUrlNull(it.selectFirst("h4.episodiotitle a, a")?.attr("href")) ?: return@mapNotNull null
                val epName = it.selectFirst("h4.episodiotitle a, a")?.ownText()?.trim() ?: "Bölüm"
                val epDetail = it.selectFirst("h4.episodiotitle a, a")?.text()?.trim() ?: ""
                val epSeason = epDetail.substringBefore(". Sezon").toIntOrNull()
                val epEpisode = epDetail.split("Sezon ").lastOrNull()?.substringBefore(". Bölüm")?.toIntOrNull()

                newEpisode(epHref) {
                    this.name = epName
                    this.season = epSeason
                    this.episode = epEpisode
                }
            }

            return newTvSeriesLoadResponse(title, url, TvType.TvSeries, episodes) {
                this.posterUrl       = poster
                this.plot            = description
                this.year            = year
                this.tags            = tags
                this.duration        = duration
                this.recommendations = recommendations
                addActors(actors)
                addTrailer(trailer)
            }
        }

        return newMovieLoadResponse(title, url, TvType.Movie, url) {
            this.posterUrl       = poster
            this.plot            = description
            this.year            = year
            this.tags            = tags
            this.duration        = duration
            this.recommendations = recommendations
            addActors(actors)
            addTrailer(trailer)
        }
    }

    private fun sendMultipartRequest(nonce: String, postId: String, playerName: String, partKey: String, referer: String): Response {
        val formData = mapOf(
            "action"      to "get_video_url",
            "nonce"       to nonce,
            "post_id"     to postId,
            "player_name" to playerName,
            "part_key"    to partKey
        )

        val requestBody = MultipartBody.Builder().setType(MultipartBody.FORM).apply {
            formData.forEach { (key, value) -> addFormDataPart(key, value) }
        }.build()

        val headers = mapOf(
            "Referer"          to referer,
            "X-Requested-With" to "XMLHttpRequest"
        )

        val request = Request.Builder().url("${mainUrl}/wp-admin/admin-ajax.php").post(requestBody).apply {
            headers.forEach { (key, value) -> addHeader(key, value) }
        }.build()

        val client = OkHttpClient()
        return client.newCall(request).execute()
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        Log.d("STF", "data » $data")
        val document = app.get(data).document

        document.select("nav.player a, ul.options a, #playeroptionsul li").map { element ->
            val sourceId = element.attr("data-post-id").ifEmpty { element.attr("data-post") }.ifEmpty { element.attr("data-nume") }
            val name = element.attr("data-player-name").ifEmpty { element.attr("data-name") }.ifEmpty { element.selectFirst(".title, span")?.text() ?: "" }
            val partKey = element.attr("data-part-key").takeIf { it.isNotEmpty() }

            Triple(name, sourceId, partKey)
        }.forEach { (name, sourceId, partKey) ->
            if (sourceId.contains("event") || sourceId.isEmpty()) return@forEach

            val nonce = document.selectFirst("div#playex, div#player, div.playex")?.attr("data-nonce") ?: ""
            try {
                val multiPart = sendMultipartRequest(nonce, sourceId, name, partKey ?: "", data)
                val sourceBody = multiPart.body.string()
                val sourceIframe = JSONObject(sourceBody).optJSONObject("data")?.optString("url") ?: return@forEach

                Log.d("STF", "iframe » $sourceIframe")

                val finalUrl = if (sourceIframe.contains("setplay")) {
                    sourceIframe
                } else {
                    if (partKey != null) "$sourceIframe?partKey=$partKey" else sourceIframe
                }

                loadExtractor(finalUrl, "$mainUrl/", subtitleCallback, callback)
            } catch (e: Exception) {
                Log.e("STF", "Error loading player: ${e.message}")
            }
        }

        return true
    }
}
