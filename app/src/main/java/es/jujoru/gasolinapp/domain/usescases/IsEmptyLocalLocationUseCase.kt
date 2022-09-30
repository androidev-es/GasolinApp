package es.jujoru.gasolinapp.domain.usescases

import es.jujoru.gasolinapp.data.repository.FuelStationRepository

class IsEmptyLocalLocationUseCase(
    private val fuelStationRepository: FuelStationRepository
) {
    suspend fun invoke(): Boolean =
        fuelStationRepository.isEmptyLocalLocation()
}