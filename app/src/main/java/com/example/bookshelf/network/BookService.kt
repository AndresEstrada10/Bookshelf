package com.example.bookshelf.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookService {
    // Busca libros según el término (parámetro "q").
    @GET("volumes?maxResults=6")
    suspend fun searchBooks(@Query("q") query: String): BookSearchResponse

    // Obtiene la información de un libro específico por su id.
    @GET("volumes/{id}")
    suspend fun getBook(@Path("id") id: String): BookDetailResponse
}