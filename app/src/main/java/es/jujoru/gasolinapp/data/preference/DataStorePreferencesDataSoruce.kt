package es.jujoru.gasolinapp.data.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import es.jujoru.gasolinapp.core.Constants.PREFERENCES_LAST_UPDATE
import es.jujoru.gasolinapp.core.Constants.PREFERENCES_LOCATION
import es.jujoru.gasolinapp.core.Constants.PREFERENCES_PROVINCE
import es.jujoru.gasolinapp.core.insertUserPreferences
import es.jujoru.gasolinapp.core.toUserPreference
import es.jujoru.gasolinapp.data.sources.PreferenceDataSource
import es.jujoru.gasolinapp.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

data class DataStorePreferencesDataSoruce @Inject constructor(
    private val dataStore: DataStore<Preferences>
): PreferenceDataSource{

    override suspend fun getPreferencesUser(): Flow<UserPreferences> = dataStore.toUserPreference

    override suspend fun insertPreferenceUser(userPreferences: UserPreferences) =
        dataStore.insertUserPreferences(userPreferences)

    override suspend fun deletePreferenceUser() {
        dataStore.edit {
            it.clear()
        }
    }


}
