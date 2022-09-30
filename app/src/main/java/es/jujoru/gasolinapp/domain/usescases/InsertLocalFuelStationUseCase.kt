package es.jujoru.gasolinapp.domain.usescases

import es.jujoru.gasolinapp.data.repository.FuelStationRepository
import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.domain.model.Location

class InsertLocalFuelStationUseCase(
    private val fuelStationRepository: FuelStationRepository
) {
    suspend fun invoke(fuelStations: List<FuelStation>) =
        fuelStationRepository.insertLocalFuelStation(fuelStations)
}