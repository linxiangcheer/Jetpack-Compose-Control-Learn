package com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.linx.jetpack_compose_control_learn.R
import com.linx.jetpack_compose_control_learn.components.*

@Composable
fun ControlLearn2_4Screen() {
    ControlLearn2_4Content()
}

@Composable
fun ControlLearn2_4Content() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {

            ControlLearnHeader(text = "Image")

            ControlLearnDescription(text = "1-) Image布局绘制给定的ImageBitmap,用ImageVector或Painter")
            BasicImageExample()
            ImageVectorExample()
            ImagePainterExample()

            ControlLearnDescription(text = "2-) 设置图像的shape (外形)和filter (过滤)")
            ImageShapeAndFilterExample()

        }
    }

}

/**
 * 基本的使用
 */
@Composable
private fun BasicImageExample() {
    ControlLearnExampleContentText(text = "painterResource加载drawable内的图片资源")
    val painter: Painter = painterResource(id = R.drawable.landscape1)
    Image(painter = painter, contentDescription = null)
}

/**
 * Vector - 载体
 */
@Composable
private fun ImageVectorExample() {

    ControlLearnExampleContentText(text = "ImageVector加载androidx.compose.material.icons包内提供的图标资源(推荐使用Icon控件)")

    FullWidthRow(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalArranhement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            imageVector = Icons.Default.Call,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )

        Image(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )

        Image(
            imageVector = Icons.Default.Done,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )

        Image(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )

    }
}

/**
 * Painter重写onDraw绘制方法
 */
@Composable
private fun ImagePainterExample() {

    ControlLearnExampleContentText(text = "使用Painter绘制(onDraw)的时候添加自己想要的东西")
    ControlLearnExampleContentText(text = "Offset坐标系左上方的位置为(0, 0),从此位置开始,往右x增加, 往下y增加")

    val imageBitmap: ImageBitmap = ImageBitmap
        .imageResource(id = R.drawable.landscape1)

    val bitmapWidth = imageBitmap.width.toFloat()
    val bitmapHeight = imageBitmap.height.toFloat()

    val customPainter = remember {
        object : Painter() {
            //固有尺寸
            override val intrinsicSize: Size
                get() = Size(bitmapWidth, bitmapHeight)

            override fun DrawScope.onDraw() {
                //绘制图片
                drawImage(imageBitmap)
                drawLine(
                    color = Color.Red,
                    //开始位置 - 左上角
                    start = Offset(10F, 10F),
                    //结束位置 - 右下角
                    end = Offset(bitmapWidth, bitmapHeight),
                    //笔画宽度
                    strokeWidth = 5f
                )
            }
        }
    }

    Image(painter = customPainter, contentDescription = null)

}

/**
 * [shape]
 * [filter]
 */
@Composable
private fun ImageShapeAndFilterExample() {

    val avatarBitmap1 = painterResource(id = R.drawable.avatar_1_raster)
    val avatarBitmap2 = painterResource(id = R.drawable.avatar_2_raster)
    val avatarBitmap3 = painterResource(id = R.drawable.avatar_3_raster)
    val avatarBitmap4 = painterResource(id = R.drawable.avatar_4_raster)

    ControlLearnExampleContentText(text = "shape (外形)")
    ControlLearnExampleContentText(
        text = "RoundedCornerShape (圆角)\n" +
                "CircleShape (圆形)\n" +
                "CutCornerShape (裁剪四个角)\n" +
                "使用GenericShape自定义shape"
    )

    FullWidthRow(
        modifier = Modifier.height(100.dp),
        horizontalArranhement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = avatarBitmap1, contentDescription = null,
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
        )

        Image(
            painter = avatarBitmap2, contentDescription = null,
            modifier = Modifier
                //阴影也要裁剪,要不然背景会很奇怪
                .shadow(20.dp, CircleShape)
                .clip(CircleShape)
        )

        Image(
            painter = avatarBitmap3, contentDescription = null,
            modifier = Modifier
                .shadow(20.dp, CutCornerShape(10.dp))
                .clip(CutCornerShape(10.dp)),
        )

        Image(
            painter = avatarBitmap4, contentDescription = null,
            modifier = Modifier.shadow(10.dp, diamondShape, clip = true)
        )

        Image(
            painter = avatarBitmap4, contentDescription = null,
            modifier = Modifier.shadow(10.dp, triangleShape, clip = true)
        )

    }

}






















