package uz.gita.mobilebanking.domain.usecase.impl

import uz.gita.mobilebanking.domain.repositories.CardRepository
import uz.gita.mobilebanking.domain.usecase.CardUseCase
import javax.inject.Inject

class CardUseCaseImpl @Inject constructor(
    private val repository: CardRepository
) : CardUseCase {

}