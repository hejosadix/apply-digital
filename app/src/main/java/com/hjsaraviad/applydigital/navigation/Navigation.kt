package com.hjsaraviad.applydigital.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.hjsaraviad.features.comments.navigation.CommentsRoute
import com.hjsaraviad.features.comments.navigation.commentsScreen
import com.hjsaraviad.features.webview.navigation.navigateToWebView
import com.hjsaraviad.features.webview.navigation.webViewScreen

@Composable
internal fun MainNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = CommentsRoute) {
        commentsScreen(
            navigateToWebView = { url ->
                navController.navigateToWebView(
                    url = url
                )
            }
        )
        webViewScreen(
            onBack = {
                navController.popBackStack()
            }
        )
    }
}