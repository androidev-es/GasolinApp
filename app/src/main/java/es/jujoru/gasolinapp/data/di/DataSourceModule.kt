package es.jujoru.gasolinapp.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.jujoru.gasolinapp.data.api.APIDataSource
import es.jujoru.gasolinapp.data.database.RoomDataSource
import es.jujoru.gasolinapp.data.preference.DataStorePreferencesDataSoruce
import es.jujoru.gasolinapp.data.sources.LocalDataSource
import es.jujoru.gasolinapp.data.sources.PreferenceDataSource
import es.jujoru.gasolinapp.data.sources.RemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun provideLocalDataSource(roomDataSource: RoomDataSource): LocalDataSource

    @Binds
    abstract fun provideRemoteDataSource(apiDataSource: APIDataSource): RemoteDataSource

    @Binds
    abstract fun providePreferenceDataSource(dataStoreDataSource: DataStorePreferencesDataSoruce): PreferenceDataSource
}