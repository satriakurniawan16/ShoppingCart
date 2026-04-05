package com.example.product.domain.repository

import com.example.product.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}