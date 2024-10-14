package com.hjsaraviad.core.data.comments.di

import com.hjsaraviad.core.data.comments.datasources.CommentsRemoteDataSource
import com.hjsaraviad.core.data.comments.datasources.CommentsRemoteDataSourceImpl
import com.hjsaraviad.core.data.comments.remote.api.CommentsApi
import com.hjsaraviad.core.data.comments.repositories.CommentsRepository
import com.hjsaraviad.core.data.comments.repositories.CommentsRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val dataCommentsModule = module {
    single<CommentsApi> {
        val retrofit = get<Retrofit>()
        retrofit.create(CommentsApi::class.java)
    }
    single<CommentsRemoteDataSource> { CommentsRemoteDataSourceImpl(get()) }
    single<CommentsRepository> {
        CommentsRepositoryImpl(
            get(),
            get()
        )
    }

}