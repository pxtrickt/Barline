package com.example.Barline.home

data class User(
    val name: String = "",
    val level: String = "",
    val instrument: String = "",
    val grade: String = "",
    val pieces: List<Piece> = emptyList()
)

data class Piece(
    val title: String = "",
    val count: Int = 0,
    val notes: List<Notes> = emptyList()
)

data class Notes(
    val title: String = "",
    val date: String = "",
    val content: String = ""
)


