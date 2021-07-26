package com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.linx.jetpack_compose_control_learn.components.ControlLearnDescription
import com.linx.jetpack_compose_control_learn.components.ControlLearnExampleContentText
import com.linx.jetpack_compose_control_learn.components.ControlLearnHeader

@Composable
fun ControlLearn2_5Screen() {
    ControlLearn2_5ScreenContent()
}

@Composable
private fun ControlLearn2_5ScreenContent() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {

            ControlLearnHeader(text = "Card")

            ControlLearnDescription(text = "1-) shape (外形) 和 backgroundColor (背景颜色)")
            CardShapeAndBackgroundExample()

            ControlLearnDescription(text = "2-) contentColor (为Card内的控件设置默认颜色)")
            CardContentColorExample()

            ControlLearnDescription(text = "3-) border (边缘)")
            CardBorderExample()

            ControlLearnDescription(text = "4-) elevation (阴影)")
            CardElevationExample()

        }
    }

}

/**
 * 为Card添加shape
 */
@Composable
fun CardShapeAndBackgroundExample() {
    
    ControlLearnExampleContentText(text = "backgroundColor = Yellow, modifier.background(Color.Red)")

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        val modifier = Modifier
            .aspectRatio(1f)
            .weight(1f)
            .padding(12.dp)

        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.background(Color.Red),
            backgroundColor = Color.Yellow
        ) {}

        Card(
            shape = CircleShape, modifier = modifier,
            backgroundColor = Color.LightGray
        ) {}

        Card(
            shape = CutCornerShape(10.dp),
            modifier = modifier,
            backgroundColor = Color.Green
        ) {}

        Card(
            shape = CutCornerShape(bottomEnd = 10.dp),
            modifier = modifier,
            backgroundColor = Color.Red
        ) {}

    }

}

/**
 * 为Card内的控件提供默认颜色
 */
@Composable
fun CardContentColorExample() {

}

/**
 * 给Card绘制边缘线
 */
@Composable
fun CardBorderExample() {

}

/**
 * 为Card绘制阴影
 */
@Composable
fun CardElevationExample() {

}

