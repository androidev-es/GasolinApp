package es.jujoru.gasolinapp.domain.model

import com.squareup.moshi.Json

data class FuelStation(

    val idFuelStation: String,
    val schedule: List<String>,
    val margin: String,
    val remision: String,
    val rotulo: String,
    val typeSale: String,
    val location: Location,
    val prices: Prices
) {
}