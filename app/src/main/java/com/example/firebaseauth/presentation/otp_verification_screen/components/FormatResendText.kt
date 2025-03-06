package com.example.firebaseauth.presentation.otp_verification_screen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.firebaseauth.R
import com.example.firebaseauth.presentation.util.PhoneNumberConstants

@Composable
fun formatResendText(timeLeft: Int): String {
    return if (timeLeft == PhoneNumberConstants.VERIFICATION_TIMER_DURATION) {
        stringResource(R.string.no_code_received)
    } else {
        stringResource(R.string.resend_code, timeLeft / 60, timeLeft % 60)
    }
}