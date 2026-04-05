package com.example.product.data.mapper

import com.example.network.model.ProductItem
import com.example.product.domain.model.Product

fun ProductItem.toDomain(): Product {
    return Product(
        id = id ?: 0,
        title = title.orEmpty(),
        description = description.orEmpty(),
        category = category.orEmpty(),
        discountPercentage = discountPercentage ?: 0.0,
        rating = rating ?: 0.0,
        stock = stock ?: 0,
        tags = tags ?: emptyList(),
        brand = brand.orEmpty(),
        price = price ?: 0.0,
    )
}