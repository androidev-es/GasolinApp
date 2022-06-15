package es.jujoru.gasolinapp.data.di

import android.content.Context
import androidx.room.Room
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import es.jujoru.gasolinapp.data.database.FuelStationDatabase
import es.jujoru.gasolinapp.data.database.FuelStationDAO
import javax.inject.Singleton

object DataBaseModule {
    @Singleton
    @Provides
    fun databaseProvider(@ApplicationContext appContext: Context): FuelStationDatabase =
        Room.databaseBuilder(
            appContext,
            FuelStationDatabase::class.java,
            "fuelStationDB"
        ).build()

    @Singleton
    @Provides
    fun fuelStationDaoProvider(fuelStationDatabase: FuelStationDatabase): FuelStationDAO = fuelStationDatabase.fuelStationDao

}