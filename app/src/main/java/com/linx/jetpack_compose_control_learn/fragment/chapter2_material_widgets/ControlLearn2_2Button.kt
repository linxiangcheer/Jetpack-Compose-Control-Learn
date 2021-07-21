package com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets

import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.android.material.chip.Chip
import com.linx.jetpack_compose_control_learn.R
import com.linx.jetpack_compose_control_learn.components.*


@Composable
fun ControlLearn2_2Screen() {
    ControlLearnButtonContent()
}

@Composable
fun ControlLearnButtonContent() {

    LazyColumn(Modifier.fillMaxSize()) {

        item {

            val paddingModifier = Modifier.padding(8.dp)

            ControlLearnHeader(text = "Button + Icon Button")
            ControlLearnExampleContentText(text = "TextButton 只有文本没有边框的Text")
            ControlLearnExampleContentText(text = "OutlinedButton 带边框的Text")

            ButtonExample(paddingModifier)
            ButtonWithIconExample(paddingModifier)

            ControlLearnExampleContentText(
                text = "Button设置默认颜色 " +
                        "colors = ButtonDefaults.buttonColors (backgroundColor、contentColor)"
            )
            ButtonBackgroundExample(paddingModifier)
            GradientButtonExample(paddingModifier)

            ControlLearnExampleContentText(text = "enabled = false (不可点击/未激活)")
            DisabledButtonExample(paddingModifier)

            IconButtonExample(paddingModifier)
            ControlLearnExampleContentText(text = "带按钮大小改变动画的按钮")
            AnimatedIconButtonExample(paddingModifier)

            ControlLearnHeader(text = "Floating Action Button (浮动按钮)")
            ControlLearnExampleContentText(text = "浮动按钮通常代表了一个页面的主要行为")
            ControlLearnExampleContentText(text = "ExtendedFloatingActionButton 包含文本和可选图标的扩展FAB")
            FloatingActionButtonExample(paddingModifier)

            ControlLearnHeader(text = "Chip (流式布局标签)")
            ControlLearnExampleContentText(text = "目前只能用其他控件组合实现")
            ChipExample(paddingModifier)

        }

    }

}

@Composable
fun ButtonExample(modifier: Modifier) {

    FullWidthRow {
        Button(onClick = {}, modifier) {
            Text(text = "Button")
        }

        TextButton(onClick = {}, modifier) {
            Text(text = "TextButton")
        }

        OutlinedButton(onClick = {}, modifier) {
            Text(text = "Outlined")
        }
    }

    FullWidthRow {
        Button(onClick = {}, modifier, shape = RoundedCornerShape(15.dp)) {
            Text(text = "圆角Button")
        }

        Button(
            onClick = {}, modifier, shape = RoundedCornerShape(
                topStartPercent = 30,
                topEndPercent = 0,
                bottomStartPercent = 0,
                bottomEndPercent = 0,
            )
        ) {
            Text(text = "部分圆角")
        }

        Button(onClick = {}, modifier, shape = CutCornerShape(20)) {
            Text(text = "四个角裁剪")
        }
    }

}

/**
 * 不可点击的Button
 */
@Composable
fun DisabledButtonExample(modifier: Modifier) {

    FullWidthRow {

        Button(onClick = {}, modifier, enabled = false) {
            Text(text = "Button")
        }

        TextButton(onClick = {}, modifier, enabled = false) {
            Text(text = "TextButton")
        }

        OutlinedButton(onClick = {}, modifier, enabled = false) {
            Text(text = "OutlinedButton")
        }

    }

}

@Composable
fun ButtonWithIconExample(modifier: Modifier) {

    FullWidthRow {
        Button(onClick = {}, modifier) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
                Text(text = "Icon+Text")
            }
        }

        Button(onClick = {}, modifier) {
            Text(text = "Text+Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        Button(onClick = {}, modifier, shape = RoundedCornerShape(20)) {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
        }
    }

    FullWidthRow {
        OutlinedButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            )
            Text(text = "Icon+Text+Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun ButtonBackgroundExample(modifier: Modifier) {

    FullWidthRow {

        Button(
            onClick = {}, modifier = modifier, colors = ButtonDefaults.buttonColors(
                //背景
                backgroundColor = Color(0xffF57C00),
                //内容颜色
                contentColor = Color(0xffB2EBF2)
            )
        ) {
            Text(text = "Button")
        }

        TextButton(
            onClick = {}, modifier = modifier, colors = ButtonDefaults.textButtonColors(
                contentColor = Color(0xff8BC34A)
            )
        ) {
            Text(text = "TextButton")
        }

        OutlinedButton(
            onClick = {}, modifier, colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xff795548)
            )
        ) {
            Text(text = "Outlined")
        }

    }

}

/**
 * 背景带渐变的Button
 */
@Composable
fun GradientButtonExample(modifier: Modifier) {

    val horizontalGradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xffF57F17),
            Color(0xffFFEE58),
            Color(0xffFFF9C4)
        )
    )

    val vericalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xff4E342E),
            Color(0xff8D6E63),
            Color(0xffD7CCC8)
        )
    )

    FullWidthRow {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(20))
                .background(brush = horizontalGradientBrush)
                .clickable(onClick = {})
                //todo then用来组合两个Modifier并保持顺序执行
                .then(modifier)
        ) {
            Text(text = "横向渐变")
        }

        Column(
            modifier = modifier
                .clip(RoundedCornerShape(20))
                .background(brush = vericalGradientBrush)
                .clickable(onClick = {})
                .then(modifier)
        ) {
            Text(text = "纵向渐变")
        }
    }

    //按钮内部文字背景渐变
    FullWidthRow {
        Button(onClick = {}, contentPadding = PaddingValues(0.dp)) {
            Text(
                text = "按钮内部文字背景纵向渐变",
                modifier = modifier
                    .height(ButtonDefaults.MinHeight)
                    .align(Alignment.CenterVertically)
                    .background(brush = vericalGradientBrush)
                    .padding(8.dp)
            )
        }
    }

}

/**
 * 图片按钮
 */
@Composable
fun IconButtonExample(modifier: Modifier) {

    FullWidthRow {
        IconButton(onClick = {}, modifier) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
        }

        var checked by remember {
            mutableStateOf(true)
        }

        //开关按钮
        IconToggleButton(
            //默认是否选中
            checked = checked,
            //点击之后改变 回调函数
            onCheckedChange = {
                //点击之后按钮的状态会在it中
                checked = it
                println("当前的回调 $it")
            },
            //todo 这里取消波纹的代码是无效的,需要重写这个Button然后将indication设置为null才行
            //https://docs.compose.net.cn/elements/iconbutton/
            modifier = modifier.clickable(
                onClick = {},
                indication = null,
                interactionSource = MutableInteractionSource()
            )
        ) {

            //色调
            val tint = if (checked) Color(0xffE91E63) else Color(0xffB0BEC5)

            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null, tint = tint)

        }

    }

}

/**
 * 带动画效果的IconButton
 */
@Composable
fun AnimatedIconButtonExample(modifier: Modifier) {

    /**
     * 1、点击按钮 change = true,这个时候重新执行@ReCompose代码块
     * 2、按钮大小递增为32.dp
     * 3、到达32.dp的时候change = false,这时候又重新执行@ReCompose代码块
     * 4、按钮大小递减为24.dp
     */
    FullWidthRow {
        //是否改变
        var change by remember {
            mutableStateOf(false)
        }

        //是否选中
        var checked by remember {
            mutableStateOf(false)
        }

        val buttonSize by animateDpAsState(targetValue = if (change) 40.dp else 24.dp)

        if (buttonSize == 40.dp) {
            //执行缩小动画
            change = false
        }

        IconToggleButton(
            checked = checked,
            onCheckedChange = {
                //执行放大动画
                change = true
                //选中状态改变
                checked = it
            },
            modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = if (checked) Color.Red else Color.Gray,
                modifier = Modifier.size(buttonSize)
            )
        }
    }

}

/**
 * 浮动行为的按钮
 */
@Composable
fun FloatingActionButtonExample(modifier: Modifier) {
    FullWidthRow {

        FloatingActionButton(onClick = {}, modifier = modifier) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        }

        //按钮颜色
        FloatingActionButton(
            onClick = {},
            modifier = modifier,
            backgroundColor = Color(0xffFFA000)
        ) {
            //图标颜色
            Icon(imageVector = Icons.Filled.Done, contentDescription = null, tint = Color.White)
        }

        //包含文本和可选图标的扩展FAB
        ExtendedFloatingActionButton(
            text = {
                Text(text = "文本")
            },
            onClick = {},
            modifier
        )

        //包含文本和可选图标的扩展FAB
        ExtendedFloatingActionButton(
            text = {
                Text(text = "文本+图标")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    tint = Color.White
                )
            },
            onClick = {},
            backgroundColor = Color(0xffEC407A),
            modifier = modifier
        )

    }
}

/**
 * [Chip]流式布局标签
 * 暂时没有官方控件，但是我们可以通过其他控件组合在一起实现
 */
@Composable
fun ChipExample(modifier: Modifier) {

    val context = LocalContext.current

    ControlLearnChip(text = "用其他控件实现的Chip", modifier = modifier.clickable {
        Toast.makeText(context, "点击用其他控件实现的Chip", Toast.LENGTH_SHORT).show()
    })

    //有图片和关闭按钮的chip
    IconCloseButtonChip(
        text = "有图片和关闭按钮的Chip",
        modifier = modifier,
        drawableRes = R.drawable.avatar_1_raster,
        closable = true
    )

    IconCloseButtonChip(
        text = "无关闭按钮的Chip",
        modifier = modifier,
        drawableRes = R.drawable.avatar_1_raster
    )

    //带边框有图片和关闭按钮的chip
    OutlinedChip(
        text = "带边框有图片和关闭按钮的Chip",
        modifier = modifier,
        drawableRes = R.drawable.avatar_2_raster,
        closable = true
    )

    OutlinedChip(
        text = "带边框有图片无关闭按钮的Chip",
        modifier = modifier,
        drawableRes = R.drawable.avatar_2_raster
    )

}













