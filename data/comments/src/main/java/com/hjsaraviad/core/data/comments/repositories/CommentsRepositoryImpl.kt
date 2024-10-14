package com.hjsaraviad.core.data.comments.repositories

import com.hjsaraviad.core.data.comments.datasources.CommentsRemoteDataSource
import com.hjsaraviad.core.data.comments.mappers.toComment
import com.hjsaraviad.core.data.comments.mappers.toCommentEntity
import com.hjsaraviad.core.data.comments.models.Comment
import com.hjsaraviad.core.database.comment.CommentDao
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class CommentsRepositoryImpl(
    private val commentsRemoteDataSource: CommentsRemoteDataSource,
    private val commentDao: CommentDao
) : CommentsRepository {
    override fun fetchComments() = flow {
        val result = commentsRemoteDataSource.fetchComments().map {
            it.toCommentEntity()
        }
        commentDao.insertAll(result)
        val data = commentDao.getAll().map {
            it.map { commentEntity -> commentEntity.toComment() }
        }
        emitAll(data)
    }

    override suspend fun deleteLocalComment(comment: Comment) {
        commentDao.delete(comment.toCommentEntity())
    }

}