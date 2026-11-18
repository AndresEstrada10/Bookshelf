package com.example.bookshelf.fake

import com.example.bookshelf.network.BookDetailResponse
import com.example.bookshelf.network.BookSearchResponse
import com.example.bookshelf.network.BookService

class FakeBookService : BookService {
    override suspend fun searchBooks(query: String): BookSearchResponse {
        return FakeDataSource.searchResponse
    }

    override suspend fun getBook(id: String): BookDetailResponse {
        return FakeDataSource.detailResponses.getValue(id)
    }
}