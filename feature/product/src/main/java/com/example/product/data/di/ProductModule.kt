package com.example.product.data.di

import com.example.product.data.repository.ProductRepositoryImpl
import com.example.product.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductModule {

    @Binds
    abstract fun bindRepository(
        impl: ProductRepositoryImpl
    ): ProductRepository
}