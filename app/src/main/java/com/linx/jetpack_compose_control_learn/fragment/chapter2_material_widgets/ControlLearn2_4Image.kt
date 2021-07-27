package com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState
import com.linx.jetpack_compose_control_learn.R
import com.linx.jetpack_compose_control_learn.components.*

@ExperimentalCoilApi
@Composable
fun ControlLearn2_4Screen() {
    ControlLearn2_4Content()
}

@ExperimentalCoilApi
@Composable
fun ControlLearn2_4Content() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {

            ControlLearnHeader(text = "Image")

            val list = listOf<String>(
                "//本地/网络图片保存的变量", "painter: Painter,",
                "//内容详情", "contentDescription: String?",
                "//修饰符", "modifier: Modifier = Modifier",
                "//对齐方式", "alignment: Alignment = Alignment.Center",
                "//图片缩放规则", "contentScale: ContentScale = ContentScale.Fit",
                "//透明度", "alpha: Float = DefaultAlpha",
                "//滤镜", "colorFilter: ColorFilter? = null",
                "",
                "//本地/网络图片保存的变量", "imageVector: ImageVector",
                "",
                "//bitmap图片", "bitmap: ImageBitmap"
            )
            CodeCard(list = list, codeTitle = "Image控件参数")

            ControlLearnDescription(text = "1-) Image布局绘制给定的ImageBitmap,用ImageVector或Painter")
            BasicImageExample()
            ImageVectorExample()
            ImagePainterExample()

            ControlLearnDescription(text = "2-) Image控件的contentScale用于设置图片的缩放规则")
            ImageContentScaleExample()

            ControlLearnDescription(text = "3-) 设置图像的shape (外形)和filter (滤镜)")
            ImageShapeAndFilterExample()

            ControlLearnDescription(text = "4-) 使用Coil从网络中获取图像资源并显示在界面上")
            ImageDownloadWithCoilExample()

            ControlLearnDescription(text = "5-) 使用Glide从网络中获取图像资源并显示在界面上 (0.14.0已弃用,并计划在1.0之前删除,请使用Coil)")
            ImageDownloadWithGlideExample()

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
 * 设置ContentScale图片缩放规则
 */
@Composable
fun ImageContentScaleExample() {

    ControlLearnExampleContentText(text = "modifier.aspectRatio(4/3f)设置控件宽高比例为4:3")

    /**
     * [Modifier.Modifier.aspectRatio(4 / 3f) -> 宽:高]
     */
    val imageModifier1 = Modifier
        .fillMaxWidth()
        .aspectRatio(4 / 3f)
        .background(Color.LightGray)

    FullWithColumn {

        val painter = painterResource(id = R.drawable.scenery1)

        ControlLearnExampleContentText(text = "默认的contentScale")
        Image(painter = painter, contentDescription = null)

        ControlLearnExampleContentText(text = "ContentScale.Crop (裁剪四周)")
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier1
        )

        ControlLearnExampleContentText(text = "ContentScale.FillBounds (铺满,有可能被拉伸)")
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = imageModifier1
        )

        ControlLearnExampleContentText(text = "ContentScale.FillHeight (铺满高,宽有可能显示不全或者留空)")
        Image(
            painter = painter,
            contentDescription = null,
            modifier = imageModifier1,
            contentScale = ContentScale.FillHeight
        )

        ControlLearnExampleContentText(text = "ContentScale.FillWidth (铺满宽,高有可能显示不全或者留空)")
        Image(
            painter = painter,
            contentDescription = null,
            modifier = imageModifier1,
            contentScale = ContentScale.FillWidth
        )

        ControlLearnExampleContentText(
            text = "ContentScale.Fit (保持源图片的宽高比进行缩放)\n" +
                    "**自动居中放置"
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = imageModifier1,
            contentScale = ContentScale.Fit
        )

        ControlLearnExampleContentText(
            text = "ContentScale.Inside (如果源图片大于目标,则缩放源,使长宽比保持在目标边界内;\n" +
                    "如果源图片在两个维度上都小于或等于目标,则其行为类似于None;即保持源图片在目标控件内)\n" +
                    "**自动居中放置"
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = imageModifier1,
            contentScale = ContentScale.Inside
        )

    }

}

/**
 * [shape] 圆角
 * [filter] 滤镜
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
                "使用GenericShape自定义shape (相关内容请到3-2查看)"
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

    ControlLearnExampleContentText(text = "filter (滤镜)")
    ControlLearnExampleContentText(text = "ColorFilter.tint (色调)")
    ControlLearnExampleContentText(
        text = "BlendMode.Darken (混合)\n" +
                "BlendMode.Lighten (发亮)\n" +
                "BlendMode.DstOver (在目标图像下合成源图像,背景;SrcOver(前景)与其相反)\n" +
                "BlendMode.Color (取源图像的色调和饱和度，以及目标图像的亮度; API等级29及以上使用)"
    )
    FullWidthRow(
        modifier = Modifier.height(100.dp),
        horizontalArranhement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = avatarBitmap1, contentDescription = null, colorFilter = ColorFilter.tint(
                //绿色,混合
                Color.Green, blendMode = BlendMode.Darken
            )
        )

        Image(
            painter = avatarBitmap2, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Lighten)
        )

        Image(
            painter = avatarBitmap3, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.DstOver)
        )

        Image(
            painter = avatarBitmap4, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Color)
        )

    }

    ControlLearnExampleContentText(
        text = "" +
                "BlendMode.Clear (删除源和目标图像，不留下任何内容)\n" +
                "BlendMode.Src (首先清除目标，然后绘制源图像)\n" +
                "BlendMode.Dst (源图像被丢弃，而目标图像不受影响)\n" +
                "BlendMode.Xor (对源和目标图像应用按位异或运算符,这使得透明度成为它们重叠的地方)"
    )

    FullWidthRow(
        modifier = Modifier.height(100.dp),
        horizontalArranhement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = avatarBitmap1, contentDescription = null, colorFilter = ColorFilter.tint(
                Color.Green, blendMode = BlendMode.Clear
            )
        )

        Image(
            painter = avatarBitmap2, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Src)
        )

        Image(
            painter = avatarBitmap3, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Dst)
        )

        Image(
            painter = avatarBitmap4, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Xor)
        )

    }

    ControlLearnExampleContentText(
        text = "BlendMode.SrcIn (显示源图像,但只显示两个图像重叠的地方)\n" +
                "BlendMode.DstIn (显示目标图像,但只显示两个图像重叠的地方)\n" +
                "BlendMode.SrcOut (显示源图像,但只显示两个图像不重叠的地方)\n" +
                "BlendMode.DstOut (显示目标图像,但只显示两个图像不重叠的地方)"
    )

    FullWidthRow(
        modifier = Modifier.height(100.dp),
        horizontalArranhement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = avatarBitmap1, contentDescription = null, colorFilter = ColorFilter.tint(
                Color.Green, blendMode = BlendMode.SrcIn
            )
        )

        Image(
            painter = avatarBitmap2, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.DstIn)
        )

        Image(
            painter = avatarBitmap3, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.SrcOut)
        )

        Image(
            painter = avatarBitmap4, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.DstOut)
        )

    }

    ControlLearnExampleContentText(
        text = "BlendMode.SrcAtop (在目标图像上合成源图像,但只在与目标图像重叠的地方)\n" +
                "BlendMode.DstAtop (在目标图像上合成源图像，但只在与源图像重叠的地方)\n" +
                "BlendMode.Plus (将源图像和目标图像的分量相加,图像像素的透明度降低了该图像对相应输出像素的贡献)\n" +
                "BlendMode.Modulate (将源图像和目标图像的颜色分量相乘,白(1.0) * 黑(0.0) = 黑(0.0))"
    )

    FullWidthRow(
        modifier = Modifier.height(100.dp),
        horizontalArranhement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = avatarBitmap1, contentDescription = null, colorFilter = ColorFilter.tint(
                Color.Green, blendMode = BlendMode.SrcAtop
            )
        )

        Image(
            painter = avatarBitmap2, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.DstAtop)
        )

        Image(
            painter = avatarBitmap3, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Plus)
        )

        Image(
            painter = avatarBitmap4, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Modulate)
        )

    }

    ControlLearnExampleContentText(
        text = "BlendMode.Screen (将源图像和目标图像分量的倒数相乘,得到倒数结果;黑(1,0) * 白(0,0) = 白(0,0))\n" +
                "BlendMode.Overlay (将源图像和目标图像的组件相乘,以使它们更有利于目标图像)\n" +
                "BlendMode.Darken (通过从每个颜色通道中选择最低的值来合成源和目标图像)\n" +
                "BlendMode.Lighten (通过从每个颜色通道中选择最高的值来合成源和目标图像)"
    )

    FullWidthRow(
        modifier = Modifier.height(100.dp),
        horizontalArranhement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = avatarBitmap1, contentDescription = null, colorFilter = ColorFilter.tint(
                Color.Green, blendMode = BlendMode.Screen
            )
        )

        Image(
            painter = avatarBitmap2, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Overlay)
        )

        Image(
            painter = avatarBitmap3, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Darken)
        )

        Image(
            painter = avatarBitmap4, contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Lighten)
        )

    }

    ControlLearnExampleContentText(text = "其他...均在API29及以上才能使用")

}

/**
 * 使用Coil获取网络图片
 * 实验性api
 */
@ExperimentalCoilApi
@Composable
private fun ImageDownloadWithCoilExample() {

    val url =
        "https://cdn-hz.skypixel.com/uploads/cn_files/photo/image/9e4d34c0-fd29-47d1-af5e-eedd9e673efb.jpg@!1920"

    val painter = rememberImagePainter(data = url)

    when (painter.state) {
        //加载中
        is ImagePainter.State.Loading -> {
            println("喂喂喂 Loading")
        }
        //请求失败
        is ImagePainter.State.Error -> {
            println("喂喂喂 Error")
        }
        //请求成功
        is ImagePainter.State.Success -> {
            println("喂喂喂 Success")
        }
        //请求尚未启动
        is ImagePainter.State.Empty -> {
            println("喂喂喂 Empty")
        }
    }

    Column(
        modifier = Modifier
            //外边框
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .height(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            //保持源图片宽高比,等比缩放
            contentScale = ContentScale.Fit
        )
    }

}

/**
 * 使用Glide获取网络图片
 *
 */
@Composable
fun ImageDownloadWithGlideExample() {

    val url =
        "https://cdn-hz.skypixel.com/uploads/cn_files/photo/image/9e4d34c0-fd29-47d1-af5e-eedd9e673efb.jpg@!1920"

    //可以为空的ImageBitmap,资源在被释放的时候为null
    var imageBitmap by remember {
        mutableStateOf<ImageBitmap?>(null)
    }

    //目标
    val target = object : CustomTarget<Bitmap>() {
        /**
         * 资源加载完成后将调用的方法
         * resource—加载的资源
         */
        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
            imageBitmap = resource.asImageBitmap()
        }

        /**
         * 一个强制性的生命周期回调,当负载被取消并释放其资源时调用
         */
        override fun onLoadCleared(placeholder: Drawable?) {
            imageBitmap = null
        }
    }

    //加载网络图片
    Glide.with(LocalContext.current).asBitmap().load(url).into(target)

    //渲染到界面上
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        imageBitmap?.let { imageBitmap ->
            Image(bitmap = imageBitmap, contentDescription = null)
        }

    }

}






















