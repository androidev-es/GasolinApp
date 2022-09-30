package es.jujoru.gasolinapp.data.api.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FuelStationAPI(
    @Json(name = "% BioEtanol")
    val bioEtanol: String,
    @Json(name = "C.P.")
    val cp: String,
    @Json(name = "Dirección")
    val address: String,
    @Json(name = "Horario")
    val schedule: String,
    @Json(name = "IDCCAA")
    val idCCAA: String,
    @Json(name = "IDEESS")
    val idFuelStation: String,
    @Json(name = "IDMunicipio")
    val idMunicipality: String,
    @Json(name = "IDProvincia")
    val idProvince: String,
    @Json(name = "Latitud")
    val lat: String,
    @Json(name = "Localidad")
    val location: String,
    @Json(name = "Longitud (WGS84)")
    val lon: String,
    @Json(name = "Margen")
    val margin: String,
    @Json(name = "Municipio")
    val municipality: String,
    @Json(name = "Precio Biodiesel")
    val priceBiodiesel: String,
    @Json(name = "Precio Bioetanol")
    val priceBioetanol: String,
    @Json(name = "Precio Gas Natural Comprimido")
    val priceGasNaturalComprimido: String,
    @Json(name = "Precio Gas Natural Licuado")
    val priceGasNaturalLicuado: String,
    @Json(name = "Precio Gases licuados del petróleo")
    val priceGasesLicuadosDelPetroleo: String,
    @Json(name = "Precio Gasoleo A")
    val priceGasoleoA: String,
    @Json(name = "Precio Gasoleo B")
    val priceGasoleoB: String,
    @Json(name = "Precio Gasoleo Premium")
    val priceGasoleoPremium: String,
    @Json(name = "Precio Gasolina 95 E10")
    val priceGasolina95E10: String,
    @Json(name = "Precio Gasolina 95 E5")
    val priceGasolina95E5: String,
    @Json(name = "Precio Gasolina 95 E5 Premium")
    val priceGasolina95E5Premium: String,
    @Json(name = "Precio Gasolina 98 E10")
    val priceGasolina98E10: String,
    @Json(name = "Precio Gasolina 98 E5")
    val priceGasolina98E5: String,
    @Json(name = "Precio Hidrogeno")
    val priceHidrogeno: String,
    @Json(name = "Provincia")
    val province: String,
    @Json(name = "Remisión")
    val remision: String,
    @Json(name = "Rótulo")
    val rotulo: String,
    @Json(name = "Tipo Venta")
    val typeSale: String,
    @Json(name = "% Éster metílico")
    val eterMetilico: String
)