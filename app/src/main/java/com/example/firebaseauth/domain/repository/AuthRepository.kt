package com.example.firebaseauth.domain.repository

import com.example.firebaseauth.domain.model.NetworkResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun signInWithPhoneAuthCredential(cred: PhoneAuthCredential): Flow<NetworkResult<FirebaseUser>>
}

