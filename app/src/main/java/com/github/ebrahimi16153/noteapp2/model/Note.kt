package com.github.ebrahimi16153.noteapp2.model

import java.util.*

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String
)
