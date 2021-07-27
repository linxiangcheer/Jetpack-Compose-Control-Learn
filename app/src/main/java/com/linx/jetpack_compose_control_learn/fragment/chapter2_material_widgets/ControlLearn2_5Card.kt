package com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.dp
import com.linx.jetpack_compose_control_learn.components.CodeCard
import com.linx.jetpack_compose_control_learn.components.ControlLearnDescription
import com.linx.jetpack_compose_control_learn.components.ControlLearnExampleContentText
import com.linx.jetpack_compose_control_learn.components.ControlLearnHeader
import com.linx.jetpack_compose_control_learn.ui.theme.*

@Composable
fun ControlLearn2_5Screen() {
    ControlLearn2_5ScreenContent()
}

@Composable
private fun ControlLearn2_5ScreenContent() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {

            val cardCode = remember {
                mutableStateListOf<String>(
                    "//修饰符", "modifier: Modifier = Modifier",
                    "//圆角", "shape: Shape = MaterialTheme.shapes.medium",
                    "//背景颜色", "backgroundColor: Color = MaterialTheme.colors.surface",
                    "//内容默认颜色", "contentColor: Color = contentColorFor(backgroundColor)",
                    "//边缘线", "border: BorderStroke? = null",
                    "//海拔", "elevation: Dp = 1.dp",
                    "content: @Composable () -> Unit"
                )
            }
            CodeCard(list = cardCode, codeTitle = "Card参数")

            ControlLearnDescription(text = "1-) shape (外形) 和 backgroundColor (背景颜色)")
            CardShapeAndBackgroundExample()

            ControlLearnDescription(text = "2-) contentColor (为Card内的控件设置默认颜色)")
            CardContentColorExample()

            ControlLearnDescription(text = "3-) border (边缘)")
            CardBorderExample()

            ControlLearnDescription(text = "4-) elevation (海拔)")
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
            backgroundColor = Color.Yellow,
            elevation = 5.dp
        ) {}

        Card(
            shape = CircleShape, modifier = modifier,
            backgroundColor = Color.LightGray,
            elevation = 5.dp
        ) {}

        Card(
            shape = CutCornerShape(10.dp),
            modifier = modifier,
            backgroundColor = Color.Green,
            elevation = 5.dp
        ) {}

        Card(
            shape = CutCornerShape(bottomEnd = 10.dp),
            modifier = modifier,
            backgroundColor = Color.Red,
            elevation = 5.dp
        ) {}

    }

}

/**
 * 为Card内的控件提供默认颜色
 */
@Composable
fun CardContentColorExample() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxSize(),
            backgroundColor = Color.Yellow,
            contentColor = Color.Red,
            elevation = 10.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "contentColor = Color.Red")
                Text(
                    text = "color = Color.Blue",
                    color = Color.Blue
                )
            }
        }

    }

}

/**
 * 给Card绘制边缘线
 */
@Composable
fun CardBorderExample() {

    //纵向渐变
    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color.Green,
            c_F06292,
            c_AED581
        )
    )

    //横向渐变
    val horizontalGradientBrush = Brush.horizontalGradient(
        colors = listOf(
            c_F06292,
            c_FFEB3B,
            c_80DEEA
        )
    )

    ControlLearnExampleContentText(
        text = "纵向渐变 Brush.verticalGradient(List<Color>())\n" +
                "横向渐变 Brush.horizontalGradient(List<Color>())"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Card(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = 10.dp, end = 5.dp),
            backgroundColor = Color.Yellow,
            contentColor = Color.Red,
            elevation = 10.dp,
            border = BorderStroke(5.dp, Color.Green)
        ) {}

        Card(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = 5.dp, end = 5.dp),
            backgroundColor = Color.Yellow,
            contentColor = Color.Red,
            elevation = 10.dp,
            border = BorderStroke(5.dp, verticalGradientBrush)
        ) {}

        Card(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = 5.dp, end = 10.dp),
            backgroundColor = Color.Yellow,
            contentColor = Color.Red,
            elevation = 10.dp,
            border = BorderStroke(5.dp, horizontalGradientBrush)
        ) {}

    }
}

/**
 * 为Card绘制阴影
 */
@Composable
fun CardElevationExample() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Card(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            backgroundColor = Color.Red,
            elevation = 10.dp
        ) {}

    }
}

