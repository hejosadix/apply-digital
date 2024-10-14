package com.hjsaraviad.core.data.comments.models

data class Comment(
    val author: String,
    val commentText: String,
    val storyTitle: String,
    val storyUrl: String,
    val tags: List<String>,
    val createdAt: String,
    val createdAtTimestamp: Long,
    val objectID: String,
    val parentID: String?,
    val storyID: String,
    val updatedAt: String
)