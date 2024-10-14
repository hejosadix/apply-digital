package com.hjsaraviad.features.webview.navigation

import androidx.activity.OnBackPressedDispatcher
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.hjsaraviad.features.webview.ui.WebViewScreen
import kotlinx.serialization.Serializable


@Serializable
data class WebViewRoute(val url: String)


fun NavController.navigateToWebView(url: String) {
    navigate(route = WebViewRoute(url = url))
}

fun NavGraphBuilder.webViewScreen(
    onBack: () -> Unit
) {
    composable<WebViewRoute> { backStackEntry ->
        val url = backStackEntry.toRoute<WebViewRoute>().url
        WebViewScreen(url = url, onBackPress = onBack)
    }
}
