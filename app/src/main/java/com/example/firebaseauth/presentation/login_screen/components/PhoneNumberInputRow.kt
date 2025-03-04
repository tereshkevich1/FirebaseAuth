package com.example.firebaseauth.presentation.login_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.firebaseauth.R
import com.example.firebaseauth.presentation.login_screen.util.CountryCode
import com.example.firebaseauth.presentation.login_screen.util.PhoneNumberTransformation
import com.example.firebaseauth.ui.theme.CursorThumbColor
import com.example.firebaseauth.ui.theme.DpSpSize
import com.example.firebaseauth.ui.theme.HintTextColor
import com.example.firebaseauth.ui.theme.InputBackgroundFocused
import com.example.firebaseauth.ui.theme.InputBackgroundUnfocused
import com.example.firebaseauth.ui.theme.PrimaryButtonContainerColor
import com.example.firebaseauth.ui.theme.PrimaryTextColor

@Composable
fun PhoneNumberInputRow(
    countryCode: CountryCode,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    onCountryCodeButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textStyle = MaterialTheme.typography.bodyLarge
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.height(DpSpSize.inputFieldHeight)
    ) {
        CountryCodeButton(
            onClick = onCountryCodeButtonClick,
            countryCode = countryCode.code,
            flagPainter = painterResource(countryCode.flagResId),
            textStyle = textStyle
        )
        Spacer(modifier = Modifier.width(DpSpSize.paddingSmall))

        val customTextSelectionColors = TextSelectionColors(
            handleColor = CursorThumbColor,
            backgroundColor = CursorThumbColor.copy(alpha = 0.5f)
        )
        //can be placed at the application level
        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            TextField(
                value = phoneNumber,
                onValueChange = onPhoneNumberChange,
                singleLine = true,
                visualTransformation = PhoneNumberTransformation(countryCode),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                placeholder = {
                    Text(
                        text = stringResource(R.string.mobile_number),
                        style = textStyle,
                        color = HintTextColor
                    )
                },
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = PrimaryTextColor,
                    unfocusedTextColor = HintTextColor,
                    focusedContainerColor = InputBackgroundFocused,
                    unfocusedContainerColor = InputBackgroundUnfocused,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = PrimaryButtonContainerColor
                ),
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
    }
}