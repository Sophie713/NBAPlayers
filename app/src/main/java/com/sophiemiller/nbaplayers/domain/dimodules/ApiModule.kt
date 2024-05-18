package com.sophiemiller.nbaplayers.domain.dimodules

import com.sophiemiller.nbaplayers.domain.apiInterfaces.PlayersApiService
import com.sophiemiller.nbaplayers.domain.repositories.PlayersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providePlayersApiService(retrofit: Retrofit): PlayersApiService {
        return retrofit.create(PlayersApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePlayersRepository(playersApiService: PlayersApiService): PlayersRepository {
        return PlayersRepository(playersApiService)
    }
}