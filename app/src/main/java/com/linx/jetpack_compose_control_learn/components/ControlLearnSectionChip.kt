package com.linx.jetpack_compose_control_learn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.linx.jetpack_compose_control_learn.ui.theme.color_E0

/**
 * 标签卡片样式
 */
@Composable
fun ControlLearnChip(
    modifier: Modifier = Modifier,
    text: String
) {

    Card(
        elevation =0.dp,
        modifier = modifier,
        backgroundColor = color_E0,
        shape = RoundedCornerShape(16.dp)
    ) {

        Row(
            modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
            //居中对齐
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    //圆
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colors.secondary)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = text)
        }

    }

}