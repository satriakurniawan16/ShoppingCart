package com.example.product.ui

import AppTopBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.product.presetation.state.ProductUiState
import com.example.product.presetation.viewmodel.ProductViewModel
import com.example.product.ui.component.ProductList
import com.example.product.ui.model.SortType
import com.example.ui.molecule.CheckoutDialogState
import com.example.ui.molecule.LoadingContent
import com.example.ui.organism.CheckoutFooter
import com.example.ui.organism.SuccessDialog

@Composable
fun ProductScreen(
    state: ProductUiState,
    sortType: SortType,
    onSortChange: (SortType) -> Unit,
    onIncrease: (Int) -> Unit,
    onDecrease: (Int) -> Unit,
    dialogState: CheckoutDialogState?,
    viewModel: ProductViewModel
) {

    val dialogState by viewModel.dialogState.collectAsState()

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Product List",
                count = if (state is ProductUiState.Success) state.products.size else null,
                isLoading = state is ProductUiState.Loading
            )
        },
        bottomBar =  {
            if (state is ProductUiState.Success) {

                val products = state.products

                val totalPrice = products.sumOf {
                    it.price * it.quantity
                }

                val isCheckoutEnabled = totalPrice > 0
                val showReset = totalPrice > 0

                CheckoutFooter(
                    totalPrice = totalPrice,
                    isCheckoutEnabled = isCheckoutEnabled,
                    showReset = showReset,
                    onCheckoutClick = {viewModel.onCheckout()
                    },
                    onResetClick = {
                        viewModel.onReset()
                    }
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding) // 👈 WAJIB
                .fillMaxSize()
        ) {

            when (state) {

                is ProductUiState.Loading -> {
                    LoadingContent()
                }

                is ProductUiState.Success -> {
                    val products = state.products

                    val totalPrice = products.sumOf {
                        it.price * it.quantity
                    }

                    val isCheckoutEnabled = totalPrice > 0
                    val showReset = totalPrice > 0


                    ProductList(
                        products = state.products,
                        sortType = sortType,
                        onSortChange = onSortChange,
                        onIncrease = onIncrease,
                        onDecrease = onDecrease
                    )
                }

                is ProductUiState.Error -> {
                    Text("Error: ${state.message}")
                }
            }
        }
    }

    dialogState?.let {
        SuccessDialog(
            totalPrice = "Rp. %.2f".format(it.totalPrice),
            totalItems = it.totalItems,
            onClose = { viewModel.dismissDialog() }
        )
    }
}
