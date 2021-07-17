package com.linx.jetpack_compose_control_learn.model

import androidx.compose.runtime.Composable

//各个章节的模型
data class ControlLearnSectionModel(
    //标题
    val title: String,
    //一个带@Composable函数的页面
    val action: @Composable (() -> Unit)? = null,
    //描述
    val description: String,
    //标签列表
    val tags: List<String> = listOf()
)