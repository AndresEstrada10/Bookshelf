package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BookService

interface BooksRepository {
    suspend fun getBooks(query: String): List<Book>
}

class NetworkBooksRepository(
    private val bookService: BookService
) : BooksRepository {

    override suspend fun getBooks(query: String): List<Book> {
        // 1. Primera solicitud: buscar libros y obtener sus ids.
        val ids = bookService.searchBooks(query).items.orEmpty().map { it.id }

        // 2. Solicitudes individuales, una tras otra en la misma corrutina.
        return ids.map { id ->
            val detail = bookService.getBook(id)
            Book(
                id = detail.id,
                title = detail.volumeInfo?.title ?: "",
                // Se reemplaza http por https para que se muestren las imágenes.
                thumbnailUrl = detail.volumeInfo?.imageLinks?.thumbnail
                    ?.replace("http://", "https://")
            )
        }
    }
}