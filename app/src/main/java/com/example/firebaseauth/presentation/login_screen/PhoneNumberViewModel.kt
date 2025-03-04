package com.example.firebaseauth.presentation.login_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.firebaseauth.presentation.login_screen.util.CountryCode
import com.example.firebaseauth.presentation.login_screen.util.PhoneNumberConstants

class PhoneNumberViewModel : ViewModel() {
    var countryCode by mutableStateOf(CountryCode.BY)
    var phoneNumber by mutableStateOf("")

    private val phoneNumberLength = countryCode.phoneNumberLength

    fun updatePhoneNumber(newText: String) {
        val digitsOnly = PhoneNumberConstants.NUMERIC_REGEX.replace(newText, "")
        phoneNumber = if (digitsOnly.length >= phoneNumberLength) {
            digitsOnly.substring(0..<phoneNumberLength)
        } else {
            digitsOnly
        }
    }
}