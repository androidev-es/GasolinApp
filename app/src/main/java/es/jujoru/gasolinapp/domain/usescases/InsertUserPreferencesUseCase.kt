package es.jujoru.gasolinapp.domain.usescases

import es.jujoru.gasolinapp.data.repository.PreferencesRepository
import es.jujoru.gasolinapp.domain.model.UserPreferences

data class InsertUserPreferencesUseCase (
    private val userPreferencesRepository: PreferencesRepository
    ){
    suspend fun invoke(userPreferences: UserPreferences) =
        userPreferencesRepository.insertUserPreferences(userPreferences)
}