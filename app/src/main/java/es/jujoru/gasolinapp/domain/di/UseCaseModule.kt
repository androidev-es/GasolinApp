package es.jujoru.gasolinapp.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import es.jujoru.gasolinapp.data.repository.FuelStationRepository
import es.jujoru.gasolinapp.data.repository.PreferencesRepository
import es.jujoru.gasolinapp.domain.usescases.*

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideGetRemoteFuelStations(fuelStationRepository: FuelStationRepository) =
        GetFuelStationUseCase(fuelStationRepository)

    @ViewModelScoped
    @Provides
    fun provideGetUserPreferences(userPreferencesRepository: PreferencesRepository) =
        GetUserPreferencesUseCase(userPreferencesRepository)

    @ViewModelScoped
    @Provides
    fun provideInsertUserPreferences(userPreferencesRepository: PreferencesRepository) =
        InsertUserPreferencesUseCase(userPreferencesRepository)

    @ViewModelScoped
    @Provides
    fun provideIsEmptyLocalFuelStation(fuelStationRepository: FuelStationRepository) =
        IsEmptyLocalFuelStationUseCase(fuelStationRepository)

    @ViewModelScoped
    @Provides
    fun provideIsEmptyLocalLocation(fuelStationRepository: FuelStationRepository) =
        IsEmptyLocalLocationUseCase(fuelStationRepository)

    @ViewModelScoped
    @Provides
    fun provideGetLocalLocation(fuelStationRepository: FuelStationRepository) =
        GetLocalLocationUseCase(fuelStationRepository)

    @ViewModelScoped
    @Provides
    fun provideUpdateLocalLocationUseCase(fuelStationRepository: FuelStationRepository) =
        UpdateLocalLocationUseCase(fuelStationRepository)
}