package com.example.firebaseauth.presentation.otp_verification_screen

import androidx.lifecycle.ViewModel
import com.example.firebaseauth.presentation.util.PhoneNumberConstants
import com.example.firebaseauth.presentation.util.PhoneNumberConstants.VERIFICATION_CODE_LENGTH
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OtpVerificationViewModel @Inject constructor() : ViewModel() {
    private var _otpState = MutableStateFlow(OtpUiState())
    val otpState = _otpState.asStateFlow()

    private val codeLength = VERIFICATION_CODE_LENGTH

    fun updateVerificationCode(newText: String) {
        val digitsOnly = PhoneNumberConstants.NUMERIC_REGEX.replace(newText, "")
        if (newText.length <= codeLength) {
            _otpState.update {
                it.copy(
                    verificationCode = digitsOnly,
                    shouldVerify = codeLength == digitsOnly.length
                )
            }
        }
    }
}

data class OtpUiState(
    val verificationCode: String = "",
    val shouldVerify: Boolean = false
)