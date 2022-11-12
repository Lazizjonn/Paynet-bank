package uz.gita.paynetbank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.paynetbank.domain.usecase.AppUseCase
import uz.gita.mobilebanking.domain.usecase.AuthUseCase
import uz.gita.mobilebanking.domain.usecase.CardUseCase
import uz.gita.mobilebanking.domain.usecase.impl.AppUseCaseImpl
import uz.gita.mobilebanking.domain.usecase.impl.AuthUseCaseImpl
import uz.gita.mobilebanking.domain.usecase.impl.CardUseCaseImpl
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface UseCaseModule {

    @[Binds Singleton]
    fun getAppUseCase(impl: AppUseCaseImpl): AppUseCase

    @[Binds Singleton]
    fun getAuthUseCase(impl: AuthUseCaseImpl): AuthUseCase

    @[Binds Singleton]
    fun getCardUseCase(impl: CardUseCaseImpl): CardUseCase
}