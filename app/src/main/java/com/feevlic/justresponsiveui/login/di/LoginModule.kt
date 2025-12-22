package com.feevlic.justresponsiveui.login.di

import com.feevlic.justresponsiveui.login.domain.usecase.SaveEmailUseCase
import com.feevlic.justresponsiveui.login.domain.usecase.SavePasswordUseCase
import com.feevlic.justresponsiveui.login.domain.usecase.ValidateEmailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Provides
    @Singleton
    fun provideSaveEmailUseCase(): SaveEmailUseCase = SaveEmailUseCase()

    @Provides
    @Singleton
    fun provideSavePasswordUseCase(): SavePasswordUseCase = SavePasswordUseCase()

    @Provides
    @Singleton
    fun provideValidateEmailUsecase(): ValidateEmailUseCase = ValidateEmailUseCase()
}