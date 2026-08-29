package com.stormunblessed

import com.fasterxml.jackson.annotation.JsonProperty


data class FTVHDApiResponse(
    @JsonProperty("data") val data: List<FTVHDEventData>,
    @JsonProperty("meta") val meta: FTVHDMeta? = null
)

data class FTVHDEventData(
    @JsonProperty("id") val id: Int,
    @JsonProperty("attributes") val attributes: FTVHDEventAttributes
)

data class FTVHDEventAttributes(
    @JsonProperty("diary_hour") val diaryHour: String,
    @JsonProperty("diary_description") val diaryDescription: String,
    @JsonProperty("date_diary") val dateDiary: String,
    @JsonProperty("createdAt") val createdAt: String,
    @JsonProperty("updatedAt") val updatedAt: String,
    @JsonProperty("publishedAt") val publishedAt: String,
    @JsonProperty("channels") val channels: FTVHDChannelList,
    @JsonProperty("embeds") val embeds: FTVHDEmbedList,
    @JsonProperty("country") val country: FTVHDCountryData
)

data class FTVHDChannelList(
    @JsonProperty("data") val data: List<Any> = emptyList()
)

data class FTVHDEmbedList(
    @JsonProperty("data") val data: List<FTVHDEmbedData>
)

data class FTVHDEmbedData(
    @JsonProperty("id") val id: Int,
    @JsonProperty("attributes") val attributes: FTVHDEmbedAttributes
)

data class FTVHDEmbedAttributes(
    @JsonProperty("embed_name") val embedName: String,
    @JsonProperty("embed_iframe") val embedIframe: String
    // embed_link removed — not present in API response
)

data class FTVHDCountryData(
    @JsonProperty("data") val data: FTVHDCountryInfo
)

data class FTVHDCountryInfo(
    @JsonProperty("id") val id: Int,
    @JsonProperty("attributes") val attributes: FTVHDCountryAttributes  // was Any
)

data class FTVHDCountryAttributes(
    @JsonProperty("name") val name: String,
    @JsonProperty("createdAt") val createdAt: String,
    @JsonProperty("updatedAt") val updatedAt: String,
    @JsonProperty("publishedAt") val publishedAt: String,
    @JsonProperty("image") val image: FTVHDImageData
)

data class FTVHDImageData(
    @JsonProperty("data") val data: FTVHDImageInfo
)

data class FTVHDImageInfo(
    @JsonProperty("id") val id: Int,
    @JsonProperty("attributes") val attributes: FTVHDImageAttributes
)

data class FTVHDImageAttributes(
    @JsonProperty("name") val name: String,
    @JsonProperty("alternativeText") val alternativeText: String?,
    @JsonProperty("caption") val caption: String?,
    @JsonProperty("width") val width: Int,
    @JsonProperty("height") val height: Int,
    @JsonProperty("formats") val formats: FTVHDImageFormats?,
    @JsonProperty("hash") val hash: String,
    @JsonProperty("ext") val ext: String,
    @JsonProperty("mime") val mime: String,
    @JsonProperty("size") val size: Double,
    @JsonProperty("url") val url: String,
    @JsonProperty("previewUrl") val previewUrl: String?,
    @JsonProperty("provider") val provider: String,
    @JsonProperty("provider_metadata") val providerMetadata: Any?,
    @JsonProperty("createdAt") val createdAt: String,
    @JsonProperty("updatedAt") val updatedAt: String
)

data class FTVHDImageFormats(
    @JsonProperty("thumbnail") val thumbnail: FTVHDThumbnailImage?
)

data class FTVHDThumbnailImage(
    @JsonProperty("ext") val ext: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("hash") val hash: String,
    @JsonProperty("mime") val mime: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("path") val path: String?,
    @JsonProperty("size") val size: Double,
    @JsonProperty("width") val width: Int,
    @JsonProperty("height") val height: Int
)

data class FTVHDMeta(
    @JsonProperty("pagination") val pagination: FTVHDPagination
)

data class FTVHDPagination(
    @JsonProperty("page") val page: Int,
    @JsonProperty("pageSize") val pageSize: Int,
    @JsonProperty("pageCount") val pageCount: Int,
    @JsonProperty("total") val total: Int
)