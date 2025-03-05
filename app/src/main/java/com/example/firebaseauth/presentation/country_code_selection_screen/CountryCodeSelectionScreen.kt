package com.example.firebaseauth.presentation.country_code_selection_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.firebaseauth.R
import com.example.firebaseauth.presentation.CountryCodeViewModel
import com.example.firebaseauth.presentation.country_code_selection_screen.components.CountryItem
import com.example.firebaseauth.presentation.login_screen.PhoneNumberViewModel
import com.example.firebaseauth.presentation.util.Country
import com.example.firebaseauth.presentation.util.components.BackNavigationRow
import com.example.firebaseauth.ui.theme.BorderColor
import com.example.firebaseauth.ui.theme.DpSpSize.lazyColumnHorizontalPadding
import com.example.firebaseauth.ui.theme.DpSpSize.lazyColumnSpacingHeight
import com.example.firebaseauth.ui.theme.DpSpSize.paddingMedium
import com.example.firebaseauth.ui.theme.DpSpSize.screenHorizontalPadding
import com.example.firebaseauth.ui.theme.PrimaryTextColor

@Composable
fun CountryCodeSelectionScreen(
    onBack: () -> Unit,
    onSelect: () -> Unit,
    countryCodeViewModel: CountryCodeViewModel,
    phoneNumberViewModel: PhoneNumberViewModel
) {
    val currentCountry by countryCodeViewModel.country.collectAsState()

    val horizontalPadding = screenHorizontalPadding
    val cardClipShape = MaterialTheme.shapes.medium

    Column(modifier = Modifier.fillMaxSize()) {
        BackNavigationRow(onBack = onBack)

        Text(
            text = stringResource(R.string.country),
            style = MaterialTheme.typography.displayMedium,
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
            items(Country.entries, key = { country -> country.name }) { country: Country ->
                Spacer(modifier = Modifier.height(lazyColumnSpacingHeight))
                CountryItem(
                    onClick = {
                        countryCodeViewModel.updateCountry(country)
                        phoneNumberViewModel.resetPhoneNumber()
                        onSelect()
                    },
                    name = country.name,
                    code = country.code,
                    flagPainter = painterResource(country.flagResId),
                    selected = country == currentCountry
                )
                Spacer(modifier = Modifier.height(lazyColumnSpacingHeight))
            }
        }
    }
}