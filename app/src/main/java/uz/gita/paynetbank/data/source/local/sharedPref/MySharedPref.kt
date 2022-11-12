package uz.gita.paynetbank.data.source.local.sharedPref

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.gita.paynetbank.data.source.local.model.AppLanguage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MySharedPref @Inject constructor(@ApplicationContext context: Context) {

    private val pref = context.getSharedPreferences("MOBILE_BANKING", Context.MODE_PRIVATE)

    fun clear() {
        accessToken = ""
        refreshToken = ""
    }

    var language: String
        get() = pref.getString("LANGUAGE", AppLanguage.UZBEK.value)!!
        set(value) = pref!!.edit().putString("LANGUAGE", value).apply()

    var isFirstTime: Boolean
        get() = pref.getBoolean("IS_FIRST_TIME", true)
        set(value) = pref!!.edit().putBoolean("IS_FIRST_TIME", value).apply()

    var accessToken: String
        get() = pref.getString("ACCESS_TOKEN", "")!!
        set(value) = pref.edit().putString("ACCESS_TOKEN", value).apply()

    var refreshToken: String
        get() = pref.getString("REFRESH_TOKEN", "")!!
        set(value) = pref.edit().putString("REFRESH_TOKEN", value).apply()

}