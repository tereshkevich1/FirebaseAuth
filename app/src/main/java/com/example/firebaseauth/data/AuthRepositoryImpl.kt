package com.example.firebaseauth.data

import android.util.Log

import com.example.firebaseauth.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) : AuthRepository {
    override suspend fun signInWithPhoneAuthCredential(cred: PhoneAuthCredential): NetworkResult<FirebaseUser> {
        return try {
            val result = auth.signInWithCredential(cred).await()
            val user = result.user
            if (user != null) {
                Log.d(TAG, "signInWithCredential:success $user")
                NetworkResult.Success(user)
            } else {
                Log.w(TAG, "signInWithCredential:no user found")
                throw FirebaseAuthException("no_user_found", "no_user_found")
            }
        } catch (e: Exception) {
            Log.w(TAG, "signInWithCredential:failure", e)
            NetworkResult.Error(e)
        }
    }

    companion object {
        const val TAG = "signInWithPhoneAuthCredential"
    }
}

sealed class NetworkResult<T : Any> {
    class Success<T : Any>(val data: T) : NetworkResult<T>()
    class Error<T : Any>(val e: Exception) : NetworkResult<T>()
}