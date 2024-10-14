package com.hjsaraviad.features.webview.ui

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun WebViewScreen(
    url: String, onBackPress: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { },
                navigationIcon = {
                    Row(modifier = Modifier.clickable {
                        onBackPress()
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Back"
                        )
                        Text(
                            text = "Back",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    WebView(context).apply {
                        settings.javaScriptEnabled = true
                        webViewClient = WebViewClient()

                        settings.loadWithOverviewMode = true
                        settings.useWideViewPort = true
                        settings.setSupportZoom(true)
                    }
                },
                update = { webView ->
                    webView.loadUrl(url)
                }
            )

        }
    }
}