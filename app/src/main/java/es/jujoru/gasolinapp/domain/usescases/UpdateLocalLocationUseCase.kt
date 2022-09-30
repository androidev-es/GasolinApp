package es.jujoru.gasolinapp.domain.usescases

import es.jujoru.gasolinapp.data.repository.FuelStationRepository

class UpdateLocalLocationUseCase(
    private val fuelStationRepository: FuelStationRepository
) {
    suspend fun invoke() =
        fuelStationRepository.updateLocalLocation()
}