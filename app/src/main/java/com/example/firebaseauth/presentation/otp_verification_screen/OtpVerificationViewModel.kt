package com.example.firebaseauth.presentation.otp_verification_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.firebaseauth.presentation.util.PhoneNumberConstants
import com.example.firebaseauth.presentation.util.PhoneNumberConstants.VERIFICATION_CODE_LENGTH
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OtpVerificationViewModel @Inject constructor() : ViewModel() {
    var verificationCode by mutableStateOf("")
    private val codeLength = VERIFICATION_CODE_LENGTH

    fun updateVerificationCode(newText: String) {
        val digitsOnly = PhoneNumberConstants.NUMERIC_REGEX.replace(newText, "")
        if (newText.length <= codeLength) {
            verificationCode = digitsOnly
        }
    }
}