package com.hjsaraviad.features.comments.utils

import com.hjsaraviad.core.data.comments.models.Comment

object FakeComments {
    fun generateFakeComments(): List<Comment> {
        return listOf(
            Comment(
                author = "author1",
                commentText = "commentText1",
                storyTitle = "storyTitle1",
                storyUrl = "storyUrl1",
                tags = listOf("tag1"),
                createdAt = "createdAt1",
                createdAtTimestamp = 1L,
                objectID = "objectID1",
                parentID = "parentID1",
                storyID = "storyID1",
                updatedAt = "updatedAt1"
            ),
            Comment(
                author = "author2",
                commentText = "commentText2",
                storyTitle = "storyTitle2",
                storyUrl = "storyUrl2",
                tags = listOf("tag2"),
                createdAt = "createdAt2",
                createdAtTimestamp = 2L,
                objectID = "objectID2",
                parentID = "parentID2",
                storyID = "storyID2",
                updatedAt = "updatedAt2",
            ),
            Comment(
                author = "author3",
                commentText = "commentText3",
                storyTitle = "storyTitle3",
                storyUrl = "storyUrl3",
                tags = listOf("tag3"),
                createdAt = "createdAt3",
                createdAtTimestamp = 3L,
                objectID = "objectID3",
                parentID = "parentID3",
                storyID = "storyID3",
                updatedAt = "updatedAt3",
            ),
        )
    }

}