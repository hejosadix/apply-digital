package com.hjsaraviad.features.comments.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjsaraviad.core.data.comments.models.Comment
import com.hjsaraviad.core.designsystem.component.DeleteButton
import com.hjsaraviad.core.designsystem.component.ItemList
import com.hjsaraviad.core.designsystem.component.SwipeItemWithActions

@Composable
internal fun CommentsScreen(
    state: CommentsUiState,
    onEvent: (CommentsUiEvent) -> Unit,
    navigateToWebView: (String) -> Unit
) {
    Scaffold() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            CommentsContent(comments = state.comments,
                isRefreshing = state.isLoading,
                onRefresh = { onEvent(CommentsUiEvent.LoadData) },
                onClick = { url -> navigateToWebView(url) },
                onDelete = { key -> onEvent(CommentsUiEvent.OnCommentDelete(key)) })

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CommentsContent(
    comments: List<Comment>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    onClick: (url: String) -> Unit,
    onDelete: (key: String) -> Unit
) {
    val state = rememberPullToRefreshState()
    PullToRefreshBox(
        modifier = Modifier.padding(),
        state = state,
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
    ) {
        LazyColumn(
            Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp),
        ) {
            itemsIndexed(comments, key = { _, comment -> comment.objectID }) { index, comment ->
                SwipeItemWithActions(
                    isRevealed = false,
                    actions = {
                        DeleteButton(onDelete = { onDelete(comment.objectID) })
                    },
                ) {
                    ItemList(
                        label = comment.storyTitle,
                        description = "${comment.author} - ${comment.createdAt}",
                        onClick = { onClick(comment.storyUrl) },
                        isLast = index == comments.size - 1
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CommentsScreenPreview() {
    CommentsScreen(state = CommentsUiState(
        isLoading = false,
        comments = listOf(
            Comment(
                author = "Author",
                commentText = "Comment Text",
                storyTitle = "Story Title",
                storyUrl = "Story Url",
                tags = emptyList(),
                createdAt = "Created At",
                createdAtTimestamp = 0,
                objectID = "Object ID",
                parentID = null,
                storyID = "Story ID",
                updatedAt = "Updated At"
            )
        ),
    ), onEvent = {},
        navigateToWebView = {}
    )
}

