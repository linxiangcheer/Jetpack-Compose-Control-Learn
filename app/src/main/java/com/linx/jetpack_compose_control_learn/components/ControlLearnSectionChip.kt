package com.linx.jetpack_compose_control_learn.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.android.material.chip.Chip
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
        elevation = 0.dp,
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

/**
 * 带图片和关闭按钮的Chip
 */
@Composable
fun IconCloseButtonChip(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes drawableRes: Int = -1,
    closable: Boolean = false
) {

    Surface(
        modifier = modifier,
        elevation = 0.dp,
        color = Color(0xFFE0E0E0),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            //是否设置了图片
            if (drawableRes != -1) {
                Image(
                    painter = painterResource(id = drawableRes),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(20.dp)
                        .clip(
                            CircleShape
                        )
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(end = 8.dp)
            )

            //是否可关闭的
            if (closable) {
                CircleCloseButton(modifier = Modifier.padding(end = 8.dp))
            }

        }

    }

}

/**
 * 圆形关闭按钮
 */
@Composable
fun CircleCloseButton(modifier: Modifier) {

    Surface(
        color = Color.DarkGray,
        modifier = modifier,
        shape = CircleShape
    ) {
        IconButton(
            onClick = {}, modifier = Modifier
                .size(16.dp)
                .padding(1.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = null,
                tint = Color(0xFFE0E0E0)
            )
        }
    }

}

/**
 *
 */
@Composable
fun OutlinedChip(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes drawableRes: Int = -1,
    closable: Boolean = false
) {

    Surface(
        modifier = modifier,
        elevation = 0.dp,
        border = BorderStroke(width = 1.dp, Color(0xFFE0E0E0)),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            if (drawableRes != -1) {
                Image(
                    painter = painterResource(id = drawableRes),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(20.dp)
                        .clip(
                            CircleShape
                        )
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(end = 8.dp)
            )

            if (closable) {
                CircleCloseButton(modifier = Modifier.padding(end = 8.dp))
            }
        }

    }

}




















