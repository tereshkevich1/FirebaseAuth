package com.example.firebaseauth.presentation.login_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.firebaseauth.R
import com.example.firebaseauth.ui.theme.DpSpSize
import com.example.firebaseauth.ui.theme.InputBackgroundUnfocused
import com.example.firebaseauth.ui.theme.PrimaryTextColor

@Composable
fun CountryCodeButton(
    onClick: () -> Unit,
    countryCode: String,
    flagPainter: Painter,
    textStyle: TextStyle,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxHeight(),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = InputBackgroundUnfocused
        ),
        contentPadding = PaddingValues(
            vertical = DpSpSize.buttonVerticalPadding,
            horizontal = DpSpSize.buttonHorizontalPadding
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = flagPainter,
                contentDescription = stringResource(R.string.flag),
                modifier = Modifier
                    .size(DpSpSize.flagIconSize)
                    .clip(CircleShape),
                contentScale = ContentScale.FillHeight,
            )
            Spacer(modifier = Modifier.width(DpSpSize.paddingSmall))
            Text(
                text = countryCode,
                style = textStyle,
                color = PrimaryTextColor
            )
        }
    }
}