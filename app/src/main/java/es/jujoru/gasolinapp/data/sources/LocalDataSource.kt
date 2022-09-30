package es.jujoru.gasolinapp.data.sources

import es.jujoru.gasolinapp.data.database.entities.FuelStationEntity
import es.jujoru.gasolinapp.data.database.entities.LocationEntity
import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.domain.model.Location

interface LocalDataSource {

    suspend fun getFuelStations(): List<FuelStation>
    suspend fun getFuelStationsByProvince(idProvince: Int): List<FuelStation>
    suspend fun getFuelStationsByMunicipality(idMunicipality: Int): List<FuelStation>
    suspend fun insertFuelStation(listFuelStation: List<FuelStation>)
    suspend fun deleteFuelStation()
    suspend fun getLocations(): List<Location>
    suspend fun insertLocations(listLocation: List<Location>)
    suspend fun deleteLocations()

}