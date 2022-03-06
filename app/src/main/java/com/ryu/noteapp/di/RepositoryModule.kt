package com.ryu.noteapp.di

import com.ryu.noteapp.network.QiitaService
import com.ryu.noteapp.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideHomeRepository(service: QiitaService) = HomeRepository(service)
}
