package com.esaudev.composegarden.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.intellij.lang.annotations.JdkConstants

@Composable
fun TextInputFieldWithValidation(
    modifier: Modifier,
    userNameProvider: () -> String,
    hasErrorProvider: () -> Boolean,
    onUserNameChange: (String) -> Unit,
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userNameProvider(),
            onValueChange = { onUserNameChange(it) }
        )

        AnimatedVisibility(visible = hasErrorProvider()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Username not available. Please choose a different one.",
                color = Color.Red
            )
        }
    }

}