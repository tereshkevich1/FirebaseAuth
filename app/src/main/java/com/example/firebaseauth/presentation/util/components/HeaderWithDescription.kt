package com.example.firebaseauth.presentation.util.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.firebaseauth.ui.theme.DpSpSize
import com.example.firebaseauth.ui.theme.HintTextColor
import com.example.firebaseauth.ui.theme.PrimaryTextColor

@Composable
fun HeaderWithDescription(
    headerText: String,
    descriptionText: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = headerText,
            style = MaterialTheme.typography.headlineMedium,
            color = PrimaryTextColor
        )
        Spacer(modifier = Modifier.height(DpSpSize.paddingSmall))
        Text(
            text = descriptionText,
            style = MaterialTheme.typography.bodyLarge,
            color = HintTextColor
        )
    }
}