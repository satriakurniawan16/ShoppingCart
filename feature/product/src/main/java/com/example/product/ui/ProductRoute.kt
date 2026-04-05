package com.example.product.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.product.presetation.viewmodel.ProductViewModel

@Composable
fun ProductRoute(
    viewModel: ProductViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val sortType by viewModel.sortType.collectAsState()
    val dialogState by viewModel.dialogState.collectAsState()

    ProductScreen(
        state = state,
        sortType = sortType,
        viewModel = viewModel,
        onSortChange = {viewModel.setSortType(it)},
        onIncrease = { viewModel.increaseQuantity(it) },
        onDecrease = { viewModel.decreaseQuantity(it) },
        dialogState = dialogState

    )
}