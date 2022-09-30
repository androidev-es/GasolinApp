package es.jujoru.gasolinapp.domain.model

data class Prices(
    val priceBiodiesel: String,
    val priceBioetanol: String,
    val priceGasNaturalComprimido: String,
    val priceGasNaturalLicuado: String,
    val priceGasesLicuadosDelPetroleo: String,
    val priceGasoleoA: String,
    val priceGasoleoB: String,
    val priceGasoleoPremium: String,
    val priceGasolina95E10: String,
    val priceGasolina95E5: String,
    val priceGasolina95E5Premium: String,
    val priceGasolina98E10: String,
    val priceGasolina98E5: String,
    val priceHidrogeno: String
)