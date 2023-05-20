package com.example.quizwhiz.utils

object ColorPicker {
    val colors = arrayOf(
        "#ccd5ae",
        "#d4a373",
        "#2ec4b6",
        "#a2d2ff",
        "#2a9d8f",
        "#c6ac8f",
        "#00f5d4",
        "#cdb4db",
        "#8d99ae",
        "#ecf39e",
        "#e29578",
        "#457b9d"
    )
    var currentColorIndex = 0

    fun getColor(): String {
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]
    }
}