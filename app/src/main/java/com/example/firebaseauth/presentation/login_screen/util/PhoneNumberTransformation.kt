package com.example.firebaseauth.presentation.login_screen.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import com.example.firebaseauth.presentation.login_screen.util.number_formatters.FormatBY
import com.example.firebaseauth.presentation.login_screen.util.number_formatters.FormatRU
import com.example.firebaseauth.presentation.login_screen.util.number_formatters.FormatUS
import com.example.firebaseauth.presentation.login_screen.util.number_formatters.NumberFormat

class PhoneNumberTransformation(countryCode: CountryCode) : VisualTransformation {
    private val formatter: NumberFormat = when (countryCode) {
        CountryCode.US -> FormatUS()
        CountryCode.RU -> FormatRU()
        CountryCode.BY -> FormatBY()
    }

    override fun filter(text: AnnotatedString): TransformedText {
        val out = formatter.toFormat(text.text)
        return TransformedText(AnnotatedString(out), createOffsetMapping(out, text.text))
    }

    private fun createOffsetMapping(transformed: String, original: String): OffsetMapping {
        val digitPositions = mutableListOf<Int>()
        for (i in transformed.indices) {
            if (transformed[i].isDigit()) {
                digitPositions.add(i)
            }
        }

        return object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 0) return 0
                if (offset > digitPositions.size) return transformed.length
                return digitPositions[offset - 1] + 1
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 0) return 0
                return digitPositions.indexOfFirst { it >= offset }.takeIf { it >= 0 }
                    ?: original.length
            }
        }
    }
}

