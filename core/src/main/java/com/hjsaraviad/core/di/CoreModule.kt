package com.hjsaraviad.core.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module


val coreModule = module {
    single {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

}