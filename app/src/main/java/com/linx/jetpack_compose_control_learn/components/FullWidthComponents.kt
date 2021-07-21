package com.linx.jetpack_compose_control_learn.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * 填满宽度的Row
 */
@Composable
fun FullWidthRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Row(modifier.fillMaxWidth()) {
        content.invoke()
    }
    
}