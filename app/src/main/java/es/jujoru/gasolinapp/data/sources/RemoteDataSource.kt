package es.jujoru.gasolinapp.data.sources

interface RemoteDataSource {
    suspend fun getFuelStations()
}