package com.hjsaraviad.core.database.di

import com.hjsaraviad.core.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    factory<AppDatabase> {
        AppDatabase.getDatabase(androidApplication())
    }
    single {
        val appDatabase: AppDatabase = get()
        appDatabase.commentDao()
    }


}