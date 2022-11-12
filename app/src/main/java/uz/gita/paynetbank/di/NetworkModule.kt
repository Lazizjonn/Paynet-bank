package uz.gita.paynetbank.di

import android.content.Context
import android.content.Intent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.paynetbank.BuildConfig.BASE_URL
import uz.gita.paynetbank.MainActivity
import uz.gita.paynetbank.data.source.local.sharedPref.MySharedPref
import uz.gita.paynetbank.data.source.remote.api.auth.AuthApi
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class NetworkModule {

    @[Provides Singleton]
    fun httpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @[Provides Singleton]
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @[Provides Singleton]
    fun getOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authenticator: Authenticator
    ): OkHttpClient = OkHttpClient.Builder()
        .authenticator(authenticator)
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @[Provides Singleton]
    fun authenticator(httpLoggingInterceptor: HttpLoggingInterceptor, @ApplicationContext context: Context, sharedPref: MySharedPref): Authenticator = object : Authenticator {
        override fun authenticate(route: Route?, response: Response): Request? {

            val client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
            val ret = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            val api  = ret.create(AuthApi::class.java)
            val refreshResponse = api.refreshToken(sharedPref.refreshToken).execute()

            if (response.code == 401) {
                context.startActivity(Intent(context, MainActivity::class.java).apply {
                    sharedPref.clear()
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                })
                return null
            } else {
                val refreshData = refreshResponse.body() ?: return null
                sharedPref.accessToken = refreshData.accessToken
                sharedPref.refreshToken = refreshData.refreshToken
                return response.request
                    .newBuilder()
                    .removeHeader("Authorization")
                    .addHeader("Authorization", "Bearer ${sharedPref.accessToken}")
                    .build()
            }
        }

    }
}