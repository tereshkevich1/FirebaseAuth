package com.example.firebaseauth.presentation.login_screen

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.firebaseauth.R
import com.example.firebaseauth.presentation.AuthViewModel
import com.example.firebaseauth.presentation.CountryCodeViewModel
import com.example.firebaseauth.presentation.login_screen.components.PhoneNumberInputRow
import com.example.firebaseauth.presentation.login_screen.components.PrimaryButton
import com.example.firebaseauth.presentation.util.components.HeaderWithDescription
import com.example.firebaseauth.ui.theme.DpSpSize
import com.example.firebaseauth.ui.theme.SurfaceBackground

@Composable
fun PhoneNumberInputScreen(
    onCountryCodeButtonClick: () -> Unit,
    onContinueButtonClick: () -> Unit,
    countryCodeViewModel: CountryCodeViewModel,
    phoneNumberViewModel: PhoneNumberViewModel,
    authViewModel: AuthViewModel
) {
    val country by countryCodeViewModel.country.collectAsState()
    val phoneNumber = phoneNumberViewModel.phoneNumber

    val horizontalPadding = DpSpSize.screenHorizontalPadding
    val topPadding = DpSpSize.screenTopPadding

    val currentActivity = LocalActivity.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceBackground)
            .padding(
                start = horizontalPadding,
                end = horizontalPadding,
                top = topPadding
            )
    ) {
        HeaderWithDescription(
            headerText = stringResource(R.string.lets_get_started),
            descriptionText = stringResource(R.string.enter_phone_number_message)
        )

        Spacer(modifier = Modifier.height(DpSpSize.paddingLarge))

        PhoneNumberInputRow(
            country = country,
            phoneNumber = phoneNumber,
            onPhoneNumberChange = {
                phoneNumberViewModel.updatePhoneNumber(it, country.phoneNumberLength)
            },
            onCountryCodeButtonClick = onCountryCodeButtonClick,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(DpSpSize.paddingMedium))

        PrimaryButton(
            onClick = {
                onContinueButtonClick()
                currentActivity?.let {
                    authViewModel.startPhoneNumberVerification(country.code + phoneNumber, it)
                }
            },
            enabled = phoneNumberViewModel.isPhoneNumberComplete(country.phoneNumberLength),
            text = stringResource(R.string.continue_text)
        )
    }
}