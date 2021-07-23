package com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.linx.jetpack_compose_control_learn.components.ControlLearnDescription
import com.linx.jetpack_compose_control_learn.components.ControlLearnExampleContentText
import com.linx.jetpack_compose_control_learn.components.ControlLearnHeader

@Composable
fun ControlLearn2_3TextFieldScreen() {
    TextFieldScreenContent()
}

@Composable
fun TextFieldScreenContent() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {

            val fullWidthModifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

            ControlLearnHeader(text = "TextField")
            ControlLearnDescription(text = "1-) 文本框允许用户输入和编辑文本,记得和MutableState一起使用,以便储存String或TextFieldValue")
            //MutableState  TextField和String的不同
            TextFieldOrStringDifferent(fullWidthModifier)

            ControlLearnDescription(text = "2-) isError (true -> 提示有错误)")
            ErrorTextField(fullWidthModifier)

            ControlLearnDescription(text = "3-) Colors")
            ControlLearnExampleContentText(text = "text(文字)、background(背景)、cursor(光标)、label(标签文字)、placeholder(提示文字)、leadingIcon(输入框前头)、trailingIcon(输入框尾部)")
            AllColorsTextFieldExample(fullWidthModifier)

            ControlLearnExampleContentText(text = "设置基本颜色属性")
            ColorsTextFieldExampleA(fullWidthModifier)

            ControlLearnExampleContentText(text = " -- isError (true -> 提示有错误)")
            ColorsErrorTextField(fullWidthModifier)

            ControlLearnExampleContentText(text = " -- Enabled (false -> 禁止输入)")
            ColorsUnEnabledTextField(fullWidthModifier)

            ControlLearnDescription(text = "4-) Shape (圆角)")
            ShapeTextField(fullWidthModifier)

            ControlLearnDescription(text = "5-) OutlinedTextField (有轮廓的TextField)")
            OutlinedTextField(fullWidthModifier)

            ControlLearnDescription(text = "6-) keyboardOptions (改变TextField输入类型)")
            TypeTextField(fullWidthModifier)

        }
    }

}

/**
 * 文本框mutableStateOf(TextFieldValue)和mutableStateOf(String)的不同
 */
@Composable
private fun TextFieldOrStringDifferent(modifier: Modifier) {
    //TextFieldValue可以拿到输入框内的一些状态, text, selection = TextRange(1,1),光标所处的位置
    //composition
    val textFieldValue = remember {
        mutableStateOf(TextFieldValue(""))
    }
    TextField(
        value = textFieldValue.value,
        modifier = modifier,
        //标签
        label = { Text(text = "label 标签") },
        //提示
        placeholder = { Text("PlaceHolder 提示") },
        //内部输入的值改变
        onValueChange = { newValue ->
            textFieldValue.value = newValue
        }
    )
    ControlLearnExampleContentText(text = "TextFieldValue当前的值为: ${textFieldValue.value}")

    //text只能拿到文本内容
    val text = remember {
        mutableStateOf("")
    }
    TextField(
        modifier = modifier,
        value = text.value,
        label = { Text(text = "label 标签") },
        placeholder = {
            Text(text = "PlaceHolder 提示")
        },
        onValueChange = { newValue ->
            text.value = newValue
        })
    ControlLearnExampleContentText(text = "String当前的值为: ${text.value}")
}

/**
 * 输入框提示有错误的时候边框和标签文字颜色都会改变
 */
@Composable
private fun ErrorTextField(modifier: Modifier) {
    val errorText = remember {
        mutableStateOf(TextFieldValue("这个框的输入文本不为空的时候是错误的"))
    }
    TextField(
        value = errorText.value,
        modifier = modifier,
        onValueChange = { newValue ->
            errorText.value = newValue
        },
        label = {
            Text(text = "label 标签")
        },
        placeholder = {
            Text(text = "PlaceHolder 提示")
        },
        isError = errorText.value.text.isNotEmpty()
    )
}

/**
 * 输入框 颜色的改变 这里有全部属性
 */
@Composable
private fun AllColorsTextFieldExample(modifier: Modifier) {

    val textFieldValue = remember {
        mutableStateOf(TextFieldValue(""))
    }

    TextField(
        value = textFieldValue.value,
        modifier = modifier,
        label = {
            Text(text = "Label 标签")
        },
        placeholder = {
            Text(text = "PlaceHolder 提示")
        },
        onValueChange = { newValue ->
            textFieldValue.value = newValue
        },
        colors = TextFieldDefaults.textFieldColors(
            //文字颜色
            textColor = Color.White,
            //背景颜色
            backgroundColor = Color.Green,
            //光标颜色
            cursorColor = Color.Green,
            //输入框前头的颜色
            leadingIconColor = Color.Green,
            //输入框尾部的颜色
            trailingIconColor = Color.Green,
            //提示文字颜色
            placeholderColor = Color.Green,

            //输入框有焦点时,Label标签文字的颜色
            focusedLabelColor = Color.Blue,
            //输入框处于焦点时,底部指示器的颜色
            focusedIndicatorColor = Color.Blue,

            //当输入框不处于焦点时,Label标签文字的颜色
            unfocusedLabelColor = Color.Gray,
            //当输入框不处于焦点时,底部指示器的颜色
            unfocusedIndicatorColor = Color.Gray,

            //isError = true 时label标签文字的颜色
            errorLabelColor = Color.White,
            //isError = true 时光标的颜色
            errorCursorColor = Color.White,
            //isError = true 时底部指示器的颜色
            errorIndicatorColor = Color.White,
            //isError = true 时输入框前头的颜色
            errorLeadingIconColor = Color.White,
            //isError = true 时输入框尾部的颜色
            errorTrailingIconColor = Color.White,

            //输入框禁用时,已有的文字颜色 enabled = false
            disabledTextColor = Color.Red,
            //输入框禁用时,Label标签文字的颜色 enabled = false
            disabledLabelColor = Color.Red,
            //输入框禁用时,Placeholder提示文字的颜色 enabled = false
            disabledPlaceholderColor = Color.Red,
            //输入框禁用时,底部指示器的颜色 enabled = false
            disabledIndicatorColor = Color.Red,
            //输入框禁用时,输入框前头的颜色 enabled = false
            disabledLeadingIconColor = Color.Red,
            //输入框禁用时,输入框尾部的颜色 enabled = false
            disabledTrailingIconColor = Color.Red,
        ),
    )

}

/**
 * 正常的输入框
 */
@Composable
fun ColorsTextFieldExampleA(modifier: Modifier) {

    ControlLearnExampleContentText(
        text = "textColor (文本颜色)\nbackgroundColor (背景颜色)\ncursorColor (光标颜色)\n" +
                "placeholderColor (提示文字颜色)\nfocusedLabelColor (输入框有焦点时,标签文字颜色)\n" +
                "unfocusedLabelColor (输入框不处于焦点时,标签文字颜色)\n" +
                "focusedIndicatorColor (输入框处于焦点时,底部指示器的颜色)\n" +
                "unfocusedIndicatorColor (输入框不处于焦点时,底部指示器的颜色)"
    )

    val textFieldValue = remember {
        mutableStateOf(TextFieldValue(""))
    }

    TextField(
        value = textFieldValue.value,
        modifier = modifier,
        label = {
            Text(text = "Label 标签")
        },
        placeholder = {
            Text(text = "PlaceHolder 提示")
        },
        onValueChange = { newValue ->
            textFieldValue.value = newValue
        },
        colors = TextFieldDefaults.textFieldColors(
            //文字颜色
            textColor = Color(0xff039BE5),
            //背景颜色
            backgroundColor = Color.Black,
            //光标颜色
            cursorColor = Color(0xff2E7D32),
            //输入框前头的颜色
            leadingIconColor = Color(0xffAEEA00),
            //输入框尾部的颜色
            trailingIconColor = Color(0xffFFE082),
            //提示文字颜色
            placeholderColor = Color.Red,
            //输入框有焦点时,Label标签文字的颜色
            focusedLabelColor = Color.White,
            //当输入框不处于焦点时,Label标签文字的颜色
            unfocusedLabelColor = Color.Yellow,
            //输入框处于焦点时,底部指示器的颜色
            focusedIndicatorColor = Color.Yellow,
            //当输入框不处于焦点时,底部指示器的颜色
            unfocusedIndicatorColor = Color.White
        ),
        trailingIcon = {
            Icon(imageVector = Icons.Default.Close, contentDescription = null)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
        }
    )

}

/**
 * 提示有错误的时候输入框颜色的改变
 */
@Composable
fun ColorsErrorTextField(modifier: Modifier) {

    ControlLearnExampleContentText(
        text = "errorLabelColor (isError = true 时label标签文字的颜色)\n" +
                "errorCursorColor (isError = true 时光标的颜色)\n" +
                "errorIndicatorColor (isError = true 时底部指示器的颜色)\n" +
                "errorLeadingIconColor (isError = true 时输入框前头的颜色)\n" +
                "errorTrailingIconColor (isError = true 时输入框尾部的颜色)"
    )

    val errorText = remember {
        mutableStateOf(TextFieldValue(""))
    }
    TextField(
        value = errorText.value,
        modifier = modifier,
        onValueChange = { newValue ->
            errorText.value = newValue
        },
        label = {
            Text(text = "label 标签")
        },
        placeholder = {
            Text(text = "输入文本为空的时候是错误的")
        },
        isError = errorText.value.text.isNotEmpty(),
        colors = TextFieldDefaults.textFieldColors(
            //isError = true 时label标签文字的颜色
            errorLabelColor = Color(0xFF003371),
            //isError = true 时光标的颜色
            errorCursorColor = Color(0xFF560041),
            //isError = true 时底部指示器的颜色
            errorIndicatorColor = Color(0xFF801dae),
            //isError = true 时输入框前头的颜色
            errorLeadingIconColor = Color(0xFF4c8dae),
            //isError = true 时输入框尾部的颜色
            errorTrailingIconColor = Color.Yellow,
        ),
        trailingIcon = {
            Icon(imageVector = Icons.Default.Close, contentDescription = null)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
        }
    )
}

/**
 * 不可输入时输入框颜色的改变
 */
@Composable
fun ColorsUnEnabledTextField(modifier: Modifier) {

    ControlLearnExampleContentText(
        text = "disabledTextColor (输入框禁用时,已有的文字颜色)\n" +
                "disabledLabelColor (输入框禁用时,Label标签文字的颜色)\n" +
                "disabledPlaceholderColor (输入框禁用时,Placeholder提示文字的颜色)\n" +
                "disabledIndicatorColor (输入框禁用时,底部指示器的颜色)\n" +
                "disabledLeadingIconColor (输入框禁用时,输入框前头的颜色)\n" +
                "disabledTrailingIconColor (输入框禁用时,输入框尾部的颜色)"
    )

    val unEnableText = remember {
        mutableStateOf(TextFieldValue("禁止输入的输入框"))
    }
    TextField(
        value = unEnableText.value,
        modifier = modifier,
        onValueChange = { newValue ->
            unEnableText.value = newValue
        },
        label = {
            Text(text = "label 标签")
        },
        placeholder = {
            Text(text = "呜呜呜我被禁止输入了")
        },
        isError = unEnableText.value.text.isNotEmpty(),
        colors = TextFieldDefaults.textFieldColors(
            //输入框禁用时,已有的文字颜色 enabled = false
            disabledTextColor = Color(0xFF007bbb),
            //输入框禁用时,Label标签文字的颜色 enabled = false
            disabledLabelColor = Color(0xFFff8936),
            //输入框禁用时,Placeholder提示文字的颜色 enabled = false
            disabledPlaceholderColor = Color(0xFF801dae),
            //输入框禁用时,底部指示器的颜色 enabled = false
            disabledIndicatorColor = Color(0xFF2edfa3),
            //输入框禁用时,输入框前头的颜色 enabled = false
            disabledLeadingIconColor = Color.White,
            //输入框禁用时,输入框尾部的颜色 enabled = false
            disabledTrailingIconColor = Color.Red,
        ),
        trailingIcon = {
            Icon(imageVector = Icons.Default.Close, contentDescription = null)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
        },
        //禁止输入
        enabled = false
    )

}

/**
 * 为TextField添加圆角
 */
@Composable
fun ShapeTextField(modifier: Modifier) {

    val shapeText = remember {
        mutableStateOf(TextFieldValue("这是一个圆角的TextField"))
    }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(25),
        elevation = 5.dp,
        //边缘线
        border = BorderStroke(1.dp, Color.Blue)
    ) {
        TextField(
            value = shapeText.value,
            onValueChange = { newValue ->
                shapeText.value = newValue
            },
            placeholder = {
                Text(text = "搜索")
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            )
        )
    }

}

/**
 * 有轮廓的TextField
 */
@Composable
fun OutlinedTextField(modifier: Modifier) {

    val textFieldValue = remember {
        mutableStateOf(TextFieldValue(""))
    }

    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = { newValue ->
            textFieldValue.value = newValue
        },
        modifier = modifier,
        placeholder = {
            Text(text = "这是一个Placeholder")
        },
        label = {
            Text(text = "这是一个Label")
        }
    )

    ControlLearnExampleContentText(text = "设置各种颜色")
    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = { newValue ->
            textFieldValue.value = newValue
        },
        modifier = modifier,
        placeholder = {
            Text(text = "这是一个Placeholder")
        },
        label = {
            Text(text = "这是一个Label")
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Blue,
            backgroundColor = Color.Yellow,
            placeholderColor = Color(0xffFFF176),
            unfocusedLabelColor = Color(0xff43A047),
            focusedLabelColor = Color(0xff66BB6A),
            errorLabelColor = Color(0xffFFEB3B),
            unfocusedIndicatorColor = Color(0xffFF5722),
            focusedIndicatorColor = Color(0xff1976D2)
        )
    )

    ControlLearnExampleContentText(text = "singleLine (单行)")
    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = { newValue ->
            textFieldValue.value = newValue
        },
        modifier = modifier,
        placeholder = {
            Text(text = "singleLine = true")
        },
        label = {
            Text(text = "singleLine = true")
        },
        //单行
        singleLine = true
    )

    ControlLearnExampleContentText(text = "maxLines (最大行数)")
    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = { newValue ->
            textFieldValue.value = newValue
        },
        modifier = modifier,
        placeholder = {
            Text(text = "maxLines = 2")
        },
        label = {
            Text(text = "maxLines = 2")
        },
        //最大行数
        maxLines = 2
    )


}

/**
 * 改变TextField的输入类型
 */
@Composable
fun TypeTextField(modifier: Modifier) {

    ControlLearnExampleContentText(
        text = "KeyboardType.Password (输入框的类型是密码)\n" +
                "visualTransformation = PasswordVisualTransformation() (转化为不可见的密码)"
    )

    val textFieldValue = remember {
        mutableStateOf(TextFieldValue(""))
    }

    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = { newValue ->
            textFieldValue.value = newValue
        },
        modifier = modifier,
        placeholder = {
            Text(text = "KeyboardType.Password")
        },
        label = {
            Text(text = "请输入密码")
        },
        //输入设置  密码
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        //转化为不可见的密码
        visualTransformation = PasswordVisualTransformation()
    )

    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = { newValue ->
            textFieldValue.value = newValue
        },
        modifier = modifier,
        placeholder = {
            Text(text = "135xxxxxxxx")
        },
        label = {
            Text(text = "请输入手机号")
        },
        //输入设置  手机号
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
    )

}































