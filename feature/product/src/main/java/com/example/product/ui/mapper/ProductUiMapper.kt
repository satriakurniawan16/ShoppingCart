package com.example.product.ui.mapper

import com.example.product.domain.model.Product
import com.example.product.ui.model.ProductUiModel

fun Product.toUiModel(): ProductUiModel {
    return ProductUiModel(
        id = id,
        title = title,
        shortDescription = description.take(50),
        stock = stock,
        price = price
    )
}