package com.linx.jetpack_compose_control_learn.fragment.chapter1_basics

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.linx.jetpack_compose_control_learn.components.ControlLearnDescription
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





















