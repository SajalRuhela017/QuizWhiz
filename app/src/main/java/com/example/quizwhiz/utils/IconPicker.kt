package com.example.quizwhiz.utils

import com.example.quizwhiz.R

object IconPicker {
    val icons = arrayOf(
        R.drawable.doodle_bell_icon,
        R.drawable.doodle_board ,
        R.drawable.doodle_book ,
        R.drawable.doodle_briefcase ,
        R.drawable.doodle_calculator ,
        R.drawable.doodle_document ,
        R.drawable.doodle_pencil,
        R.drawable.doodle_bell_icon,
        R.drawable.doodle_ruler,
        R.drawable.doodle_scholar_hat,
        R.drawable.doodle_school_building
    )
    var currentItem = 0;
    fun getIcon(): Int {
        currentItem = (currentItem + 1) % icons.size
        return icons[currentItem]
    }
}