package com.linx.jetpack_compose_control_learn.components

import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.graphics.Path

/**
 * 钻石型的shape
 */
val diamondShape = GenericShape{ size, layoutDirection ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(size.width / 2f, size.height)
    lineTo(0f, size.height / 2f)
}

/**
 * 三角形的shape
 */
val triangleShape = GenericShape{ size, layoutDirection ->
    val path = Path()
    path.apply {
        moveTo(0f, 0f)
        lineTo(size.width, 0f)
        lineTo(0f, size.height)
        lineTo(0f, 0f)
    }
    addPath(path = path)
}