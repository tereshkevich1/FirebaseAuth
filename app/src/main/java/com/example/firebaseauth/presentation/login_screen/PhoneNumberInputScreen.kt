package com.example.firebaseauth.presentation.login_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebaseauth.presentation.login_screen.components.PhoneNumberInputRow
import com.example.firebaseauth.ui.theme.DpSpSize
import com.example.firebaseauth.ui.theme.FirebaseAuthTheme

@Composable
fun PhoneNumberInputScreen() {
    //temporarily
    val viewModel: PhoneNumberViewModel = remember { PhoneNumberViewModel() }

    val horizontalPadding = DpSpSize.screenHorizontalPadding
    val topPadding = DpSpSize.screenTopPadding

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = horizontalPadding,
                end = horizontalPadding,
                top = topPadding
            )
    ) {
        Text(
            text = " ",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(DpSpSize.paddingSmall))
        Text(
            text = " ",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(DpSpSize.paddingLarge))

        PhoneNumberInputRow(
            code = viewModel.countryCode,
            phoneNumber = viewModel.phoneNumber,
            onPhoneNumberChange = { viewModel.updatePhoneNumber(it) },
            modifier = Modifier
        )
    }
}

@Composable
@Preview
fun PHNIPreview() {
    FirebaseAuthTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            PhoneNumberInputScreen()
        }
    }
}