package com.linx.jetpack_compose_control_learn.fragment.chapter1_basics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.linx.jetpack_compose_control_learn.components.ControlLearnDescription
import com.linx.jetpack_compose_control_learn.components.ControlLearnExampleContentText
import com.linx.jetpack_compose_control_learn.components.ControlLearnHeader
import com.linx.jetpack_compose_control_learn.ui.theme.c_FF9800
import com.linx.jetpack_compose_control_learn.ui.theme.c_FFA726
import com.linx.jetpack_compose_control_learn.ui.theme.c_FFB74D

/**
 * 关于[Column]、[Row]、[Box]和[Modifier]
 *
 * [Column]上下结构
 * [Row]左右结构
 * [Box]可以和布局组合的布局,如果Box中包含多个布局子集时,这些子集将按照顺序堆叠起来,类似FrameLayout
 *
 * [Modifier]用于设置属性,如dimensions、padding、background color、click等
 * 注意：
 * Modifier中的属性设置顺序很重要,会影响到最后的效果.
 * 后设置的Modifier属性会先执行，例如Modifier.padding(1.dp).click{...}.padding(2.dp),点击事件不会在padding(1.dp)内触发
 */
@Composable
fun ControlLearn1_1ColumnRowBoxScreen() {
    ControlLearn1_1Content()
}

@Composable
fun ControlLearn1_1Content() {

    LazyColumn(
        Modifier
            .fillMaxSize()
    ) {
        item {

            ControlLearnHeader("Row")
            ControlLearnDescription("1-) Row是可组合的布局,内部以左右结构摆放子节点.")
            RowExample()

        }
    }

}

/**
 * [Row]的例子
 * 写多几遍加深印象
 */
@Composable
fun RowExample() {

    //居左对齐
    ControlLearnExampleContentText(text = "Arrangement.Start (居左对齐)")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
        RowTexts()
    }

    //居右对齐
    ControlLearnExampleContentText(text = "Arrangement.End (居右对齐)")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        RowTexts()
    }

    //居中对齐
    ControlLearnExampleContentText(text = "Arrangement.Center (居中对齐)")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        RowTexts()
    }

    //平分空间
    ControlLearnExampleContentText(text = "Arrangement.SpaceEvenly (平分空间)")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        RowTexts()
    }

    //第一个控件左边和最后一个控件右边的间距 = 1d, 控件之间的间距 = 2d
    //类似(xAxxBxxCx)
    ControlLearnExampleContentText(text = "Arrangement.SpaceAround (第一个控件左边和最后一个控件右边的间距 = 1d, 控件之间的间距 = 2d); 类似(xAxxBxxCx)")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        RowTexts()
    }

    //第一个控件和最后一个控件挨着左右边界
    //类似start_start = "parent" \ end_end = "parent"
    ControlLearnExampleContentText(text = "Arrangement.SpaceBetween (第一个控件和最后一个控件挨着左右边界)")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        RowTexts()
    }

}

/**
 * [Row]例子使用的布局
 */
@Composable
fun RowTexts() {
    Text(
        text = "Row1",
        Modifier
            .background(c_FF9800)
            .padding(4.dp)
    )
    Text(
        text = "Row2",
        Modifier
            .background(c_FFA726)
            .padding(4.dp)
    )
    Text(
        text = "Row3",
        Modifier
            .background(c_FFB74D)
            .padding(4.dp)
    )
}




















