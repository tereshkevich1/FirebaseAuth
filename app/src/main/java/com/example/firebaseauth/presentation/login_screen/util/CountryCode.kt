package com.example.firebaseauth.presentation.login_screen.util

import androidx.annotation.DrawableRes
import com.example.firebaseauth.R

enum class CountryCode(
    val code: String,
    val phoneNumberLength: Int,
    @DrawableRes val flagResId: Int
) {
    BY(code = "+375", phoneNumberLength = 9, flagResId = R.drawable.by_flag),
    US(code = "+1", phoneNumberLength = 10, flagResId = R.drawable.us_flag),
    RU(code = "+7", phoneNumberLength = 10, flagResId = R.drawable.ru_flag)
}