package com.example.firebaseauth.presentation.otp_verification_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebaseauth.presentation.otp_verification_screen.util.VerificationState
import com.example.firebaseauth.presentation.util.PhoneNumberConstants.VERIFICATION_TIMER_DURATION
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerificationTimerViewModel @Inject constructor() : ViewModel() {
    private val _verificationTimerState = MutableStateFlow(
        VerificationState(
            timeLeft = VERIFICATION_TIMER_DURATION,
            canResend = true
        )
    )
    val verificationTimerState = _verificationTimerState.asStateFlow()

    fun startCountdown() {
        viewModelScope.launch {
            _verificationTimerState.update { it.copy(canResend = false) }
            while (_verificationTimerState.value.timeLeft > 0) {
                _verificationTimerState.update { it.copy(timeLeft = it.timeLeft - 1) }
                delay(1000)
            }
            _verificationTimerState.update {
                it.copy(
                    timeLeft = VERIFICATION_TIMER_DURATION,
                    canResend = true
                )
            }
        }
    }
}

