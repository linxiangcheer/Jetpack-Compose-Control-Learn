package com.linx.jetpack_compose_control_learn.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * 填满宽度的Row
 */
@Composable
fun FullWidthRow(
    modifier: Modifier = Modifier,
    horizontalArranhement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable () -> Unit
) {

    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArranhement,
        verticalAlignment = verticalAlignment
    ) {
        content.invoke()
    }

}

/**
 * 填满宽度的Column
 */
@Composable
fun FullWithColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier.fillMaxWidth()) {
        content.invoke()
    }
}