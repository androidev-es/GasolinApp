package es.jujoru.gasolinapp.data.sources

import arrow.core.Either
import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.domain.model.Error

interface RemoteDataSource {
    suspend fun getFuelStations(): List<FuelStation>
}