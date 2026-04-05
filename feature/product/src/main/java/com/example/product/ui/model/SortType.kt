package com.example.product.ui.model

enum class SortType {
    DEFAULT,
    NAME,
    HIGHEST_PRICE,
    LOWEST_PRICE
}

fun SortType.toDisplayName(): String {
    return when (this) {
        SortType.DEFAULT -> "Default"
        SortType.NAME -> "Name"
        SortType.HIGHEST_PRICE -> "Highest Price"
        SortType.LOWEST_PRICE -> "Lowest Price"
    }
}