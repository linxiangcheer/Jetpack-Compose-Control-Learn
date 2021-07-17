package com.linx.jetpack_compose_control_learn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.linx.jetpack_compose_control_learn.model.ControlLearnSectionModel

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
                items(model.tags){ tag ->
                    //标签的样式
                    ControlLearnChip(text = tag)
                    //平行间距
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

        }

    }

}