package com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.linx.jetpack_compose_control_learn.components.ControlLearnDescription
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

            ControlLearnDescription(text = "1-) shape (外形)")
            CardShapeExample()

            ControlLearnDescription(text = "2-) backgroundColor (背景颜色)")
            CardBackgroundColorExample()

            ControlLearnDescription(text = "3-) contentColor (为Card内的控件设置默认颜色)")
            CardContentColorExample()

            ControlLearnDescription(text = "4-) border (边缘)")
            CardBorderExample()

            ControlLearnDescription(text = "5-) elevation (阴影)")
            CardElevationExample()

        }
    }

}

/**
 * 为Card添加shape
 */
@Composable
fun CardShapeExample() {

}

/**
 * 为Card添加背景颜色
 */
@Composable
fun CardBackgroundColorExample() {

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

