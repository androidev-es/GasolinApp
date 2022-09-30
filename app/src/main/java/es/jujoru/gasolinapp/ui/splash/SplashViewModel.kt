package es.jujoru.gasolinapp.ui.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.jujoru.gasolinapp.core.UtilsMethod
import es.jujoru.gasolinapp.domain.model.UserPreferences
import es.jujoru.gasolinapp.domain.usescases.*
import es.jujoru.gasolinapp.ui.common.Error
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getFuelStationUseCase: GetFuelStationUseCase,
    private val isEmptyLocalFuelStationUseCase: IsEmptyLocalFuelStationUseCase,
    private val isEmptyLocalLocationUseCase: IsEmptyLocalLocationUseCase,
    private val updateLocalLocationUseCase: UpdateLocalLocationUseCase,
    private val getUserPreferencesUseCase: GetUserPreferencesUseCase,
    private val insertUserPreferencesUseCase: InsertUserPreferencesUseCase
    ): ViewModel() {

    private var _splashUiState: MutableStateFlow<SplashUiState> =
        MutableStateFlow(SplashUiState())
    val splashUiState: StateFlow<SplashUiState>
        get() = _splashUiState

    private var _userPreference: MutableStateFlow<UserPreferences> =
        MutableStateFlow(UserPreferences())

    init {
        startedDataLoad()
    }
    private fun startedDataLoad(){
        _splashUiState.update { it.copy(isLoading = true) }
        getUserPreferences()
        viewModelScope.launch {
            if(_userPreference.value.isNullOrEmpty() || _userPreference.value.isExpiredLastUpdate()){
                getFuelStation()
                updateUserPreferencesLastUpdate()
                insertUserPreferences()
            }else{
               if(isEmptyLocalFuelStation()){
                   getFuelStation()
                   updateUserPreferencesLastUpdate()
                   insertUserPreferences()
               }else{
                   if(isEmptyLocalLocation()){
                       updateLocation()
                       updateUserPreferencesLastUpdate()
                   }
               }
            }
            _splashUiState.update { it.copy(isLoading = false) }
            if(isEmptyLocationInfoUserPreferences()){
                //Navigate to FuelStationsMain
                Log.i("FLUJO","Navigate FS")
            }else{
                //Navigate to LocationScreer or Dialog
                Log.i("FLUJO","Navigate LCS")
            }

        }
    }
    private fun getUserPreferences(){
         viewModelScope.launch(Dispatchers.IO) {
             getUserPreferencesUseCase.invoke().let {
                 it.collect{ userPreference ->
                     _userPreference.value = userPreference
                 }
             }
         }
    }

    private suspend fun getFuelStation(){
        val fuelStations = getFuelStationUseCase.invoke()
        if(fuelStations.isEmpty()){
            _splashUiState.update { it.copy(error = Error("Fuel Station Empty")) }
        }
    }

    private fun updateUserPreferencesLastUpdate(){
        _userPreference.update { it.copy(lastUpdateDate = UtilsMethod.getCurrentDate()) }
    }
    private fun isEmptyLocationInfoUserPreferences(): Boolean{
        return _userPreference.value.province.isNullOrEmpty()
    }
    private suspend fun isEmptyLocalFuelStation(): Boolean{
        return isEmptyLocalFuelStationUseCase.invoke()
    }
    private suspend fun isEmptyLocalLocation(): Boolean{
        return isEmptyLocalLocationUseCase.invoke()
    }
    private suspend fun insertUserPreferences(){
        _userPreference.value.let { insertUserPreferencesUseCase.invoke(it) }
    }
    private suspend fun updateLocation(){
        return updateLocalLocationUseCase.invoke()
    }

}