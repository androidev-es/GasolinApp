package es.jujoru.gasolinapp.data.api

import es.jujoru.gasolinapp.data.api.responses.DataFuelStationsAPI
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/")
    suspend fun getDataFuelStations():  Response<DataFuelStationsAPI>
}