package com.hjsaraviad.core.data.comments.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentsResponse(
    val exhaustive: Exhaustive,
    @Json(name = "exhaustiveNbHits") val exhaustiveNbHits: Boolean,
    @Json(name = "exhaustiveTypo") val exhaustiveTypo: Boolean,
    val hits: List<Hit>
)

@JsonClass(generateAdapter = true)
data class Exhaustive(
    val nbHits: Boolean, val typo: Boolean
)

@JsonClass(generateAdapter = true)
data class Hit(
    @Json(name = "_highlightResult") val highlightResult: HighlightResult? = null,
    @Json(name = "_tags") val tags: List<String> = emptyList(),
    val author: String? = null,
    @Json(name = "comment_text")
    val commentText: String? = null,
    @Json(name = "created_at")
    val createdAt: String? = null,
    @Json(name = "created_at_i")
    val createdAtI: Long? = null,
    val objectID: String? = null,
    @Json(name = "parent_id")
    val parentId: Long? = null,
    @Json(name = "story_id")
    val storyId: Long? = null,
    @Json(name = "story_title")
    val storyTitle: String? = null,
    @Json(name = "story_url")
    val storyUrl: String? = null,
    @Json(name = "updated_at")
    val updatedAt: String? = null
)

@JsonClass(generateAdapter = true)
data class HighlightResult(
    val author: MatchResult? = null,
    @Json(name = "comment_text") val commentText: MatchResult? = null,
    @Json(name = "story_title") val storyTitle: MatchResult? = null,
    @Json(name = "story_url") val storyUrl: MatchResult? = null
)

@JsonClass(generateAdapter = true)
data class MatchResult(
    @Json(name = "matchLevel") val matchLevel: String?,
    @Json(name = "matchedWords") val matchedWords: List<String> = emptyList(),
    val value: String? = null,
    @Json(name = "fullyHighlighted") val fullyHighlighted: Boolean? = null // Optional field
)

