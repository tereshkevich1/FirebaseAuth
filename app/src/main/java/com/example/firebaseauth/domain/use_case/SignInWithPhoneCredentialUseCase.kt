package com.example.firebaseauth.domain.use_case

import com.example.firebaseauth.domain.repository.AuthRepository
import com.example.firebaseauth.domain.model.NetworkResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignInWithPhoneCredentialUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(credential: PhoneAuthCredential): Flow<NetworkResult<FirebaseUser>> {
        return authRepository.signInWithPhoneAuthCredential(credential)
    }
}