package com.example.firebaseauth.presentation.login_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.firebaseauth.presentation.util.PhoneNumberConstants

class PhoneNumberViewModel : ViewModel() {
    var phoneNumber by mutableStateOf("")

    fun updatePhoneNumber(newText: String, phoneNumberLength: Int) {
        val digitsOnly = PhoneNumberConstants.NUMERIC_REGEX.replace(newText, "")
        phoneNumber = if (digitsOnly.length >= phoneNumberLength) {
            digitsOnly.substring(0..<phoneNumberLength)
        } else {
            digitsOnly
        }
    }

    fun isPhoneNumberComplete(phoneNumberLength: Int): Boolean =
        phoneNumber.length == phoneNumberLength


    fun resetPhoneNumber() {
        phoneNumber = ""
    }
}