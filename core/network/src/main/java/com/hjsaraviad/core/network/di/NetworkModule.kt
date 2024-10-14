package com.hjsaraviad.core.network.di

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BACKEND_URL: String = "https://hn.algolia.com/api/v1/"
val networkModule = module {

    single { OkHttpClient.Builder().build() }
    single { retrofit(get(), get()) }
}


private fun retrofit(client: OkHttpClient, moshi: Moshi) = Retrofit.Builder()
    .baseUrl(BACKEND_URL)
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()