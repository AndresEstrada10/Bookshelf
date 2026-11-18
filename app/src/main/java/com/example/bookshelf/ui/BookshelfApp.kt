package com.example.bookshelf.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp(modifier: Modifier = Modifier) {
    val bookshelfViewModel: BookshelfViewModel =
        viewModel(factory = BookshelfViewModel.Factory)

    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text("Bookshelf") }) }
    ) { innerPadding ->
        BookshelfScreen(
            uiState = bookshelfViewModel.bookshelfUiState,
            retryAction = bookshelfViewModel::getBooks,
            contentPadding = innerPadding
        )
    }
}