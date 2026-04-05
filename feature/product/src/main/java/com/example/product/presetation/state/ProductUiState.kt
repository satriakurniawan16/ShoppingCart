package com.example.product.presetation.state

import com.example.product.ui.model.ProductUiModel

sealed interface ProductUiState {

    object Loading : ProductUiState

    data class Success(
        val products: List<ProductUiModel>
    ) : ProductUiState

    data class Error(
        val message: String
    ) : ProductUiState
}