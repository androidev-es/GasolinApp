package es.jujoru.gasolinapp.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.jujoru.gasolinapp.core.Constants.DATABASE_NAME
import es.jujoru.gasolinapp.data.database.FuelStationDatabase
import es.jujoru.gasolinapp.data.database.FuelStationDAO
import es.jujoru.gasolinapp.data.database.LocationDAO
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun databaseProvider(@ApplicationContext appContext: Context): FuelStationDatabase =
        Room.databaseBuilder(
            appContext,
            FuelStationDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun fuelStationDaoProvider(fuelStationDatabase: FuelStationDatabase): FuelStationDAO = fuelStationDatabase.fuelStationDao

    @Singleton
    @Provides
    fun locationDaoProvider(fuelStationDatabase: FuelStationDatabase): LocationDAO = fuelStationDatabase.locationDAO

}