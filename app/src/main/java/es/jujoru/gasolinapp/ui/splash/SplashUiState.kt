package es.jujoru.gasolinapp.ui.splash

import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.ui.common.Error

data class SplashUiState(
    var isLoading: Boolean = false,
    var isFuelStationsLoad: Boolean = false,
    val isCacheSaved: Boolean = false,
    var error: Error? = null
)