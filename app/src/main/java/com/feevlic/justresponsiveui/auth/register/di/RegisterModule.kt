package com.feevlic.justresponsiveui.auth.register.di

import com.feevlic.justresponsiveui.auth.register.domain.SaveNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RegisterModule {

    @Provides
    @Singleton
    fun provideSaveNameUseCase(): SaveNameUseCase = SaveNameUseCase()
}