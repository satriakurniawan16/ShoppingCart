package com.example.ui.molecule

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ui.atom.AppIcon
import com.example.ui.atom.AppText
import com.example.ui.theme.Dimens
import com.example.ui.theme.ShoppingAppTheme

@Composable
fun LoadingContent(
    modifier: Modifier = Modifier,
    title: String = "Loading Product Data",
    subtitle: String = "Please wait..."
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AppIcon(
            imageVector = Icons.Default.PhoneAndroid,
            modifier = Modifier.size(Dimens.IconSize)
        )

        Spacer(modifier = Modifier.height(Dimens.SpacingMedium))

        AppText(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(Dimens.SpacingSmall))

        AppText(
            text = subtitle,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Preview(name = "Light Phone", showBackground = true)
@Preview(
    name = "Dark Phone",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(name = "Tablet", device = "spec:width=800dp,height=1280dp")
@Composable
fun LoadingContentPreview() {
    ShoppingAppTheme {
        LoadingContent(title = "Loading", subtitle = "please wait")
    }
}
