package es.jujoru.gasolinapp.data.repository

import es.jujoru.gasolinapp.data.sources.PreferenceDataSource
import es.jujoru.gasolinapp.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

class PreferencesRepository(
    private val preferenceDataSource: PreferenceDataSource
) {
    suspend fun getUserPreferences(): Flow<UserPreferences> {
        return preferenceDataSource.getPreferencesUser()
    }
    suspend fun insertUserPreferences(userPreferences: UserPreferences) =
        preferenceDataSource.insertPreferenceUser(userPreferences)

    suspend fun deleteUserPreferences() =
        preferenceDataSource.deletePreferenceUser()

}