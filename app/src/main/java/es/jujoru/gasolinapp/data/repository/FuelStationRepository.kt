package es.jujoru.gasolinapp.data.repository

import arrow.core.Either
import es.jujoru.gasolinapp.data.sources.LocalDataSource
import es.jujoru.gasolinapp.data.sources.RemoteDataSource
import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.domain.model.Location
import es.jujoru.gasolinapp.domain.model.Error

class FuelStationRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getFuelStation(): List<FuelStation> {
           return localDataSource.getFuelStations().ifEmpty {
            val listFuelStations = remoteDataSource.getFuelStations()
            localDataSource.insertFuelStation(listFuelStations)
            val listLocation = mutableListOf<Location>()
            listFuelStations.forEach {
                listLocation.add(it.location)
            }
            localDataSource.insertLocations(listLocation)
             listFuelStations
        }
    }
    suspend fun updateLocalLocation() {
        val fuelStationLocal = localDataSource.getFuelStations()
        val listLocation = mutableListOf<Location>()
        fuelStationLocal.forEach {
            listLocation.add(it.location)
        }
        localDataSource.insertLocations(listLocation)
    }
    suspend fun getLocalFuelStation(): List<FuelStation> =
        localDataSource.getFuelStations()

    suspend fun getLocalLocations(): List<Location> =
        localDataSource.getLocations()

    suspend fun inserLocalLocations(locations: List<Location>) =
        localDataSource.insertLocations(locations)

    suspend fun insertLocalFuelStation(fuelStation: List<FuelStation>) =
        localDataSource.insertFuelStation(fuelStation)

    suspend fun isEmptyLocalFuelStation(): Boolean =
        localDataSource.getFuelStations().isEmpty()

    suspend fun isEmptyLocalLocation(): Boolean =
        localDataSource.getLocations().isEmpty()

}