package com.example.firebaseauth.presentation.util.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.firebaseauth.R
import com.example.firebaseauth.ui.theme.DpSpSize

@Composable
fun BackNavigationRow(onBack: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = DpSpSize.navRowPaddingStart,
                top = DpSpSize.navRowPaddingTop,
                bottom = DpSpSize.navRowPaddingBottom,
            )
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier.size(DpSpSize.navBackButtonSize)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = stringResource(R.string.arrow_left),
                modifier = Modifier.size(DpSpSize.arrowBackIconSize)
            )
        }
    }
}