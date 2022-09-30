package es.jujoru.gasolinapp.domain.usescases

import es.jujoru.gasolinapp.data.repository.FuelStationRepository
import es.jujoru.gasolinapp.domain.model.FuelStation

class GetLocalFuelStationUseCase(
    private val fuelStationRepository: FuelStationRepository
) {
    suspend fun invoke(): List<FuelStation> =
        fuelStationRepository.getLocalFuelStation()
}