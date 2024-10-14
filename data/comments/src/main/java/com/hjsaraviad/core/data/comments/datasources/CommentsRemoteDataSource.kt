package com.hjsaraviad.core.data.comments.datasources

import com.hjsaraviad.core.data.comments.models.Comment


interface CommentsRemoteDataSource {
    suspend fun fetchComments(): List<Comment>
}