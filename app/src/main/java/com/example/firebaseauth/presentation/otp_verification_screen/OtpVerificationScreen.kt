package com.example.firebaseauth.presentation.otp_verification_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firebaseauth.R
import com.example.firebaseauth.presentation.otp_verification_screen.components.OtpInputField
import com.example.firebaseauth.presentation.otp_verification_screen.components.formatResendText
import com.example.firebaseauth.presentation.util.components.BackNavigationRow
import com.example.firebaseauth.presentation.util.components.HeaderWithDescription
import com.example.firebaseauth.ui.theme.ClickableTextColor
import com.example.firebaseauth.ui.theme.DpSpSize.screenHorizontalPadding

@Composable
fun OtpVerificationScreen(
    onBack: () -> Unit,
    otpVerificationViewModel: OtpVerificationViewModel = hiltViewModel(),
    verificationTimerViewModel: VerificationTimerViewModel = hiltViewModel()
) {
    val verificationState by verificationTimerViewModel.verificationTimerState.collectAsState()
    val resendText = formatResendText(verificationState.timeLeft)

    Column(modifier = Modifier.fillMaxSize()) {
        BackNavigationRow(onBack = onBack)

        HeaderWithDescription(
            headerText = stringResource(R.string.code),
            descriptionText = stringResource(R.string.enter_code),
            modifier = Modifier.padding(horizontal = screenHorizontalPadding)
        )

        Spacer(modifier = Modifier.height(56.dp))

        OtpInputField(
            otpValue = otpVerificationViewModel.verificationCode,
            onValueChange = {
                otpVerificationViewModel.updateVerificationCode(it)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = resendText,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
            color = ClickableTextColor,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    if (verificationState.canResend) {
                        verificationTimerViewModel.startCountdown()
                    }
                }
        )
    }
}

