package es.jujoru.gasolinapp.domain.usescases

import es.jujoru.gasolinapp.data.repository.FuelStationRepository
import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.domain.model.Location

class GetLocalLocationUseCase(
private val fuelStationRepository: FuelStationRepository
) {
    suspend fun invoke(): List<Location> =
        fuelStationRepository.getLocalLocations()
}