package com.hjsaraviad.core.database.comment

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CommentEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val author: String,
    val commentText: String,
    val storyTitle: String,
    val storyUrl: String,
    val tags: List<String>,
    val createdAt: String,
    val createdAtTimestamp: Long,
    val parentID: String?,
    val storyID: String,
    val updatedAt: String
)
