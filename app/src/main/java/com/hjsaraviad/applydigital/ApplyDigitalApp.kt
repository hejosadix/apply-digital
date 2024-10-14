package com.hjsaraviad.applydigital

import android.app.Application
import com.hjsaraviad.core.data.comments.di.dataCommentsModule
import com.hjsaraviad.core.database.di.databaseModule
import com.hjsaraviad.core.di.coreModule
import com.hjsaraviad.core.network.di.networkModule
import com.hjsaraviad.features.comments.di.featuresCommentsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplyDigitalApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplyDigitalApp)
            modules(
                coreModule,
                dataCommentsModule,
                networkModule,
                featuresCommentsModule,
                databaseModule
            )
        }
    }
}