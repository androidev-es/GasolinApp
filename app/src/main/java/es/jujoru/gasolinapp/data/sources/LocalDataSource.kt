package es.jujoru.gasolinapp.data.sources

interface LocalDataSource {
    //TODO: SET PARAMS TO FILTER
    suspend fun getFuelStationByLocation()
    suspend fun getLocations()
}