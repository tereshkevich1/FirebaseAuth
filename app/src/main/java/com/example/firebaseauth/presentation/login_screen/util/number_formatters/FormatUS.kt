package com.example.firebaseauth.presentation.login_screen.util.number_formatters

class FormatUS : NumberFormat {
    override fun toFormat(text: String): String {
        val sb = StringBuilder()
        for (i in text.indices) {
            when (i) {
                0 -> sb.append("(").append(text[i])
                3 -> sb.append(") ").append(text[i])
                6 -> sb.append("-").append(text[i])
                else -> sb.append(text[i])
            }
        }
        return sb.toString()
    }
}