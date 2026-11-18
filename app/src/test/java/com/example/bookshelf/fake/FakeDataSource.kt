package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BookDetailResponse
import com.example.bookshelf.network.BookSearchItem
import com.example.bookshelf.network.BookSearchResponse
import com.example.bookshelf.network.ImageLinks
import com.example.bookshelf.network.VolumeInfo

object FakeDataSource {
    const val idOne = "id1"
    const val idTwo = "id2"

    val searchResponse = BookSearchResponse(
        items = listOf(BookSearchItem(idOne), BookSearchItem(idTwo))
    )

    val detailResponses = mapOf(
        idOne to BookDetailResponse(
            id = idOne,
            volumeInfo = VolumeInfo("Libro uno", ImageLinks("http://books.google.com/thumb1"))
        ),
        idTwo to BookDetailResponse(
            id = idTwo,
            volumeInfo = VolumeInfo("Libro dos", ImageLinks("http://books.google.com/thumb2"))
        )
    )

    // Resultado esperado del repositorio (con la URL ya convertida a https).
    val expectedBooks = listOf(
        Book(idOne, "Libro uno", "https://books.google.com/thumb1"),
        Book(idTwo, "Libro dos", "https://books.google.com/thumb2")
    )
}