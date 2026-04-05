package com.example.ui.molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ui.atom.CounterButton

@Composable
fun QuantitySelector(
    quantity: Int,
    isIncreaseEnabled: Boolean,
    isDecreaseEnabled: Boolean,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Row(
        modifier = Modifier
            .width(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF2F2F2))
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        CounterButton("-", isDecreaseEnabled, onDecrease)

        Text(
            text = quantity.toString(),
            modifier = Modifier.width(24.dp),
            textAlign = TextAlign.Center
        )

        CounterButton("+", isIncreaseEnabled, onIncrease)
    }
}