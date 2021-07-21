package com.linx.jetpack_compose_control_learn.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 自定义的头部[Text]
 */
@Composable
fun ControlLearnHeader(text: String, modifier: Modifier = Modifier) {

    Text(
        text = text,
        modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 12.dp),
        fontSize = 22.sp,
        //字体粗细
        fontWeight = FontWeight.Bold
    )

}

/**
 * 用于描述的[Text]
 *
 * [AnnotatedString] 带有不同属性的字符串，例如可以在一串字符中设置某些字符的颜色、字体、大小等属性
 */
@Composable
fun ControlLearnDescription(text: String, showTopSpacer: Boolean = false, modifier: Modifier = Modifier) {

    //有注释的,可以添加风格
    val annotatedString = buildAnnotatedString {
        append(text)
        addStyle(style = SpanStyle(fontWeight = FontWeight.Bold), start = 0, end = 3)
    }

    if (showTopSpacer)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )

    Text(
        text = annotatedString,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 12.dp),
        fontSize = 16.sp
    )

}

/**
 * 例子的内容的text
 */
@Composable
fun ControlLearnExampleContentText(text: String, modifier: Modifier = Modifier) {

    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = Color.Gray,
        style = MaterialTheme.typography.body2
    )

}





















