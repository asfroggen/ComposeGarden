package com.esaudev.composegarden.domain.usecase

import javax.inject.Inject

class IsUserNameCorrectUseCase @Inject constructor(

) {

    operator fun invoke(userName: String): Boolean {
        return userName.contains('a')
    }
}