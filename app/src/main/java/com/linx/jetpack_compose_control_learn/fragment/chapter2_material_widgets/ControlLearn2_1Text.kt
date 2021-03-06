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

            val list = listOf<String>("//??????", "text: String",
                "//?????????", "modifier: Modifier = Modifier",
                "//????????????", "color: Color = Color.Unspecified",
                "//????????????", "fontSize: TextUnit = TextUnit.Unspecified",
                "//????????????", "fontStyle: FontStyle? = null",
                "//????????????", "fontWeight: FontWeight? = null",
                "//?????????", "fontFamily: FontFamily? = null",
                "//?????????", "letterSpacing: TextUnit = TextUnit.Unspecified",
                "//?????????", "textDecoration: TextDecoration? = null",
                "//??????????????????(???????????????Text?????????)", "textAlign: TextAlign? = null",
                "//??????????????????", "lineHeight: TextUnit = TextUnit.Unspecified",
                "//??????????????????", "overflow: TextOverflow = TextOverflow.Clip",
                "//???????????????????????????????????????", "softWrap: Boolean = true",
                "//????????????", "maxLines: Int = Int.MAX_VALUE",
                "//????????????????????????????????????????????????,TextLayoutResult????????????????????????????????????????????????(base line)???????????????", "onTextLayout: (TextLayoutResult) -> Unit = {}",
                "//?????????????????????; ?????????,??????,?????????", "style: TextStyle = LocalTextStyle.current",
                "",
                "//??????????????????", "text: AnnotatedString",
                "//????????????", "inlineContent: Map<String, InlineTextContent> = mapOf()"
            )
            Text(text = "")
            CodeCard(list = list, codeTitle = "Text????????????")

            ControlLearnDescription(text = "1-) color (??????)")
            TextSampleRow {
                Text(text = "Red 700", color = Color(0xffd32f2f))
                Text(text = "Purple 700", color = Color(0xff7B1FA2))
                Text(text = "Green 700", color = Color(0xff1976D2))
                Text(text = "Teal 700", color = Color(0xff00796B))
            }

            ControlLearnDescription(text = "2-) fontSize (????????????)")
            TextSampleRow {
                Text(text = "14sp", fontSize = 14.sp)
                Text(text = "18sp", fontSize = 18.sp)
                Text(text = "30sp", fontSize = 30.sp)
                Text(text = "40sp", fontSize = 40.sp)
            }

            ControlLearnDescription(text = "3-) Font Style (????????????)")
            TextSampleRow {
                Text(text = "Normal (??????)", fontStyle = FontStyle.Normal)
                Text(text = "Italic (??????)", fontStyle = FontStyle.Italic)
            }

            ControlLearnDescription(text = "4-) Font Weight (????????????)")
            TextSampleRow(showBottomSpacer = false) {
                Text(text = "Thin", fontWeight = FontWeight.Thin)
                Text(text = "ExtraLight", fontWeight = FontWeight.ExtraLight)
                Text(text = "Light", fontWeight = FontWeight.Light)
                Text(text = "Normal (??????)", fontWeight = FontWeight.Normal)
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

            ControlLearnDescription(text = "6-) Letter Spacing (?????????)")
            TextSampleRow {
                Text(text = "0.4sp", letterSpacing = 0.4.sp)
                Text(text = "1sp", letterSpacing = 1.sp)
                Text(text = "2sp", letterSpacing = 2.sp)
                Text(text = "4sp", letterSpacing = 4.sp)
                Text(text = "8sp", letterSpacing = 8.sp)
            }

            ControlLearnDescription(text = "7-) Text Decoration (?????????)")
            TextSampleRow {
                Text(text = "?????????", textDecoration = TextDecoration.Underline)
                Text(text = "?????????", textDecoration = TextDecoration.LineThrough)
                Text(
                    text = "?????????+?????????", textDecoration = TextDecoration.combine(
                        listOf(
                            TextDecoration.Underline,
                            TextDecoration.LineThrough
                        )
                    )
                )
            }

            ControlLearnDescription(text = "8-) Line Height (????????????????????????)")
            //?????????
            Divider(modifier = Modifier.padding(4.dp))
            Text(
                text = "?????????????????????????????????15sp,???????????????????????????????????????lineHeight??????",
                lineHeight = 15.sp
            )
            Divider(modifier = Modifier.padding(4.dp))
            Text(
                text = "?????????????????????????????????20sp,???????????????????????????????????????lineHeight??????",
                lineHeight = 20.sp
            )
            Divider(modifier = Modifier.padding(4.dp))
            Text(
                text = "?????????????????????????????????30sp,???????????????????????????????????????lineHeight??????",
                lineHeight = 30.sp
            )
            Divider(modifier = Modifier.padding(4.dp))
            Text(
                text = "?????????????????????????????????40sp,???????????????????????????????????????lineHeight??????",
                lineHeight = 40.sp
            )
            Divider(modifier = Modifier.padding(4.dp))

            ControlLearnDescription(text = "9-) Overflow (??????????????????)", showTopSpacer = true)
            //??????????????????????????????
            Text(
                text = "TextOverflow.Clip: ????????????????????????????????????????????????????????????????????????",
                overflow = TextOverflow.Clip,
                maxLines = 1
            )
            Divider(modifier = Modifier.padding(4.dp))
            //???????????????
            Text(
                text = "TextOverflow.Ellipsis: ????????????????????????????????????????????????????????????????????????",
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            ControlLearnDescription(text = "10) Background (??????)", showTopSpacer = true)
            TextBackgroundExample()

            ControlLearnDescription(text = "11) Border (??????)", showTopSpacer = true)
            TextBorderExample()

            ControlLearnDescription(text = "12) Shadow (??????)", showTopSpacer = true)
            TextShadowExample()

            ControlLearnDescription(
                text = "13) AnnotatedString (??????????????????, ??????/?????????)",
                showTopSpacer = true
            )
            TextSpannableExample()

            ControlLearnDescription(text = "14) click (?????????)", showTopSpacer = true)
            TextClickExample()

        }

    }

}

/**
 * ????????????????????????
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
 * ?????????????????????????????????????????????
 */
@Composable
fun TextSampleRow(showBottomSpacer: Boolean = true, content: @Composable () -> Unit) {

    val modifier = Modifier
        .fillMaxWidth()
        .background(Color.LightGray)

    //????????????
    Row(
        modifier = modifier,
        //??????
        horizontalArrangement = Arrangement.SpaceEvenly,
        //????????????
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
 * ??????????????????????????????????????????????????????[Text]
 */
@Composable
fun TextBackgroundExample() {

    //????????????
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
                text = "????????????",
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
                text = "????????????",
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
                text = "????????????",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }

    }

}

/**
 * ?????????????????????????????????????????????[Text]
 */
@Composable
fun TextBorderExample() {

    //????????????
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
                //?????????
//                .padding(20.dp)
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "????????????",
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
                text = "????????????",
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
                    //[topStartPercent] ?????????
                    shape = CutCornerShape(topStartPercent = 25)
                )
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "????????????",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }

    }

}

/**
 * ?????????????????? [shadow]
 */
@Composable
fun TextShadowExample() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "????????????",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Red,
                    //????????????
                    blurRadius = 10f,
                    offset = Offset(10f, 10f)
                )
            )
        )

        Text(
            text = "????????????",
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
            text = "????????????",
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
 * ?????????????????? [AnnotatedString]
 */
@Composable
fun TextSpannableExample() {

    val annotatedColorString = buildAnnotatedString {
        append("??????????????????")
        addStyle(
            style = SpanStyle(
                color = Color.Red,
                fontSize = 24.sp
            ),
            //??????
            start = 0,
            //?????????
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

        val str = "????????????????????????????????????"
        //????????????startIndex????????????????????????????????????????????????????????????????????????
        val startIndex = str.indexOf("?????????")
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

        //??????????????????????????????????????????URL?????????
        addStringAnnotation(
            tag = "URL",
            annotation = "https://baidu.com",
            start = startIndex,
            end = endIndex
        )

    }

    //??????UriHandler??????AnnotatedString??????[addStringAnnotation]
    val uriHandler: UriHandler = LocalUriHandler.current

    //???????????????,?????????????????????start - end??????????????????
    ClickableText(
        modifier = Modifier
            .padding(start = 16.dp, bottom = 16.dp)
            .fillMaxWidth(),
        text = annotatedLinkString,
        onClick = {
            annotatedLinkString.getStringAnnotations(it, it)
                .firstOrNull()?.let { range ->
                    println("?????? $it, item:$range")
                    uriHandler.openUri(range.item)
                }
        }
    )

}

/**
 * ????????????Text
 */
@Composable
fun TextClickExample() {

    val context = LocalContext.current

    Text(text = "??????Text???????????????", modifier = Modifier
        //?????????
        .padding(10.dp)
        .background(Color.Red)
        .clickable {
            Toast
                .makeText(context, "??????Text", Toast.LENGTH_SHORT)
                .show()
        }
        //?????????
        .padding(10.dp),
        color = Color.White
    )

    Text(
        text = "??????????????????????????????Text", modifier = Modifier
            .padding(10.dp)
            .background(Color.LightGray)
            .clickable(
                onClick = {
                    Toast
                        .makeText(context, "???????????????Text", Toast.LENGTH_SHORT)
                        .show()
                },
                indication = null,
                interactionSource = MutableInteractionSource()
            )
            .padding(10.dp),
        color = Color.White
    )

}



















