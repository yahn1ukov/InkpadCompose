package com.ua.inkpadcompose.data.models.enums

import androidx.compose.ui.graphics.Color
import com.ua.inkpadcompose.presentation.theme.HighPriorityColor
import com.ua.inkpadcompose.presentation.theme.LowPriorityColor
import com.ua.inkpadcompose.presentation.theme.MediumPriorityColor
import com.ua.inkpadcompose.presentation.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}