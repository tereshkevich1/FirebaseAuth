package com.example.firebaseauth.presentation.otp_verification_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.firebaseauth.presentation.util.PhoneNumberConstants.VERIFICATION_CODE_LENGTH
import com.example.firebaseauth.ui.theme.DpSpSize
import com.example.firebaseauth.ui.theme.InputBackgroundFocused
import com.example.firebaseauth.ui.theme.InputBackgroundUnfocused
import com.example.firebaseauth.ui.theme.PrimaryTextColor

@Composable
fun OtpInputField(
    otpValue: String,
    onValueChange: (String) -> Unit,
    otpCodeLength: Int = VERIFICATION_CODE_LENGTH,
    modifier: Modifier
) {
    BasicTextField(
        value = otpValue,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        ),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(otpCodeLength) { index ->
                    val char = when {
                        index >= otpValue.length -> ""
                        else -> otpValue[index].toString()
                    }
                    val isFocused = otpValue.length == index

                    val backgroundColor = if (isFocused) InputBackgroundFocused
                    else InputBackgroundUnfocused

                    Text(
                        text = char,
                        color = PrimaryTextColor,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .width(36.dp)
                            .height(44.dp)
                            .clip(MaterialTheme.shapes.medium)
                            .background(backgroundColor)
                            .wrapContentSize(Alignment.Center)
                    )
                    if (index + 1 != otpCodeLength) {
                        Spacer(modifier = Modifier.width(DpSpSize.paddingSmall))
                    }
                }
            }
        },
        modifier = modifier
    )
}