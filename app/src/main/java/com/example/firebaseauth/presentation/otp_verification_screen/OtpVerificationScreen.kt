package com.example.firebaseauth.presentation.otp_verification_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.firebaseauth.R
import com.example.firebaseauth.presentation.util.components.HeaderWithDescription

@Composable
fun OtpVerificationScreen() {
    HeaderWithDescription(
        headerText = stringResource(R.string.code),
        descriptionText = stringResource(R.string.enter_code)
    )
}