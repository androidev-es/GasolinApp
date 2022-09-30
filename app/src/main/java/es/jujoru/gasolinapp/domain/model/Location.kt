package es.jujoru.gasolinapp.domain.model

import com.google.android.gms.maps.model.LatLng

data class Location(
    val cp: String,
    val address: String,
    val idCCAA: Int,
    val idMunicipality: Int,
    val idProvince: Int,
    val latLon: LatLng,
    val location: String,
    val municipality: String,
    val province: String,
)