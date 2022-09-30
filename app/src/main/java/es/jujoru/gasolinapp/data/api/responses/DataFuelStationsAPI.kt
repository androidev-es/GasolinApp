package es.jujoru.gasolinapp.data.api.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataFuelStationsAPI(
    @Json(name = "Fecha")
    val date: String,
    @Json(name = "ListaEESSPrecio")
    val listFuelStations: List<FuelStationAPI>,
    @Json(name = "Nota")
    val note: String,
    @Json(name = "ResultadoConsulta")
    val result: String
)