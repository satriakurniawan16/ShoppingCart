package com.example.product.data.repository

import com.example.network.api.ProductApi
import com.example.product.data.mapper.toDomain
import com.example.product.domain.model.Product
import com.example.product.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return api.getProducts()
            .products
            ?.map { it.toDomain() }
            ?: emptyList()
    }
}