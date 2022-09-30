package es.jujoru.gasolinapp.domain.model

import androidx.datastore.preferences.core.Preferences
import es.jujoru.gasolinapp.core.UtilsMethod
import es.jujoru.gasolinapp.ui.splash.SplashUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class UserPreferences(
     var lastUpdateDate: String? = null,
     var province: String? = null,
     var location: String? = null
){
     fun isExpiredLastUpdate(): Boolean{
        lastUpdateDate?.let {
            return UtilsMethod.isDateDiffToday(it)
        }
          return true
     }

     fun isNullOrEmpty(): Boolean {
          return lastUpdateDate.isNullOrEmpty() && province.isNullOrEmpty() && location.isNullOrEmpty()
     }
}
