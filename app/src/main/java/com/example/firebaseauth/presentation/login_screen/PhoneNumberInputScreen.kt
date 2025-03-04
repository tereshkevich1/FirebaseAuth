package com.example.firebaseauth.presentation.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebaseauth.R
import com.example.firebaseauth.presentation.login_screen.components.PhoneNumberInputRow
import com.example.firebaseauth.presentation.login_screen.components.PrimaryButton
import com.example.firebaseauth.ui.theme.DpSpSize
import com.example.firebaseauth.ui.theme.FirebaseAuthTheme
import com.example.firebaseauth.ui.theme.HintTextColor
import com.example.firebaseauth.ui.theme.PrimaryTextColor
import com.example.firebaseauth.ui.theme.SurfaceBackground

@Composable
fun PhoneNumberInputScreen() {
    //temporarily
    val viewModel: PhoneNumberViewModel = remember { PhoneNumberViewModel() }

    val horizontalPadding = DpSpSize.screenHorizontalPadding
    val topPadding = DpSpSize.screenTopPadding

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceBackground)
            .padding(
                start = horizontalPadding,
                end = horizontalPadding,
                top = topPadding
            )
    ) {
        Text(
            text = stringResource(R.string.lets_get_started),
            style = MaterialTheme.typography.headlineMedium,
            color = PrimaryTextColor
        )
        Spacer(modifier = Modifier.height(DpSpSize.paddingSmall))
        Text(
            text = stringResource(R.string.enter_phone_number_message),
            style = MaterialTheme.typography.bodyLarge,
            color = HintTextColor
        )

        Spacer(modifier = Modifier.height(DpSpSize.paddingLarge))

        PhoneNumberInputRow(
            countryCode = viewModel.countryCode,
            phoneNumber = viewModel.phoneNumber,
            onPhoneNumberChange = { viewModel.updatePhoneNumber(it) },
            onCountryCodeButtonClick = {},
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(DpSpSize.paddingMedium))

        PrimaryButton(
            onClick = {},
            text = stringResource(R.string.continue_text)
        )
    }
}

@Composable
@Preview
fun PHNIPreview() {
    FirebaseAuthTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(SurfaceBackground.copy(alpha = 0.5f))
                    .padding(it)
            ) {
                PhoneNumberInputScreen()
            }
        }
    }
}