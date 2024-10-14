package com.hjsaraviad.features.comments.navigation

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hjsaraviad.features.comments.ui.CommentsScreen
import com.hjsaraviad.features.comments.ui.CommentsViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object CommentsRoute


fun NavController.navigateToComments() {
    navigate(route = CommentsRoute)
}

fun NavGraphBuilder.commentsScreen(
    navigateToWebView: (String) -> Unit
) {
    composable<CommentsRoute> {
        val viewModel: CommentsViewModel = koinViewModel()
        val state = viewModel.state.collectAsStateWithLifecycle()
        CommentsScreen(
            state = state.value,
            onEvent = viewModel::onEvent,
            navigateToWebView = navigateToWebView
        )
    }
}
