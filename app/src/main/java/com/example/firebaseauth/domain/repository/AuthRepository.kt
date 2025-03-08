package com.example.firebaseauth.domain.repository

import com.example.firebaseauth.data.NetworkResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential

interface AuthRepository {
   suspend fun signInWithPhoneAuthCredential(cred: PhoneAuthCredential): NetworkResult<FirebaseUser>
}

