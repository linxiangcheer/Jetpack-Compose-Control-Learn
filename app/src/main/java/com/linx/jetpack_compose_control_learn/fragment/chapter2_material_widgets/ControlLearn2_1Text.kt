package com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.linx.jetpack_compose_control_learn.components.ControlLearnDescription
import com.linx.jetpack_compose_control_learn.components.ControlLearnHeader

@Composable
fun ControlLearn2_1Screen() {
    ControlLearnContent()
}

@Composable
fun ControlLearnContent() {

    LazyColumn(Modifier.fillMaxSize()) {

        item {

            ControlLearnHeader(text = "Text")

            ControlLearnDescription(text = "1-) color (颜色)")
            TextSampleRow {
                Text(text = "Red 700", color = Color(0xffd32f2f))
                Text(text = "Purple 700", color = Color(0xff7B1FA2))
                Text(text = "Green 700", color = Color(0xff1976D2))
                Text(text = "Teal 700", color = Color(0xff00796B))
            }

            ControlLearnDescription(text = "2-) fontSize (字体大小)")
            TextSampleRow {
                Text(text = "14sp", fontSize = 14.sp)
                Text(text = "18sp", fontSize = 18.sp)
                Text(text = "30sp", fontSize = 30.sp)
                Text(text = "40sp", fontSize = 40.sp)
            }

            ControlLearnDescription(text = "3-) Font Style (字体风格)")
            TextSampleRow {
                Text(text = "Normal (正常)", fontStyle = FontStyle.Normal)
                Text(text = "Italic (斜体)", fontStyle = FontStyle.Italic)
            }

            ControlLearnDescription(text = "4-) Font Weight (字体粗细)")
            TextSampleRow(showBottomSpacer = false) {
                Text(text = "Thin", fontWeight = FontWeight.Thin)
                Text(text = "ExtraLight", fontWeight = FontWeight.ExtraLight)
                Text(text = "Light", fontWeight = FontWeight.Light)
                Text(text = "Normal (正常)", fontWeight = FontWeight.Normal)
                Text(text = "Medium", fontWeight = FontWeight.Medium)
            }
            TextSampleRow {
                Text(text = "SemiBold", fontWeight = FontWeight.SemiBold)
                Text(text = "Bold", fontWeight = FontWeight.Bold)
                Text(text = "ExtraBold", fontWeight = FontWeight.ExtraBold)
                Text(text = "Black", fontWeight = FontWeight.Black)
            }

            ControlLearnDescription(text = "5-) Font Family")
            TextSampleRow {
                Text(text = "Default", fontFamily = FontFamily.Default)
                Text(text = "Cursive", fontFamily = FontFamily.Cursive)
                Text(text = "Monospace", fontFamily = FontFamily.Monospace)
                Text(text = "SansSerif", fontFamily = FontFamily.SansSerif)
                Text(text = "Serif", fontFamily = FontFamily.Serif)
            }

            ControlLearnDescription(text = "6-) Letter Spacing (字间距)")
            TextSampleRow {
                Text(text = "0.4sp", letterSpacing = 0.4.sp)
                Text(text = "1sp", letterSpacing = 1.sp)
                Text(text = "2sp", letterSpacing = 2.sp)
                Text(text = "4sp", letterSpacing = 4.sp)
                Text(text = "8sp", letterSpacing = 8.sp)
            }

            ControlLearnDescription(text = "7-) Text Decoration (删除线)")
            TextSampleRow {
                Text(text = "下划线", textDecoration = TextDecoration.Underline)
                Text(text = "中划线", textDecoration = TextDecoration.LineThrough)
                Text(
                    text = "中划线+下划线", textDecoration = TextDecoration.combine(
                        listOf(
                            TextDecoration.Underline,
                            TextDecoration.LineThrough
                        )
                    )
                )
            }

            ControlLearnDescription(text = "8-) Line Height (行之间的间隔高度)")
            //间隔线
            Divider(modifier = Modifier.padding(4.dp))
            Text(
                text = "这段文本的行高被设置为15sp,如果你想调整的话就可以改变lineHeight属性",
                lineHeight = 15.sp
            )
            Divider(modifier = Modifier.padding(4.dp))
            Text(
                text = "这段文本的行高被设置为20sp,如果你想调整的话就可以改变lineHeight属性",
                lineHeight = 20.sp
            )
            Divider(modifier = Modifier.padding(4.dp))
            Text(
                text = "这段文本的行高被设置为30sp,如果你想调整的话就可以改变lineHeight属性",
                lineHeight = 30.sp
            )
            Divider(modifier = Modifier.padding(4.dp))
            Text(
                text = "这段文本的行高被设置为40sp,如果你想调整的话就可以改变lineHeight属性",
                lineHeight = 40.sp
            )
            Divider(modifier = Modifier.padding(4.dp))

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )

            ControlLearnDescription(text = "9-) Overflow (行数长度溢出)")
            //直接删除溢出部分文字
            Text(
                text = "TextOverflow.Clip: 这段文字主要测试行数长度超过限制的时候会如何处理",
                overflow = TextOverflow.Clip,
                maxLines = 1
            )
            Divider(modifier = Modifier.padding(4.dp))
            //省略号结尾
            Text(
                text = "TextOverflow.Ellipsis: 这段文字主要测试行数长度超过限制的时候会如何处理",
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )

            ControlLearnDescription(text = "10) Background (背景)")
            TextBackgroundAndBorderExample()

        }

    }

}

/**
 * 自定义的文本控件
 */
@Composable
private fun CustomText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = LocalTextStyle.current
) {

    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        style = style
    )

}

/**
 * 并排显示具有不同属性的文本组件
 */
@Composable
fun TextSampleRow(showBottomSpacer: Boolean = true, content: @Composable () -> Unit) {

    val modifier = Modifier
        .fillMaxWidth()
        .background(Color.LightGray)

    //左右结构
    Row(
        modifier = modifier,
        //平分
        horizontalArrangement = Arrangement.SpaceEvenly,
        //贴着底部
        verticalAlignment = Alignment.Bottom
    ) {
        content.invoke()
    }

    if (showBottomSpacer) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
    }

}

/**
 * 用纯色或渐变颜色绘制带有背景或边框的[Text]
 */
@Composable
fun TextBackgroundAndBorderExample() {

    Row(
        modifier = Modifier.fillMaxWidth().height(100.dp),
//        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        //横向渐变
        val horizontalGradientBrush = Brush.horizontalGradient(
            colors = listOf(
                Color(0xffF57F17),
                Color(0xffFFEE58),
                Color(0xffFFF9C4)
            )
        )

        Text(
            text = "渐变",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .background(brush = horizontalGradientBrush)
                .fillMaxHeight()
                .weight(1f)
        )

        Text(
            text = "纯色圆角",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(10.dp)
                .background(Color(0xffFF9800), shape = RoundedCornerShape(10.dp))
                .fillMaxHeight()
                .weight(1f),
            textAlign = TextAlign.Center
        )

        Text(
            text = "纯色裁剪",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .background(
                    Color(0xff00BCD4),
                    shape = CutCornerShape(topStart = 10.dp)
                )
                .fillMaxHeight()
                .weight(1f)
        )

    }

}



















