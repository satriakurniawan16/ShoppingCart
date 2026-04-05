package com.example.product.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.product.ui.model.SortType
import com.example.product.ui.model.toDisplayName
import com.example.ui.atom.AppDropdown
import com.example.ui.atom.AppIcon

@Composable
fun SortBySection(
    selected: SortType,
    onSelected: (SortType) -> Unit
) {

    val options = SortType.values().map { it.toDisplayName() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                AppIcon(
                    imageVector = Icons.Default.Sort,
                    tint = Color.White,
                    modifier = Modifier.size(38.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Sort By:",
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }

            AppDropdown(
                options = options,
                selected = selected.toDisplayName(),
                onSelected = { selectedText ->
                    val type = SortType.values()
                        .first { it.toDisplayName() == selectedText }

                    onSelected(type)
                }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Divider(color = Color.LightGray, thickness = 1.dp)
    }
}