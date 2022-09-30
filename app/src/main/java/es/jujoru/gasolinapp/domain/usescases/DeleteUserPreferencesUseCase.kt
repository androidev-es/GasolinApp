package es.jujoru.gasolinapp.domain.usescases

import es.jujoru.gasolinapp.data.repository.PreferencesRepository

data class DeleteUserPreferencesUseCase(
    private val userPreferencesRepository: PreferencesRepository
){
    suspend fun invoke() =
        userPreferencesRepository.deleteUserPreferences()
}
