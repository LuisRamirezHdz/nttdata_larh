package com.example.helloworld.core

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        //To show Log
        val appLayerLogger: HttpLoggingInterceptor.Logger = object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("RestService: ", message)
            }

        }
        val httpLoggingInterceptor = HttpLoggingInterceptor(appLayerLogger)
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient  = OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()


        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .client(client) // Comment in production
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
    }

}