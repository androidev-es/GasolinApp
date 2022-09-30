package es.jujoru.gasolinapp.core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.room.ColumnInfo
import com.google.android.gms.maps.model.LatLng
import es.jujoru.gasolinapp.data.api.responses.FuelStationAPI
import es.jujoru.gasolinapp.data.database.entities.FuelStationEntity
import es.jujoru.gasolinapp.data.database.entities.LocationEntity
import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.domain.model.Location
import es.jujoru.gasolinapp.domain.model.Prices
import es.jujoru.gasolinapp.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val FuelStationAPI.toDomain: FuelStation
    get() = FuelStation(
        idFuelStation, 
        schedule.split(";"),
        margin,
        remision,
        rotulo,
        typeSale,
        Location(
            cp,
            address,
            idCCAA.toInt(),
            idMunicipality.toInt(),
            idProvince.toInt(),
            LatLng(0.0,0.0),
            location,
            municipality,
            province
        ),
        Prices(
            priceBiodiesel,
            priceBioetanol,
            priceGasNaturalComprimido,
            priceGasNaturalLicuado,
            priceGasesLicuadosDelPetroleo,
            priceGasoleoA,
            priceGasoleoB,
            priceGasoleoPremium,
            priceGasolina95E10,
            priceGasolina95E5,
            priceGasolina95E5Premium,
            priceGasolina98E10,
            priceGasolina98E5,
            priceHidrogeno
        )
    )

 val FuelStation.toLocal: FuelStationEntity
    get() = FuelStationEntity(
        idFuelStation,
        "",
        location.cp,
        location.address,
        schedule.joinToString(";"),
        location.idCCAA.toString(),
        location.idMunicipality.toString(),
        location.idProvince.toString(),
        location.latLon.latitude.toString(),
        location.location,
        location.latLon.longitude.toString(),
        margin,
        location.municipality,
        prices.priceBiodiesel,
        prices.priceBioetanol,
        prices.priceGasNaturalComprimido,
        prices.priceGasNaturalLicuado,
        prices.priceGasesLicuadosDelPetroleo,
        prices.priceGasoleoA,
        prices.priceGasoleoB,
        prices.priceGasoleoPremium,
        prices.priceGasolina95E10,
        prices.priceGasolina95E5,
        prices.priceGasolina95E5Premium,
        prices.priceGasolina98E10,
        prices.priceGasolina98E5,
        prices.priceHidrogeno,
        location.province,
        remision,
        rotulo,
        typeSale,
        ""
    )

val FuelStationEntity.toDomain: FuelStation
    get() = FuelStation(
        idFuelStation,
        schedule.split(";"),
        margin,
        remision,
        rotulo,
        typeSale,
        Location(
            cp,
            address,
            idCCAA.toInt(),
            idMunicipality.toInt(),
            idProvince.toInt(),
            LatLng(0.0,0.0),
            location,
            municipality,
            province
        ),
        Prices(
            priceBiodiesel,
            priceBioetanol,
            priceGasNaturalComprimido,
            priceGasNaturalLicuado,
            priceGasesLicuadosDelPetroleo,
            priceGasoleoA,
            priceGasoleoB,
            priceGasoleoPremium,
            priceGasolina95E10,
            priceGasolina95E5,
            priceGasolina95E5Premium,
            priceGasolina98E10,
            priceGasolina98E5,
            priceHidrogeno
        )
    )

 val LocationEntity.toDomain: Location
         get() =
             Location(
                 cp,
                 address,
                 idCCAA.toInt(),
                 idMunicipality.toInt(),
                 idProvince.toInt(),
                 LatLng(0.0,0.0),
                 location,
                 municipality,
                 province
             )

val Location.toLocal: LocationEntity
get() = LocationEntity(
        null,
        cp,
        address,
        idCCAA.toString(),
        idMunicipality.toString(),
        idProvince.toString(),
        latLon.latitude.toString(),
        location,
        latLon.longitude.toString(),
        municipality,
        province

)

val DataStore<Preferences>.toUserPreference: Flow<UserPreferences>
    get() =
        data.map {
            val userPreferences = UserPreferences(
                lastUpdateDate = it[stringPreferencesKey(Constants.PREFERENCES_LAST_UPDATE)].orEmpty(),
                province = it[stringPreferencesKey(Constants.PREFERENCES_PROVINCE)].orEmpty(),
                location = it[stringPreferencesKey(Constants.PREFERENCES_LOCATION)].orEmpty()
            )
            userPreferences
        }


suspend fun DataStore<Preferences>.insertUserPreferences(userPreferences: UserPreferences){
        this.edit { pref ->
            pref[stringPreferencesKey(Constants.PREFERENCES_LAST_UPDATE)] = userPreferences.lastUpdateDate.orEmpty()
            pref[stringPreferencesKey(Constants.PREFERENCES_PROVINCE)] = userPreferences.province.orEmpty()
            pref[stringPreferencesKey(Constants.PREFERENCES_LOCATION)] = userPreferences.location.orEmpty()
        }
}

suspend fun DataStore<Preferences>.clearUserPreferences(){
        this.edit {
            it.clear()
        }
}