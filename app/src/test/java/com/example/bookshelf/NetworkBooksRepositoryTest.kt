package com.example.bookshelf

import com.example.bookshelf.data.NetworkBooksRepository
import com.example.bookshelf.fake.FakeBookService
import com.example.bookshelf.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkBooksRepositoryTest {

    @Test
    fun networkBooksRepository_getBooks_verifyBookList() = runTest {
        val repository = NetworkBooksRepository(FakeBookService())
        assertEquals(FakeDataSource.expectedBooks, repository.getBooks("jazz history"))
    }
}