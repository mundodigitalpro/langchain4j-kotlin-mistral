package dev.josejordan

import dev.langchain4j.model.mistralai.MistralAiChatModel

fun main() {
    val model = MistralAiChatModel.builder()
        .apiKey("apiKey")
        .modelName("mistral-small")
        .build()

    val conversationHistory = mutableListOf<String>()

    while (true) {
        print("You:>")

        val question = readlnOrNull()?.trim()

        if (question.isNullOrEmpty()) {
            println("Assistant:> Please ask a question or say something to continue.")
            continue
        }

        conversationHistory.add("User: $question")

        val context = conversationHistory.joinToString(separator = "\n")

        val answer = model.generate(context)
        conversationHistory.add("Assistant:> $answer")

        println("Assistant:> $answer")
    }
}