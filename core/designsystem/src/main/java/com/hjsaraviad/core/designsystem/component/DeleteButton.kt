package com.hjsaraviad.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun DeleteButton(
    onDelete: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.Red)
            .clickable {
                onDelete()
            },
        contentAlignment = androidx.compose.ui.Alignment.Center,
    ) {
        Text(
            text = "Delete", modifier = Modifier.padding(horizontal = 25.dp),
            color = Color.White,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,

            )
    }
}