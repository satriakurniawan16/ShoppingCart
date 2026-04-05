package com.example.product.domain.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val discountPercentage: Double,
    val stock: Int,
    val tags: List<String>,
    val brand: String,
    val price: Double
)
