package es.jujoru.gasolinapp.data.database

import es.jujoru.gasolinapp.core.toDomain
import es.jujoru.gasolinapp.core.toLocal
import es.jujoru.gasolinapp.data.sources.LocalDataSource
import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.domain.model.Location
import javax.inject.Inject

class RoomDataSource @Inject constructor(
    private val fuelStationDAO: FuelStationDAO,
    private val locationDAO: LocationDAO
    ): LocalDataSource {
    override suspend fun getFuelStations(): List<FuelStation> =
        fuelStationDAO.getFuelStations().map { it.toDomain }

    override suspend fun getFuelStationsByProvince(idProvince: Int) : List<FuelStation> =
        fuelStationDAO.getFuelStationsByProvince(idProvince).map { it.toDomain }

    override suspend fun getFuelStationsByMunicipality(idMunicipality: Int) : List<FuelStation> =
        fuelStationDAO.getFuelStationsByMunicipality(idMunicipality).map { it.toDomain }

    override suspend fun insertFuelStation(listFuelStation: List<FuelStation>) {
       fuelStationDAO.insertFuelStation(listFuelStation.map { it.toLocal })
    }

    override suspend fun deleteFuelStation() {

    }

    override suspend fun getLocations(): List<Location> =
       locationDAO.getLocations().map { it.toDomain }


    override suspend fun insertLocations(listLocation: List<Location>) {
        locationDAO.insertLocations(listLocation.map { it.toLocal })
    }

    override suspend fun deleteLocations() {

    }
}