package com.example.bmizad2.ui.quiz

object QuestionAnswer {
    @JvmField
    var question = arrayOf(
        "Which one isn't a fruit?",
        "Body mass index shortcut is:",
        "Which one isn't a vegetable?",
        "Jonagold is a kind of?",
        "Which one is a citrus?",
        "Which one has the most vit. C?"
    )
    @JvmField
    var choices = arrayOf(
        arrayOf("Banana", "Cucumber", "Orange", "Watermelon"),
        arrayOf("BMI", "MBI", "BMX", "MIX"),
        arrayOf("Banana", "Onion", "Garlic", "Carrot"),
        arrayOf("Jewelery", "Apple", "Orange", "Citron"),
        arrayOf("Kiwi", "Apple", "Ananas", "Potato"),
        arrayOf("Kiwi", "Orange", "Citron", "Onion")
    )
    @JvmField
    var correctAnswers = arrayOf(
        "Cucumber",
        "BMI",
        "Banana",
        "Apple",
        "Kiwi",
        "Citron"
    )
}