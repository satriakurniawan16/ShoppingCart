package com.example.product.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.product.ui.model.ProductUiModel
import com.example.product.ui.model.SortType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductList(
    products: List<ProductUiModel>,
    sortType: SortType,
    onSortChange: (SortType) -> Unit,
    onIncrease: (Int) -> Unit,
    onDecrease: (Int) -> Unit
) {

    LazyColumn {
        // 👇 sticky header
        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White) // 👈 penting banget
            ) {
                SortBySection(
                    selected = sortType,
                    onSelected = onSortChange
                )
            }
        }

        items(
            items = products,
            key = { it.id }
        ) { product ->
            ProductCard(
                product = product,
                onIncrease = { onIncrease(product.id) },
                onDecrease = { onDecrease(product.id) }
            )
        }
    }
}



