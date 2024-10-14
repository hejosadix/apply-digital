package com.hjsaraviad.core.data.comments.datasources

import com.hjsaraviad.core.data.comments.mappers.toCommentList
import com.hjsaraviad.core.data.comments.models.Comment
import com.hjsaraviad.core.data.comments.remote.api.CommentsApi

class CommentsRemoteDataSourceImpl(private val api: CommentsApi) : CommentsRemoteDataSource {
    override suspend fun fetchComments(): List<Comment> {
       return api.fetchComments().toCommentList()
    }
}