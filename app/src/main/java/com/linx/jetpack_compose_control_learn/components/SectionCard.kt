package com.linx.jetpack_compose_control_learn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.linx.jetpack_compose_control_learn.model.ControlLearnSectionModel
import com.linx.jetpack_compose_control_learn.ui.theme.*

/**
 * 首页自定义的Card
 *
 * [model] 数据
 * [onClick] 点击事件, 整个括起来可以为null
 */
@Composable
fun ControlLearnSectionCard(
    model: ControlLearnSectionModel,
    onClick: ((ControlLearnSectionModel) -> Unit)? = null
) {

    Card(
        modifier = Modifier
            .padding(bottom = 16.dp, start = 8.dp, end = 8.dp)
            .background(Color.White)
            .fillMaxWidth()
            .clickable {
                onClick?.invoke(model)
            },
        //阴影
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(
            Modifier.padding(16.dp)
        ) {

            //标题
            Text(
                text = model.title,
                //粗体
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )

            //垂直间距
            Spacer(modifier = Modifier.height(8.dp))

            //描述
            Text(
                text = model.description,
                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )

            //垂直间距
            Spacer(modifier = Modifier.height(16.dp))

            //左右结构的标签
            LazyRow {
                items(model.tags) { tag ->
                    //标签的样式
                    ControlLearnChip(text = tag)
                    //平行间距
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

        }

    }

}


/**
 * 代码展示的Card
 * 如果是以"//"两个斜杠开头的字符串就是注释
 * [list] 列表数据
 * [codeName] 代码块的标题啊
 */
@Composable
fun CodeCard(list: List<String>, codeTitle: String = "", modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        backgroundColor = c_58,
        contentColor = c_fb8535,
        shape = RoundedCornerShape(10.dp)
    ) {

        Column(
            modifier = Modifier.padding(
                start = 20.dp,
                top = 10.dp,
                bottom = 10.dp,
                end = 20.dp
            ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            if (codeTitle != "") {
                Text(
                    text = codeTitle,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 10.dp),
                    fontWeight = FontWeight.Bold
                )
            }

            list.forEach { items ->
                //是否以//开头，如果是的话就是注释
                when (items.startsWith("//")) {
                    true -> {
                        Text(text = "    $items", fontSize = 15.sp, color = c_bfbbbb)
                    }
                    false -> {
                        Text(text = items, fontSize = 16.sp)
                    }
                }
            }
        }

    }
}