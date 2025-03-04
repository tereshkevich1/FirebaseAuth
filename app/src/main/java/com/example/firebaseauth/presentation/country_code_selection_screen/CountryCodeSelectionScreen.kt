package com.example.firebaseauth.presentation.country_code_selection_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firebaseauth.R
import com.example.firebaseauth.presentation.country_code_selection_screen.components.CountryItem
import com.example.firebaseauth.presentation.util.Country
import com.example.firebaseauth.presentation.util.components.BackNavigationRow
import com.example.firebaseauth.ui.theme.BorderColor
import com.example.firebaseauth.ui.theme.DpSpSize.lazyColumnHorizontalPadding
import com.example.firebaseauth.ui.theme.DpSpSize.lazyColumnSpacingHeight
import com.example.firebaseauth.ui.theme.DpSpSize.paddingMedium
import com.example.firebaseauth.ui.theme.DpSpSize.screenHorizontalPadding
import com.example.firebaseauth.ui.theme.FirebaseAuthTheme
import com.example.firebaseauth.ui.theme.PrimaryTextColor
import com.example.firebaseauth.ui.theme.SurfaceBackground

@Composable
fun CountryCodeSelectionScreen(onBack: () -> Unit, onSelect: () -> Unit) {
    val horizontalPadding = screenHorizontalPadding
    val cardClipShape = MaterialTheme.shapes.medium

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceBackground)
    ) {
        BackNavigationRow(onBack = onBack)
        Text(
            text = stringResource(R.string.country),
            style = MaterialTheme.typography.headlineMedium,
            color = PrimaryTextColor,
            modifier = Modifier.padding(horizontal = horizontalPadding)
        )
        Spacer(modifier = Modifier.height(paddingMedium))

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = horizontalPadding)
                .clip(cardClipShape)
                .background(Color.White)
                .border(width = 0.5.dp, color = BorderColor, shape = cardClipShape),
            contentPadding = PaddingValues(horizontal = lazyColumnHorizontalPadding)
        ) {
            items(Country.entries) { country: Country ->
                Spacer(modifier = Modifier.height(lazyColumnSpacingHeight))
                CountryItem(
                    onClick = { onSelect() },
                    name = country.name,
                    code = country.code,
                    flagPainter = painterResource(country.flagResId),
                    selected = true
                )
                Spacer(modifier = Modifier.height(lazyColumnSpacingHeight))
            }
        }
    }
}

@Composable
@Preview
fun CountryCodeSelectionScreenPreview() {
    FirebaseAuthTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(SurfaceBackground.copy(alpha = 0.5f))
                    .padding(it)
            ) {
                CountryCodeSelectionScreen({},{})
            }
        }
    }
}