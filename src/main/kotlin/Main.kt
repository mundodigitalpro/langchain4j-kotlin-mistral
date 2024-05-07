package dev.josejordan

import dev.langchain4j.model.mistralai.MistralAiChatModel

fun main() {
    val model = MistralAiChatModel.builder()
        .apiKey("mistralApiKey")
        .modelName("mistral-small")
        .build()

    val conversationHistory = mutableListOf<String>()

    while (true) {
        print("You:>")

        val question = readlnOrNull()?.trim()
        conversationHistory.add("User: $question")

        val context = conversationHistory.joinToString(separator = "\n")

        val answer = model.generate(context)
        conversationHistory.add("Assistant: $answer")

        println("Assistant: $answer")
    }
}