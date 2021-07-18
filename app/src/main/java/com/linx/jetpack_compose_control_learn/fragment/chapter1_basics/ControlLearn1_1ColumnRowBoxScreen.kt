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
import com.linx.jetpack_compose_control_learn.ui.theme.*

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
 * 先写的属性会先执行,后面的属性会在前面的属性的基础上执行
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

            //Row和Arrangement.Horizontal
            ControlLearnHeader("Row")
            ControlLearnDescription("1-) Row是可组合的布局,内部以左右结构摆放子节点.")
            RowExample()

            //Column和Arrangement.Vertical
            ControlLearnHeader(text = "Column")
            ControlLearnDescription(text = "2-) Column是可组合的布局,内部以上下结构摆放子节点")
            ColumnExample()

            //padding
            ControlLearnDescription(text = "3-) 实验属性先后顺序的影响,例如padding的先后顺序决定了它是内边距还是外边距")
            ControlLearnExampleContentText(text = "background之后设置padding - 内边距")
            ControlLearnExampleContentText(text = "在background之前设置padding - 外边距")
            ControlLearnExampleContentText(text = "先写的属性会先执行,后面的属性会在前面的属性的基础上执行")
            ColumnAndRowPaddingExample()

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

/**
 * [Column]的例子
 */
@Composable
fun ColumnExample() {

    val modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .height(160.dp)
        .background(Color.LightGray)

    //顶部
    ControlLearnExampleContentText(text = "Arrangement.Top (顶部)")
    Column(modifier = modifier, verticalArrangement = Arrangement.Top) {
        ColumnTexts()
    }

    //底部
    ControlLearnExampleContentText(text = "Arrangement.Bottom (底部)")
    Column(modifier, verticalArrangement = Arrangement.Bottom) {
        ColumnTexts()
    }

    //纵向居中
    ControlLearnExampleContentText(text = "Arrangement.Center (居中)")
    Column(modifier, verticalArrangement = Arrangement.Center) {
        ColumnTexts()
    }


    ControlLearnExampleContentText(text = "Arrangement.SpaceEvenly")
    Column(modifier, verticalArrangement = Arrangement.SpaceEvenly) {
        ColumnTexts()
    }

    ControlLearnExampleContentText(text = "Arrangement.SpaceAround")
    Column(modifier, verticalArrangement = Arrangement.SpaceAround) {
        ColumnTexts()
    }

    ControlLearnExampleContentText(text = "Arrangement.SpaceBetween")
    Column(modifier, verticalArrangement = Arrangement.SpaceBetween) {
        ColumnTexts()
    }

}

/**
 * [Column]例子使用的布局
 */
@Composable
fun ColumnTexts() {
    Text(
        text = "Column1",
        Modifier
            .background(c_8BC34A)
            .padding(4.dp)
    )
    Text(
        text = "Column2",
        Modifier
            .background(c_9CCC65)
            .padding(4.dp)
    )
    Text(
        text = "Column3",
        Modifier
            .background(c_AED581)
            .padding(4.dp)
    )
}

/**
 * [padding]的例子
 */
@Composable
fun ColumnAndRowPaddingExample() {

    val rowModifier = Modifier
        .background(c_F06292)
        .fillMaxWidth()
        .wrapContentHeight()

    //在background之后设置padding (内边距)
    val modifierA = Modifier
        .background(c_FFEB3B)
        .padding(15.dp)

    //在background之前设置padding (外边距,不受padding后面的background的影响)
    val modifierB = Modifier
        .padding(10.dp)
        .background(Color(0xFF80DEEA))
        .padding(end = 15.dp)

    //先写的属性会先执行,后面的属性会在前面的属性的基础上执行
    val modifierC = Modifier
        .background(Color(0xFF607D8B))
        .padding(15.dp)

    Row(modifier = rowModifier, horizontalArrangement = Arrangement.SpaceEvenly) {

        Column(
            modifier = modifierA
                .background(Color.White)
                .padding(8.dp)
        )
        {
            Text(text = "Text A1")
            Text(text = "Text A2")
            Text(text = "Text A3")
        }

        Column(
            modifier = modifierB
                .background(Color(0xFF9575CD))
                .padding(top = 5.dp, bottom = 30.dp)
        ) {
            Text(text = "Text B1")
            Text(text = "Text B2")
            Text(text = "Text B3")
        }

        Column(modifier = modifierC.background(Color(0xFFB2FF59))) {
            Text(text = "Text C1")
            Text(text = "Text C2")
            Text(text = "Text C3")
        }

    }

}




















