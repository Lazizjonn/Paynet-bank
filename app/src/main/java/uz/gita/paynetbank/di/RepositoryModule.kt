package uz.gita.paynetbank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.paynetbank.domain.repositories.AppRepository
import uz.gita.paynetbank.domain.repositories.AuthRepository
import uz.gita.mobilebanking.domain.repositories.CardRepository
import uz.gita.mobilebanking.domain.repositories.impl.CardRepositoryImpl
import uz.gita.paynetbank.domain.repositories.impl.AppRepositoryImpl
import uz.gita.paynetbank.domain.repositories.impl.AuthRepositoryImpl
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface RepositoryModule {

    @[Binds Singleton]
    fun getAppRepository(impl: AppRepositoryImpl): AppRepository

    @[Binds Singleton]
    fun getAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @[Binds Singleton]
    fun getCardRepository(impl: CardRepositoryImpl): CardRepository

}