package es.jujoru.gasolinapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import es.jujoru.gasolinapp.data.database.entities.FuelStationEntity
import es.jujoru.gasolinapp.data.database.entities.LocationEntity

@Database(
        entities = [
            FuelStationEntity::class,
            LocationEntity::class ],
        version = 1,
        exportSchema = false
    )
    abstract class FuelStationDatabase : RoomDatabase() {
        abstract val fuelStationDao: FuelStationDAO
        abstract val locationDAO: LocationDAO
    }

