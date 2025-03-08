package com.example.firebaseauth.domain.use_case

import com.example.firebaseauth.data.NetworkResult
import com.example.firebaseauth.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import javax.inject.Inject

class SignInWithPhoneCredentialUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(credential: PhoneAuthCredential): NetworkResult<FirebaseUser> {
        return authRepository.signInWithPhoneAuthCredential(credential)
    }
}