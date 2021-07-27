package com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.linx.jetpack_compose_control_learn.components.CodeCard
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

            val list = listOf<String>("//文本", "text: String",
                "//修饰符", "modifier: Modifier = Modifier",
                "//字的颜色", "color: Color = Color.Unspecified",
                "//字体大小", "fontSize: TextUnit = TextUnit.Unspecified",
                "//字体风格", "fontStyle: FontStyle? = null",
                "//字体粗细", "fontWeight: FontWeight? = null",
                "//字体包", "fontFamily: FontFamily? = null",
                "//字间距", "letterSpacing: TextUnit = TextUnit.Unspecified",
                "//删除线", "textDecoration: TextDecoration? = null",
                "//字的对齐方式(局限在整个Text范围内)", "textAlign: TextAlign? = null",
                "//行的间隔高度", "lineHeight: TextUnit = TextUnit.Unspecified",
                "//字数溢出处理", "overflow: TextOverflow = TextOverflow.Clip",
                "//文本是否应在软换行符处换行", "softWrap: Boolean = true",
                "//最大行数", "maxLines: Int = Int.MAX_VALUE",
                "//在计算新文本布局时执行的回调函数,TextLayoutResult对象包含段落信息、文本大小、基线(base line)和其他细节", "onTextLayout: (TextLayoutResult) -> Unit = {}",
                "//样式配置的文本; 如颜色,字体,行高等", "style: TextStyle = LocalTextStyle.current",
                "",
                "//带注释的文字", "text: AnnotatedString",
                "//内联内容", "inlineContent: Map<String, InlineTextContent> = mapOf()"
            )
            Text(text = "")
            CodeCard(list = list, codeTitle = "Text控件参数")

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

            ControlLearnDescription(text = "9-) Overflow (行数长度溢出)", showTopSpacer = true)
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

            ControlLearnDescription(text = "10) Background (背景)", showTopSpacer = true)
            TextBackgroundExample()

            ControlLearnDescription(text = "11) Border (边缘)", showTopSpacer = true)
            TextBorderExample()

            ControlLearnDescription(text = "12) Shadow (阴影)", showTopSpacer = true)
            TextShadowExample()

            ControlLearnDescription(
                text = "13) AnnotatedString (特定文字处理, 显示/超链接)",
                showTopSpacer = true
            )
            TextSpannableExample()

            ControlLearnDescription(text = "14) click (可点击)", showTopSpacer = true)
            TextClickExample()

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
fun TextBackgroundExample() {

    //横向渐变
    val horizontalGradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xffF57F17),
            Color(0xffFFEE58),
            Color(0xffFFF9C4)
        )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
                .background(brush = horizontalGradientBrush)
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                text = "横向渐变",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
                .background(Color(0xffFF9800), shape = RoundedCornerShape(10.dp))
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                text = "纯色圆角",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 15.sp,
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
                .background(
                    Color(0xff00BCD4),
                    shape = CutCornerShape(topStart = 10.dp)
                )
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                text = "纯色裁剪",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }

    }

}

/**
 * 用纯色或渐变颜色绘制带有边框的[Text]
 */
@Composable
fun TextBorderExample() {

    //纵向渐变
    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xff4E342E),
            Color(0xff8D6E63),
            Color(0xffD7CCC8)
        )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Row(
            modifier = Modifier
                .padding(10.dp)
                .border(
                    width = 4.dp,
                    brush = verticalGradientBrush,
                    shape = RectangleShape
                )
                //内边距
//                .padding(20.dp)
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "纵向渐变",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .border(
                    width = 4.dp,
                    Color(0xffFF9800),
                    shape = RoundedCornerShape(20.dp)
                )
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "纯色圆角",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .border(
                    width = 4.dp,
                    color = Color(0xff00BCD4),
                    //[topStartPercent] 百分比
                    shape = CutCornerShape(topStartPercent = 25)
                )
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "纯色裁剪",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }

    }

}

/**
 * 绘制文本阴影 [shadow]
 */
@Composable
fun TextShadowExample() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "右下阴影",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Red,
                    //模糊半径
                    blurRadius = 10f,
                    offset = Offset(10f, 10f)
                )
            )
        )

        Text(
            text = "左上阴影",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Blue,
                    blurRadius = 10f,
                    offset = Offset(-10f, -10f)
                )
            )
        )

        Text(
            text = "阴影半径",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Yellow,
                    blurRadius = 30f,
                    offset = Offset(5f, 5f)
                )
            )
        )

    }

}

/**
 * 特定文字显示 [AnnotatedString]
 */
@Composable
fun TextSpannableExample() {

    val annotatedColorString = buildAnnotatedString {
        append("红色绿色蓝色")
        addStyle(
            style = SpanStyle(
                color = Color.Red,
                fontSize = 24.sp
            ),
            //包含
            start = 0,
            //不包含
            end = 2
        )
        addStyle(
            style = SpanStyle(
                color = Color.Green,
                fontSize = 19.sp
            ),
            start = 2,
            end = 4
        )
        addStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontSize = 11.sp
            ),
            start = 4,
            end = 6
        )
    }

    Text(
        text = annotatedColorString, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )

    val annotatedLinkString: AnnotatedString = buildAnnotatedString {

        val str = "点击超链接文字跳转到网页"
        //从指定的startIndex开始，返回指定字符串第一次出现的字符序列中的索引
        val startIndex = str.indexOf("超链接")
        val endIndex = startIndex + 3
        append(str)

        addStyle(
            style = SpanStyle(
                color = Color(0xff64B5F6),
                fontSize = 18.sp,
                textDecoration = TextDecoration.Underline
            ),
            start = startIndex,
            end = endIndex
        )

        //附加一个字符串注释，存储一个URL到文本
        addStringAnnotation(
            tag = "URL",
            annotation = "https://baidu.com",
            start = startIndex,
            end = endIndex
        )

    }

    //使用UriHandler解析AnnotatedString内的[addStringAnnotation]
    val uriHandler: UriHandler = LocalUriHandler.current

    //可单击文本,需点击设置好的start - end范围内的文字
    ClickableText(
        modifier = Modifier
            .padding(start = 16.dp, bottom = 16.dp)
            .fillMaxWidth(),
        text = annotatedLinkString,
        onClick = {
            annotatedLinkString.getStringAnnotations(it, it)
                .firstOrNull()?.let { range ->
                    println("点击 $it, item:$range")
                    uriHandler.openUri(range.item)
                }
        }
    )

}

/**
 * 可点击的Text
 */
@Composable
fun TextClickExample() {

    val context = LocalContext.current

    Text(text = "这个Text是可点击的", modifier = Modifier
        //外边框
        .padding(10.dp)
        .background(Color.Red)
        .clickable {
            Toast
                .makeText(context, "点击Text", Toast.LENGTH_SHORT)
                .show()
        }
        //内边框
        .padding(10.dp),
        color = Color.White
    )

    Text(
        text = "可点击但是没有波纹的Text", modifier = Modifier
            .padding(10.dp)
            .background(Color.LightGray)
            .clickable(
                onClick = {
                    Toast
                        .makeText(context, "没有波纹的Text", Toast.LENGTH_SHORT)
                        .show()
                },
                indication = null,
                interactionSource = MutableInteractionSource()
            )
            .padding(10.dp),
        color = Color.White
    )

}



















