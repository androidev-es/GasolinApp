package es.jujoru.gasolinapp.data.sources

import es.jujoru.gasolinapp.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface PreferenceDataSource {
    suspend fun getPreferencesUser(): Flow<UserPreferences>
    suspend fun insertPreferenceUser(userPreferences: UserPreferences)
    suspend fun deletePreferenceUser()
}