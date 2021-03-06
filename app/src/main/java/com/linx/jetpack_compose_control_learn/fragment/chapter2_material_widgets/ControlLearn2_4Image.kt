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

            val list = listOf<String>(
                "//??????/???????????????????????????", "painter: Painter,",
                "//????????????", "contentDescription: String?",
                "//?????????", "modifier: Modifier = Modifier",
                "//????????????", "alignment: Alignment = Alignment.Center",
                "//??????????????????", "contentScale: ContentScale = ContentScale.Fit",
                "//?????????", "alpha: Float = DefaultAlpha",
                "//??????", "colorFilter: ColorFilter? = null",
                "",
                "//??????/???????????????????????????", "imageVector: ImageVector",
                "",
                "//bitmap??????", "bitmap: ImageBitmap"
            )
            CodeCard(list = list, codeTitle = "Image????????????")

            ControlLearnDescription(text = "1-) Image?????????????????????ImageBitmap,???ImageVector???Painter")
            BasicImageExample()
            ImageVectorExample()
            ImagePainterExample()

            ControlLearnDescription(text = "2-) Image?????????contentScale?????????????????????????????????")
            ImageContentScaleExample()

            ControlLearnDescription(text = "3-) ???????????????shape (??????)???filter (??????)")
            ImageShapeAndFilterExample()

            ControlLearnDescription(text = "4-) ??????Coil???????????????????????????????????????????????????")
            ImageDownloadWithCoilExample()

            ControlLearnDescription(text = "5-) ??????Glide??????????????????????????????????????????????????? (0.14.0?????????,????????????1.0????????????,?????????Coil)")
            ImageDownloadWithGlideExample()

        }
    }

}

/**
 * ???????????????
 */
@Composable
private fun BasicImageExample() {
    ControlLearnExampleContentText(text = "painterResource??????drawable??????????????????")
    val painter: Painter = painterResource(id = R.drawable.landscape1)
    Image(painter = painter, contentDescription = null)
}

/**
 * Vector - ??????
 */
@Composable
private fun ImageVectorExample() {

    ControlLearnExampleContentText(text = "ImageVector??????androidx.compose.material.icons???????????????????????????(????????????Icon??????)")

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
 * Painter??????onDraw????????????
 */
@Composable
private fun ImagePainterExample() {

    ControlLearnExampleContentText(text = "??????Painter??????(onDraw)????????????????????????????????????")
    ControlLearnExampleContentText(text = "Offset??????????????????????????????(0, 0),??????????????????,??????x??????, ??????y??????")

    val imageBitmap: ImageBitmap = ImageBitmap
        .imageResource(id = R.drawable.landscape1)

    val bitmapWidth = imageBitmap.width.toFloat()
    val bitmapHeight = imageBitmap.height.toFloat()

    val customPainter = remember {
        object : Painter() {
            //????????????
            override val intrinsicSize: Size
                get() = Size(bitmapWidth, bitmapHeight)

            override fun DrawScope.onDraw() {
                //????????????
                drawImage(imageBitmap)
                drawLine(
                    color = Color.Red,
                    //???????????? - ?????????
                    start = Offset(10F, 10F),
                    //???????????? - ?????????
                    end = Offset(bitmapWidth, bitmapHeight),
                    //????????????
                    strokeWidth = 5f
                )
            }
        }
    }

    Image(painter = customPainter, contentDescription = null)

}

/**
 * ??????ContentScale??????????????????
 */
@Composable
fun ImageContentScaleExample() {

    ControlLearnExampleContentText(text = "modifier.aspectRatio(4/3f)???????????????????????????4:3")

    /**
     * [Modifier.Modifier.aspectRatio(4 / 3f) -> ???:???]
     */
    val imageModifier1 = Modifier
        .fillMaxWidth()
        .aspectRatio(4 / 3f)
        .background(Color.LightGray)

    FullWithColumn {

        val painter = painterResource(id = R.drawable.scenery1)

        ControlLearnExampleContentText(text = "?????????contentScale")
        Image(painter = painter, contentDescription = null)

        ControlLearnExampleContentText(text = "ContentScale.Crop (????????????)")
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier1
        )

        ControlLearnExampleContentText(text = "ContentScale.FillBounds (??????,??????????????????)")
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = imageModifier1
        )

        ControlLearnExampleContentText(text = "ContentScale.FillHeight (?????????,????????????????????????????????????)")
        Image(
            painter = painter,
            contentDescription = null,
            modifier = imageModifier1,
            contentScale = ContentScale.FillHeight
        )

        ControlLearnExampleContentText(text = "ContentScale.FillWidth (?????????,????????????????????????????????????)")
        Image(
            painter = painter,
            contentDescription = null,
            modifier = imageModifier1,
            contentScale = ContentScale.FillWidth
        )

        ControlLearnExampleContentText(
            text = "ContentScale.Fit (???????????????????????????????????????)\n" +
                    "**??????????????????"
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = imageModifier1,
            contentScale = ContentScale.Fit
        )

        ControlLearnExampleContentText(
            text = "ContentScale.Inside (???????????????????????????,????????????,????????????????????????????????????;\n" +
                    "?????????????????????????????????????????????????????????,?????????????????????None;????????????????????????????????????)\n" +
                    "**??????????????????"
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
 * [shape] ??????
 * [filter] ??????
 */
@Composable
private fun ImageShapeAndFilterExample() {

    val avatarBitmap1 = painterResource(id = R.drawable.avatar_1_raster)
    val avatarBitmap2 = painterResource(id = R.drawable.avatar_2_raster)
    val avatarBitmap3 = painterResource(id = R.drawable.avatar_3_raster)
    val avatarBitmap4 = painterResource(id = R.drawable.avatar_4_raster)

    ControlLearnExampleContentText(text = "shape (??????)")
    ControlLearnExampleContentText(
        text = "RoundedCornerShape (??????)\n" +
                "CircleShape (??????)\n" +
                "CutCornerShape (???????????????)\n" +
                "??????GenericShape?????????shape (??????????????????3-2??????)"
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
                //??????????????????,???????????????????????????
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

    ControlLearnExampleContentText(text = "filter (??????)")
    ControlLearnExampleContentText(text = "ColorFilter.tint (??????)")
    ControlLearnExampleContentText(
        text = "BlendMode.Darken (??????)\n" +
                "BlendMode.Lighten (??????)\n" +
                "BlendMode.DstOver (?????????????????????????????????,??????;SrcOver(??????)????????????)\n" +
                "BlendMode.Color (???????????????????????????????????????????????????????????????; API??????29???????????????)"
    )
    FullWidthRow(
        modifier = Modifier.height(100.dp),
        horizontalArranhement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = avatarBitmap1, contentDescription = null, colorFilter = ColorFilter.tint(
                //??????,??????
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
                "BlendMode.Clear (????????????????????????????????????????????????)\n" +
                "BlendMode.Src (??????????????????????????????????????????)\n" +
                "BlendMode.Dst (????????????????????????????????????????????????)\n" +
                "BlendMode.Xor (????????????????????????????????????????????????,?????????????????????????????????????????????)"
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
        text = "BlendMode.SrcIn (???????????????,???????????????????????????????????????)\n" +
                "BlendMode.DstIn (??????????????????,???????????????????????????????????????)\n" +
                "BlendMode.SrcOut (???????????????,??????????????????????????????????????????)\n" +
                "BlendMode.DstOut (??????????????????,??????????????????????????????????????????)"
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
        text = "BlendMode.SrcAtop (?????????????????????????????????,???????????????????????????????????????)\n" +
                "BlendMode.DstAtop (????????????????????????????????????????????????????????????????????????)\n" +
                "BlendMode.Plus (??????????????????????????????????????????,????????????????????????????????????????????????????????????????????????)\n" +
                "BlendMode.Modulate (????????????????????????????????????????????????,???(1.0) * ???(0.0) = ???(0.0))"
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
        text = "BlendMode.Screen (????????????????????????????????????????????????,??????????????????;???(1,0) * ???(0,0) = ???(0,0))\n" +
                "BlendMode.Overlay (??????????????????????????????????????????,????????????????????????????????????)\n" +
                "BlendMode.Darken (???????????????????????????????????????????????????????????????????????????)\n" +
                "BlendMode.Lighten (???????????????????????????????????????????????????????????????????????????)"
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

    ControlLearnExampleContentText(text = "??????...??????API29?????????????????????")

}

/**
 * ??????Coil??????????????????
 * ?????????api
 */
@ExperimentalCoilApi
@Composable
private fun ImageDownloadWithCoilExample() {

    val url =
        "https://cdn-hz.skypixel.com/uploads/cn_files/photo/image/9e4d34c0-fd29-47d1-af5e-eedd9e673efb.jpg@!1920"

    val painter = rememberImagePainter(data = url)

    when (painter.state) {
        //?????????
        is ImagePainter.State.Loading -> {
            println("????????? Loading")
        }
        //????????????
        is ImagePainter.State.Error -> {
            println("????????? Error")
        }
        //????????????
        is ImagePainter.State.Success -> {
            println("????????? Success")
        }
        //??????????????????
        is ImagePainter.State.Empty -> {
            println("????????? Empty")
        }
    }

    Column(
        modifier = Modifier
            //?????????
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .height(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            //????????????????????????,????????????
            contentScale = ContentScale.Fit
        )
    }

}

/**
 * ??????Glide??????????????????
 *
 */
@Composable
fun ImageDownloadWithGlideExample() {

    val url =
        "https://cdn-hz.skypixel.com/uploads/cn_files/photo/image/9e4d34c0-fd29-47d1-af5e-eedd9e673efb.jpg@!1920"

    //???????????????ImageBitmap,??????????????????????????????null
    var imageBitmap by remember {
        mutableStateOf<ImageBitmap?>(null)
    }

    //??????
    val target = object : CustomTarget<Bitmap>() {
        /**
         * ???????????????????????????????????????
         * resource??????????????????
         */
        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
            imageBitmap = resource.asImageBitmap()
        }

        /**
         * ????????????????????????????????????,?????????????????????????????????????????????
         */
        override fun onLoadCleared(placeholder: Drawable?) {
            imageBitmap = null
        }
    }

    //??????????????????
    Glide.with(LocalContext.current).asBitmap().load(url).into(target)

    //??????????????????
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






















