package com.example.product.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.product.ui.model.ProductUiModel
import com.example.ui.molecule.QuantitySelector


@Composable
fun ProductCard(
    product: ProductUiModel,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {

    val isIncreaseEnabled = product.quantity < product.stock
    val isDecreaseEnabled = product.quantity > 0

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // LEFT CONTENT
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(
                text = product.title,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "$ ${product.price}",
                color = Color.Gray
            )
        }

        QuantitySelector(
            quantity = product.quantity,
            isIncreaseEnabled = isIncreaseEnabled,
            isDecreaseEnabled = isDecreaseEnabled,
            onIncrease = onIncrease,
            onDecrease = onDecrease
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {

    val dummyProducts =
        ProductUiModel(
            id = 1,
            title = "Product 1",
            shortDescription = "Description 1",
            ratingText = "⭐ 4.5",
            price = 370000.0
        )

    ProductCard (
        product = dummyProducts,
        onIncrease = {},
        onDecrease = {}
    )
}