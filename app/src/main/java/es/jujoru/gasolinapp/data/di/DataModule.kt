package es.jujoru.gasolinapp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.jujoru.gasolinapp.data.repository.FuelStationRepository
import es.jujoru.gasolinapp.data.repository.PreferencesRepository
import es.jujoru.gasolinapp.data.sources.LocalDataSource
import es.jujoru.gasolinapp.data.sources.PreferenceDataSource
import es.jujoru.gasolinapp.data.sources.RemoteDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideFuelStationRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = FuelStationRepository(localDataSource, remoteDataSource)

    @Singleton
    @Provides
    fun provideUserPreferencesRepository(
        preferenceDataSource: PreferenceDataSource
    ) = PreferencesRepository(preferenceDataSource)
}