package com.hjsaraviad.core.data.comments.mappers

import com.hjsaraviad.core.data.comments.models.Comment
import com.hjsaraviad.core.data.comments.remote.models.CommentsResponse
import com.hjsaraviad.core.data.comments.remote.models.Hit
import com.hjsaraviad.core.database.comment.CommentEntity


fun CommentsResponse.toCommentList() = hits.map { hit ->
    hit.toComment()
}

private fun Hit.toComment() = Comment(
    author = author.orEmpty(),
    commentText = commentText.orEmpty(),
    storyTitle = storyTitle.orEmpty(),
    storyUrl = storyUrl.orEmpty(),
    tags = tags,
    createdAt = createdAt.orEmpty(),
    createdAtTimestamp = createdAtI ?: 0L,
    objectID = objectID.orEmpty(),
    parentID = parentId.toString(),
    storyID = storyId.toString(),
    updatedAt = updatedAt.orEmpty()
)

fun CommentEntity.toComment() = Comment(
    author = author,
    commentText = commentText,
    storyTitle = storyTitle,
    storyUrl = storyUrl,
    tags = tags,
    createdAt = createdAt,
    createdAtTimestamp = createdAtTimestamp,
    objectID = id,
    parentID = parentID,
    storyID = storyID,
    updatedAt = updatedAt
)

fun Comment.toCommentEntity() = CommentEntity(
    author = author,
    commentText = commentText,
    storyTitle = storyTitle,
    storyUrl = storyUrl,
    tags = tags,
    createdAt = createdAt,
    createdAtTimestamp = createdAtTimestamp,
    id = objectID,
    parentID = parentID,
    storyID = storyID,
    updatedAt = updatedAt
)