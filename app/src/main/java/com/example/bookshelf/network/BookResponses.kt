package com.example.bookshelf.network

// Respuesta de: GET https://www.googleapis.com/books/v1/volumes?q=...
data class BookSearchResponse(
    val items: List<BookSearchItem>?
)

data class BookSearchItem(
    val id: String
)

// Respuesta de: GET https://www.googleapis.com/books/v1/volumes/<volume_id>
data class BookDetailResponse(
    val id: String,
    val volumeInfo: VolumeInfo?
)

data class VolumeInfo(
    val title: String?,
    val imageLinks: ImageLinks?
)

data class ImageLinks(
    val thumbnail: String?
)