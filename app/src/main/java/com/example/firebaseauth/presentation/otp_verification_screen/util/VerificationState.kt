package com.example.firebaseauth.presentation.otp_verification_screen.util

data class VerificationState(
    val timeLeft: Int,
    val canResend: Boolean
)