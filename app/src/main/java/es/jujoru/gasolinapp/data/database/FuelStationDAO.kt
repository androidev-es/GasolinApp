package es.jujoru.gasolinapp.data.database

import androidx.room.*
import es.jujoru.gasolinapp.data.database.entities.FuelStationEntity
import es.jujoru.gasolinapp.data.database.entities.LocationEntity

@Dao
interface FuelStationDAO {

    @Query("SELECT *  FROM fuelStations")
    suspend fun getFuelStations(): List<FuelStationEntity>

    @Query("SELECT *  FROM fuelStations WHERE idProvince = :idProvince")
    suspend fun getFuelStationsByProvince(idProvince: Int): List<FuelStationEntity>

    @Query("SELECT *  FROM fuelStations WHERE idMunicipality = :idMunicipality")
    suspend fun getFuelStationsByMunicipality(idMunicipality: Int): List<FuelStationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFuelStation(locations: List<FuelStationEntity>)

    /*@Delete
    suspend fun deleteFuelStation()*/
}