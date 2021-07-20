package com.linx.jetpack_compose_control_learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.linx.jetpack_compose_control_learn.components.ControlLearnSectionCard
import com.linx.jetpack_compose_control_learn.fragment.chapter1_basics.ControlLearn1_1ColumnRowBoxScreen
import com.linx.jetpack_compose_control_learn.fragment.chapter1_basics.ControlLearn1_2ClickSurfaceAndClicks
import com.linx.jetpack_compose_control_learn.fragment.chapter2_material_widgets.ControlLearn2_1Screen
import com.linx.jetpack_compose_control_learn.model.*
import com.linx.jetpack_compose_control_learn.ui.theme.JetpackComposeControlLearnTheme

class MainActivity : ComponentActivity() {

    private lateinit var controlLearnList: List<ControlLearnSectionModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeControlLearnTheme {
                ComposeNavigation()
            }
        }
    }

    /**
     * 创建一个带Composable注解的函数，使用navigation进行页面导航
     */
    @Composable
    fun ComposeNavigation() {

        //用于Navigation页面导航的导航控制器
        val navController = rememberNavController()

        //创建列表
        controlLearnList = createControlLearnList()

        //为每个页面绑定导航
        NavHost(navController = navController, startDestination = "start_destination") {

            //创建导航栏的首页
            composable("start_destination") {
                ControlLearnComponent(controlLearnList, navController)
            }

            //设置Navigation页面路线为标题(title) 并且调用action lambda函数内的代码
            controlLearnList.forEach { model ->
                composable(model.title) {
                    model.action?.invoke()
                }
            }

        }
    }

    /**
     *  这个函数包含了[Scaffold]脚手架,它实现了Material设计页面的基本结构
     *  该组件通过确保其适当的布局策略从而将其他的多个组件组合在一起构成页面
     *  https://blog.csdn.net/u010976213/article/details/113771146
     *
     *  [LazyColumn]和'RecyclerView'是对等的组成
     */
    @Composable
    private fun ControlLearnComponent(
        controlLearnList: List<ControlLearnSectionModel>,
        navController: NavController
    ) {
        Scaffold(
            //顶部标题栏
            topBar = {
                TopAppBar(title = {
                    Text(text = "Control Learn 1-1")
                })
            }
        ) {
            ControlLearnListContent(controlLearnList, navController)
        }
    }

    @Composable
    private fun ControlLearnListContent(
        controlLearnList: List<ControlLearnSectionModel>,
        navController: NavController
    ) {
        //表层
        Surface(
            Modifier.fillMaxSize(),
            color = Color.White
        ) {
            //列表是ControlLearnSectionModel
            LazyColumn(
                Modifier.padding(top = 16.dp),
                content = {
                    items(controlLearnList) { item: ControlLearnSectionModel ->
                        ControlLearnSectionCard(model = item) {
                            //跳转到某个页面
                            navController.navigate(item.title)
                        }
                    }
                }
            )
        }
    }

    /**
     * 创建带有标题的教程列表
     * navigation导航到action Composable函数中
     *
     * Tags可用在搜索控件中
     */
    private fun createControlLearnList(): List<ControlLearnSectionModel> {

        val controlLearn1_1 = ControlLearnSectionModel(
            title = "1-1 Column, Row, Box, Modifier",
            action = {
                ControlLearn1_1ColumnRowBoxScreen()
            },
            description = "创建Column、Row和Box,如何在Composable中添加Modifier," +
                    "设置padding、margin、alignment和其他可组合的属性到Composable中",
            tags = listOf(
                TAG_COMPOSE,
                TAG_COMPOSE_COLUMN,
                TAG_COMPOSE_ROW,
                TAG_COMPOSE_BOX,
                TAG_COMPOSE_MODIFIER
            )
        )

        val controlLearn1_2 = ControlLearnSectionModel(
            title = "1-2 Surface, Shape, Clickable",
            action = {
                ControlLearn1_2ClickSurfaceAndClicks()
            },
            description = "创建和修改Surface(表层)来绘制可组合的背景,给任意组合添加点击事件",
            tags = listOf(
                TAG_COMPOSE,
                TAG_COMPOSE_MODIFIER,
                TAG_COMPOSE_SURFACE,
                TAG_COMPOSE_SHAPE
            )
        )

        val controlLearn2_1 = ControlLearnSectionModel(
            title = "2-1 Text",
            action = {
                ControlLearn2_1Screen()
            },
            description = "创建具有不同属性的文本组件," +
                    "如color、background、font weight、family、style、spacing和其他",
            tags = listOf(
                TAG_COMPOSE,
                TAG_TEXT,
                TAG_FONT_STYLE,
                TAG_ANNOTATED_STRING,
                TAG_HYPERLINK
            )
        )

        return listOf(controlLearn1_1, controlLearn1_2, controlLearn2_1)
    }
}




