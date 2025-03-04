package com.example.firebaseauth.presentation.login_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.firebaseauth.presentation.login_screen.util.CountryCode
import com.example.firebaseauth.presentation.login_screen.util.PhoneNumberTransformation

@Composable
fun PhoneNumberInputRow(
    code: CountryCode,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = onPhoneNumberChange,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PhoneNumberTransformation(code),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}