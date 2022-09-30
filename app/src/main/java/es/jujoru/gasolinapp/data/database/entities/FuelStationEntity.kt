package es.jujoru.gasolinapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fuelStations")
data class FuelStationEntity (

    @PrimaryKey
    val idFuelStation: String,
    @ColumnInfo(name = "bioetanol")
    val bioEtanol: String,
    @ColumnInfo(name = "cp")
    val cp: String,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "schedule")
    val schedule: String,
    @ColumnInfo(name = "idCCAA")
    val idCCAA: String,
    @ColumnInfo(name = "idMunicipality")
    val idMunicipality: String,
    @ColumnInfo(name = "idProvince")
    val idProvince: String,
    @ColumnInfo(name = "lat")
    val lat: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "lon")
    val lon: String,
    @ColumnInfo(name = "margin")
    val margin: String,
    @ColumnInfo(name = "municipality")
    val municipality: String,
    @ColumnInfo(name = "priceBiodiesel")
    val priceBiodiesel: String,
    @ColumnInfo(name = "priceBioetanol")
    val priceBioetanol: String,
    @ColumnInfo(name = "priceGasNaturalComprimido")
    val priceGasNaturalComprimido: String,
    @ColumnInfo(name = "priceGasNaturalLicuado")
    val priceGasNaturalLicuado: String,
    @ColumnInfo(name = "priceGasesLicuadosDelPetroleo")
    val priceGasesLicuadosDelPetroleo: String,
    @ColumnInfo(name = "priceGasoleoA")
    val priceGasoleoA: String,
    @ColumnInfo(name = "priceGasoleoB")
    val priceGasoleoB: String,
    @ColumnInfo(name = "priceGasoleoPremium")
    val priceGasoleoPremium: String,
    @ColumnInfo(name = "priceGasolina95E10")
    val priceGasolina95E10: String,
    @ColumnInfo(name = "priceGasolina95E5")
    val priceGasolina95E5: String,
    @ColumnInfo(name = "priceGasolina95E5Premium")
    val priceGasolina95E5Premium: String,
    @ColumnInfo(name = "priceGasolina98E10")
    val priceGasolina98E10: String,
    @ColumnInfo(name = "priceGasolina98E5")
    val priceGasolina98E5: String,
    @ColumnInfo(name = "priceHidrogeno")
    val priceHidrogeno: String,
    @ColumnInfo(name = "province")
    val province: String,
    @ColumnInfo(name = "remision")
    val remision: String,
    @ColumnInfo(name = "rotulo")
    val rotulo: String,
    @ColumnInfo(name = "typeSale")
    val typeSale: String,
    @ColumnInfo(name = "eterMetilico")
    val eterMetilico: String
)