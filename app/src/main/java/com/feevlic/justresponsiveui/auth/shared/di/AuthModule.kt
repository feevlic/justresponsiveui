package com.feevlic.justresponsiveui.auth.shared.di

import com.feevlic.justresponsiveui.auth.shared.domain.usecase.ValidateEmailUseCase
import com.feevlic.justresponsiveui.auth.shared.domain.usecase.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideValidateEmailUseCase(): ValidateEmailUseCase = ValidateEmailUseCase()

    @Provides
    @Singleton
    fun provideValidatePasswordUseCase(): ValidatePasswordUseCase = ValidatePasswordUseCase()

}