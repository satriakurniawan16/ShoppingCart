package com.example.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.atom.AppButton
import com.example.ui.atom.AppText

@Composable
fun CheckoutFooter(
    totalPrice: Double,
    isCheckoutEnabled: Boolean,
    showReset: Boolean,
    onCheckoutClick: () -> Unit,
    onResetClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {

        // 🔹 TOTAL
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AppText(
                text = "Total:",
                fontWeight = FontWeight.Medium
            )

            AppText(
                text = "$ ${"%.2f".format(totalPrice)}",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        AppButton(
            text = "Checkout",
            enabled = isCheckoutEnabled,
            onClick = onCheckoutClick
        )

        if (showReset) {
            Spacer(modifier = Modifier.height(12.dp))

            AppButton(
                text = "Reset",
                isOutlined = true,
                onClick = onResetClick
            )
        }
    }
}