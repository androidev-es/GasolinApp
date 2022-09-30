package es.jujoru.gasolinapp.data.database

import androidx.room.*
import es.jujoru.gasolinapp.data.database.entities.LocationEntity

@Dao
interface LocationDAO {

    @Query("SELECT *  FROM locations")
    suspend fun getLocations(): List<LocationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations(locations: List<LocationEntity>)

   /* @Delete
    suspend fun deleteLocations() */
}