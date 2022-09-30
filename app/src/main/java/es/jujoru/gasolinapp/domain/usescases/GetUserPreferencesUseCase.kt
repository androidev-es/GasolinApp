package es.jujoru.gasolinapp.domain.usescases

import es.jujoru.gasolinapp.data.repository.PreferencesRepository
import es.jujoru.gasolinapp.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

data class GetUserPreferencesUseCase(
    private val userPreferencesRepository: PreferencesRepository
){
    suspend fun invoke(): Flow<UserPreferences> =
        userPreferencesRepository.getUserPreferences()
}