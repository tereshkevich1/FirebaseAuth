package com.example.firebaseauth.presentation.country_code_selection_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.firebaseauth.R
import com.example.firebaseauth.ui.theme.DpSpSize
import com.example.firebaseauth.ui.theme.HintTextColor
import com.example.firebaseauth.ui.theme.PrimaryButtonContainerColor
import com.example.firebaseauth.ui.theme.PrimaryTextColor

@Composable
fun CountryItem(
    onClick: () -> Unit,
    name: String,
    code: String,
    flagPainter: Painter,
    selected: Boolean
) {
    val textStyle = MaterialTheme.typography.bodyLarge

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(DpSpSize.countryItemHeight)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick() }
            .padding(DpSpSize.countryItemPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = flagPainter,
            contentDescription = stringResource(R.string.flag),
            modifier = Modifier
                .size(DpSpSize.largeFlagSize)
                .clip(CircleShape),
            contentScale = ContentScale.FillHeight,
        )

        Spacer(modifier = Modifier.width(DpSpSize.countryItemSpacerWidth))

        Column {
            Text(
                text = name,
                style = textStyle.copy(fontWeight = FontWeight.Bold),
                color = PrimaryTextColor
            )
            Text(
                text = code,
                style = textStyle,
                color = HintTextColor
            )
        }

        if (selected) {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.tick_circle),
                tint = PrimaryButtonContainerColor,
                contentDescription = null
            )
        }
    }
}