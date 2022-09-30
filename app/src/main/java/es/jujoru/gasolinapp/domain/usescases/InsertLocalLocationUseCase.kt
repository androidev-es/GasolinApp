package es.jujoru.gasolinapp.domain.usescases

import es.jujoru.gasolinapp.data.repository.FuelStationRepository
import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.domain.model.Location

class InsertLocalLocationUseCase(
    private val fuelStationRepository: FuelStationRepository
) {
    suspend fun invoke(locations: List<Location>) =
        fuelStationRepository.inserLocalLocations(locations)
}