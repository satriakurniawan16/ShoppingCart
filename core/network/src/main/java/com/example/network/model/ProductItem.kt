package com.example.network.model

import com.google.gson.annotations.SerializedName

data class ProductItem(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("discountPercentage")
    val discountPercentage: Double?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("stock")
    val stock: Int?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("price")
    val price: Double?
)