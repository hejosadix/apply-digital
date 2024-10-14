package com.hjsaraviad.features.comments.di

import com.hjsaraviad.features.comments.ui.CommentsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featuresCommentsModule = module {
    viewModel { CommentsViewModel(get()) }
}