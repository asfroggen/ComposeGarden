package com.esaudev.composegarden.presentation.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esaudev.composegarden.domain.usecase.IsUserNameCorrectUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val isUserNameCorrectUseCase: IsUserNameCorrectUseCase
): ViewModel() {
    var username by mutableStateOf("")
        private set

    @OptIn(ExperimentalCoroutinesApi::class)
    val userNameHasError: StateFlow<Boolean> =
        snapshotFlow { username }
            .mapLatest { isUserNameCorrectUseCase(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = false
            )

    fun updateUsername(input: String) {
        username = input
    }
}