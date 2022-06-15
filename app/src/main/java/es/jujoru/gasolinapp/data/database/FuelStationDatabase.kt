package es.jujoru.gasolinapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

    @Database(
        entities = [],
        version = 1,
        exportSchema = false
    )
    abstract class FuelStationDatabase : RoomDatabase() {
        abstract val fuelStationDao: FuelStationDAO
    }

