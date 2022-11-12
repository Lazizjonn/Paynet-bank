package uz.gita.paynetbank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.gita.paynetbank.data.source.remote.api.auth.AuthApi
import javax.inject.Singleton


@[Module InstallIn(SingletonComponent::class)]
class ApiModule {

    @[Singleton Provides]
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)
}