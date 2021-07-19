package com.linx.jetpack_compose_control_learn.fragment.chapter1_basics

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.linx.jetpack_compose_control_learn.components.ControlLearnDescription
import com.linx.jetpack_compose_control_learn.components.ControlLearnExampleContentText
import com.linx.jetpack_compose_control_learn.components.ControlLearnHeader

/**
 * 关于 [Surface]、[Shape]和[Click]
 */
@Composable
fun ControlLearn1_2ClickSurfaceAndClicks() {
    ControlLearnContent()
}

@Composable
private fun ControlLearnContent() {

    LazyColumn(Modifier.fillMaxSize()) {
        item {

            ControlLearnHeader(text = "Clickable")
            ControlLearnDescription(
                text = "1-) 添加Modifier.clickable属性使控件可点击; " +
                        "Modifier.clickable之前设置padding,那么点击区域就不会作用到此padding中"
            )
            ClickableModifierExample()

            ControlLearnHeader(text = "Surface")
            ControlLearnDescription(text = "2-) Surface会根据shape属性所描述的形状来裁剪它的子元素")
            ControlLearnExampleContentText(text = "aspectRatio (方形长宽比例1:1)")
            ControlLearnExampleContentText(text = "RectangleShape (长方形)")
            ControlLearnExampleContentText(text = "RoundedCornerShape (圆角)")
            ControlLearnExampleContentText(text = "CircleShape (原型)")
            ControlLearnExampleContentText(text = "CutCornerShape (裁剪四个角)")
            SurfaceShapeExample()

            ControlLearnDescription(text = "3-) 可以设置阴影深度和边框")
            ControlLearnExampleContentText(text = "border = BorderStroke(宽度, 颜色)")
            ControlLearnExampleContentText(text = "elevation (阴影)")
            ControlLearnExampleContentText(text = "border (边框)")
            SurfaceZIndexExample()

            ControlLearnDescription(text = "4-) 可以设置文本和图标组件内容的颜色")
            ControlLearnExampleContentText(text = "contentColor (为平面组件指定一个首选颜色,作为文本和图标组件内容的默认颜色)")
            SurfaceContentColorExample()

            ControlLearnDescription(text = "5-) ")

        }
    }

}

/**
 * [clickable]和[padding]
 */
@Composable
fun ClickableModifierExample() {

    //返回可使用的上下文; 返回最近的compontionlocalprovider组件提供的值
    val content = LocalContext.current

    Row(Modifier.height(120.dp)) {

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color(0xFF388E3C))
                .clickable {
                    Toast
                        .makeText(content, "点击左边的布局", Toast.LENGTH_SHORT)
                        .show()
                },
            //纵
            verticalArrangement = Arrangement.Center,
            //横
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ClickTexts()
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color(0xFF1E88E5))
                //clickable之前设置padding,点击区域不包括此padding
                .padding(10.dp)
                .clickable {
                    Toast
                        .makeText(content, "点击右边的布局", Toast.LENGTH_SHORT)
                        .show()
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ClickTexts()
        }

    }

}

@Composable
fun ClickTexts() {
    Text(text = "点击我", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
}

/**
 * [Surface]裁剪
 */
@Composable
fun SurfaceShapeExample() {

    Row {

        val modifier = Modifier
            //方形比例 长宽比1:1
            .aspectRatio(1f)
            //确保平分控件
            .weight(1f)
            .padding(12.dp)

        Surface(
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
                .padding(12.dp),
            color = Color(0xFFFDD835),
            //长方形
            shape = RectangleShape
        ) {}

        //圆角
        Surface(
            shape = RoundedCornerShape(5.dp),
            modifier = modifier,
            color = Color(0xFFF4511E)
        ) {}

        //圆形
        Surface(
            shape = CircleShape,
            modifier = modifier,
            color = Color(0xFF26C6DA)
        ) {}

        //裁剪四个角
        Surface(
            shape = CutCornerShape(10.dp),
            modifier = modifier,
            color = Color(0xFF7E57C2)
        ) {}

    }

}

/**
 * [elevation] 设置Z轴
 * [border] 边框
 */
@Composable
fun SurfaceZIndexExample() {

    Row {

        val modifier = Modifier
            .aspectRatio(1f)
            .weight(1f)
            .padding(12.dp)

        Surface(
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .height(20.dp)
                .padding(12.dp),
            color = Color(0xFFFDD835),
            elevation = 5.dp,
            //边框 宽度+颜色
            border = BorderStroke(5.dp, color = Color(0xFFFF6F00))
        ) {}

        Surface(
            shape = RoundedCornerShape(5.dp),
            modifier = modifier,
            color = Color(0xFFF4511E),
            elevation = 10.dp,
            border = BorderStroke(3.dp, Color(0xFF6D4C41))
        ) {}

        Surface(
            shape = CircleShape,
            modifier = modifier,
            color = Color(0xFF26C6DA),
            elevation = 5.dp,
            border = BorderStroke(2.dp, Color(0xFF004D40))
        ) {}

        Surface(
            shape = CutCornerShape(topStart = 20.dp),
            modifier = modifier,
            color = Color(0xFFB2FF59),
            elevation = 15.dp,
            border = BorderStroke(2.dp, color = Color(0xFFd50000))
        ) {}

    }

}

/**
 * [ContentColor] 内容颜色
 *
 * Material Surface 是 Material Design 的核心隐喻，每个平面都存在于一个特定的高度，
 * 这影响了这块平面在视觉上与其他平面的关系以及该平面如何投射阴影。
 * 可以将 Surface 理解成是一个容器，每个界面元素都基于这个容器，容器可以有不同的高度，可以位于不同的位置。
 *
 * Surface 主要负责：
 * 剪裁：Surface 会根据 shape 属性所描述的形状来裁剪它的子元素。
 * 高度：Surface 会绘制阴影来表示平面的深度，而这个深度由高度属性 (Elevation) 表示。
 *      如果传递的形状是凹进去的，那么在 Android 版本小于 10 的情况下，阴影不会被画出来。
 * 边框：如果形状有边框，那么它也会被画出来。
 * 背景：Surface 在 shape 指定的形状上填充颜色。如果颜色是 Colors.surface，
 *      将使用 LocalElevationOverlay 中的 ElevationOverlay 来进行叠加--默认情况下，这只会发生在深色主题中。
 *      覆盖的颜色取决于这个 Surface 的高度，以及任何父级 Surface 设置的 LocalAbsolutelevation。
 *      这可以确保一个 Surface 的叠加高度永远不会比它的祖先低，因为它是所有先前 Surface 的高度的总和
 * 内容颜色：Surface 使用 contentColor 为这个平面的内容指定一个首选的颜色--这个颜色被文本和图标组件作为默认颜色使用
 */
@Composable
fun SurfaceContentColorExample() {

    Surface(
        modifier = Modifier.padding(12.dp),
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFFDD835),
        contentColor = Color(0xFF26C6DA),
    ) {
        Text(
            buildAnnotatedString {
                append("Surface内部的文本使用Surface的contentColor颜色作为")
                //后面拼接不同风格的字
                withStyle(style = SpanStyle(fontWeight = FontWeight.W900, fontSize = 20.sp, color = Color.White)) {
                    append("默认颜色")
                }
            },
            modifier = Modifier.padding(12.dp),
            textAlign = TextAlign.Center
        )
    }

}




















