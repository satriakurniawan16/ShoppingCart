package com.example.product.ui.model

data class ProductUiModel(
    val id: Int = 0,
    val title: String = "",
    val shortDescription: String = "",
    val category: String = "",
    val ratingText: String = "",
    val stock: Int = 0,
    val brand: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0
)