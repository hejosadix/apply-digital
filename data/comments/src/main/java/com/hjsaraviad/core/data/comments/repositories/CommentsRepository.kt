package com.hjsaraviad.core.data.comments.repositories

import com.hjsaraviad.core.data.comments.models.Comment
import kotlinx.coroutines.flow.Flow

interface CommentsRepository {
    fun fetchComments(): Flow<List<Comment>>
    suspend fun deleteLocalComment(comment: Comment)
}