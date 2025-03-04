package com.example.firebaseauth.presentation.login_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.firebaseauth.ui.theme.DpSpSize
import com.example.firebaseauth.ui.theme.PrimaryButtonContainerColor
import com.example.firebaseauth.ui.theme.PrimaryButtonContentColor

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            contentColor = PrimaryButtonContentColor,
            containerColor = PrimaryButtonContainerColor
        ),
        modifier = modifier
            .height(DpSpSize.primaryButtonHeight)
            .fillMaxWidth(),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}