package com.example.product.presetation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.product.domain.repository.ProductRepository
import com.example.product.presetation.state.ProductUiState
import com.example.product.ui.mapper.toUiModel
import com.example.product.ui.model.ProductUiModel
import com.example.product.ui.model.SortType
import com.example.ui.molecule.CheckoutDialogState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)
    val uiState: StateFlow<ProductUiState> = _uiState

    private val _sortType = MutableStateFlow(SortType.DEFAULT)
    val sortType: StateFlow<SortType> = _sortType

    private val _dialogState = MutableStateFlow<CheckoutDialogState?>(null)
    val dialogState: StateFlow<CheckoutDialogState?> = _dialogState

    private var originalProducts: List<ProductUiModel> = emptyList()

    init {
        getProducts()
    }

    fun setSortType(type: SortType) {
        _sortType.value = type
        applySort() // 👈 trigger sorting
    }

    private fun getProducts() {
        viewModelScope.launch {
            _uiState.value = ProductUiState.Loading

            try {
                val data = repository
                    .getProducts()
                    .map { it.toUiModel() }

                // 👇 simpan data asli
                originalProducts = data

                // 👇 langsung apply sort (default)
                applySort()

            } catch (e: Exception) {
                _uiState.value = ProductUiState.Error(
                    e.message ?: "Unknown error"
                )
            }
        }
    }

    private fun applySort() {
        val sorted = when (_sortType.value) {

            SortType.DEFAULT -> originalProducts

            SortType.NAME -> originalProducts.sortedBy {
                it.title
            }

            SortType.HIGHEST_PRICE -> originalProducts.sortedByDescending {
                it.price
            }

            SortType.LOWEST_PRICE -> originalProducts.sortedBy {
                it.price
            }
        }

        _uiState.value = ProductUiState.Success(sorted)
    }

    fun increaseQuantity(id: Int) {
        originalProducts = originalProducts.map {
            if (it.id == id) it.copy(quantity = it.quantity + 1)
            else it
        }
        applySort()
    }

    fun decreaseQuantity(id: Int) {
        originalProducts = originalProducts.map {
            if (it.id == id && it.quantity > 0)
                it.copy(quantity = it.quantity - 1)
            else it
        }
        applySort()
    }

    fun onIncrease(id: Int) {
        _uiState.update { current ->
            if (current is ProductUiState.Success) {
                current.copy(
                    products = current.products.map {
                        if (it.id == id && it.quantity < it.stock)
                            it.copy(quantity = it.quantity + 1)
                        else it
                    }
                )
            } else current
        }
    }

    fun onDecrease(id: Int) {
        _uiState.update { current ->
            if (current is ProductUiState.Success) {
                current.copy(
                    products = current.products.map {
                        if (it.id == id && it.quantity > 0)
                            it.copy(quantity = it.quantity - 1)
                        else it
                    }
                )
            } else current
        }
    }

    fun onReset() {
        _uiState.update { current ->
            if (current is ProductUiState.Success) {
                current.copy(
                    products = current.products.map {
                        it.copy(quantity = 0)
                    }
                )
            } else current
        }
    }

    fun onCheckout() {
        val totalItems = originalProducts.sumOf { it.quantity }
        val totalPrice = originalProducts.sumOf { it.price * it.quantity }

        _dialogState.value = CheckoutDialogState(
            totalItems = totalItems,
            totalPrice = totalPrice
        )
    }

    fun dismissDialog() {
        _dialogState.value = null
    }

}