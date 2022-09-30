package es.jujoru.gasolinapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity (
    @PrimaryKey(autoGenerate = true)
    val idLocation: Int?,
    @ColumnInfo(name = "cp")
    val cp: String,
    @ColumnInfo(name = "address")
    val address: String,
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
    @ColumnInfo(name = "municipality")
    val municipality: String,
    @ColumnInfo(name = "province")
    val province: String
)