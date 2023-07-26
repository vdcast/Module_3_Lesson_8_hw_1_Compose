package com.example.module_3_lesson_8_hw_1_compose

class ApiManager {
    private val listOfText = listOf(
        "Don't hesitate, you came this far", "Now finish the whole dream",
        "Nobody said it'd be easy though", "Just stick to your plan",
        "They don't understand going up against the odds",
        "Having no regards make our own laws", "You can be your own boss",
        "But they don't tell you that", "All you need is a foundation to stand on",
        "And you can build it then the limit is the sky"
    )
    private var counter = 0

    fun getNewText(): String {
        val newText = listOfText[counter % listOfText.size]
        counter ++
        return newText
    }
}