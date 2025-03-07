package com.example.firebaseauth.data

import android.util.Log
import com.example.firebaseauth.domain.model.NetworkResult
import com.example.firebaseauth.domain.repository.AuthRepository
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) : AuthRepository {
    override fun signInWithPhoneAuthCredential(cred: PhoneAuthCredential): Flow<NetworkResult<FirebaseUser>> {
        return flow {
            emit(NetworkResult.Loading())
            try {
                val result = auth.signInWithCredential(cred).await()
                val user = result.user
                if (user != null) {
                    Log.d(TAG, "signInWithCredential:success")
                    emit(NetworkResult.Success(user))
                } else {
                    Log.w(TAG, "signInWithCredential:no user found")
                    emit(NetworkResult.Error("No user found after successful sign-in"))
                }
            } catch (e: Exception) {
                Log.w(TAG, "signInWithCredential:failure", e)
                val errorMessage = when (e) {
                    is FirebaseAuthInvalidCredentialsException -> "Invalid verification code"
                    is FirebaseTooManyRequestsException -> "Too many requests. Please try again later"
                    is FirebaseAuthMissingActivityForRecaptchaException -> "Activity missing for reCAPTCHA verification"
                    else -> e.message ?: "Unknown error occurred"
                }
                emit(NetworkResult.Error(errorMessage))
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object {
        const val TAG = "signInWithPhoneAuthCredential"
    }
}