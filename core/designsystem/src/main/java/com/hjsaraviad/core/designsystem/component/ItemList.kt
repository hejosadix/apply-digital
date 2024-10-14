package com.hjsaraviad.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ItemList(
    label: String,
    description: String,
    onClick: () -> Unit,
    isLast: Boolean = false
) {
    Column(
        modifier = Modifier
            .height(90.dp)
            .clickable {
                onClick()
            },
        verticalArrangement = Arrangement.SpaceAround
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 16.dp),
            text = label,
            maxLines = 2,
            overflow = TextOverflow.Clip,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 16.dp),
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        if (!isLast) {
            HorizontalDivider(color = Color.Black, thickness = 1.dp)
        }
    }
}

