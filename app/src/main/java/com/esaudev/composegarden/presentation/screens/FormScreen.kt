package com.esaudev.composegarden.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.esaudev.composegarden.presentation.components.TextInputFieldWithValidation

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun FormScreen(
    viewModel: FormViewModel = hiltViewModel()
) {

    val userNameHasError by viewModel.userNameHasError.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextInputFieldWithValidation(
            modifier = Modifier.padding(10.dp),
            userName = viewModel.username,
            userNameHasError = userNameHasError,
            onUserNameChange = {
                viewModel.updateUsername(input = it)
            }
        )
    }
}