package es.jujoru.gasolinapp.data.api

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import es.jujoru.gasolinapp.core.toDomain
import es.jujoru.gasolinapp.core.toErrorRetrieved
import es.jujoru.gasolinapp.core.tryCall
import es.jujoru.gasolinapp.data.sources.RemoteDataSource
import es.jujoru.gasolinapp.domain.model.FuelStation
import es.jujoru.gasolinapp.domain.model.Error
import retrofit2.HttpException
import javax.inject.Inject


class APIDataSource @Inject constructor(
    private var apiService: APIService
    ): RemoteDataSource {
    override suspend fun getFuelStations(): List<FuelStation> {
        try{
            val response = apiService.getDataFuelStations()
            if(response.isSuccessful){
               return response.body()?.listFuelStations?.map { it.toDomain } ?: emptyList()
            }
        }catch (e: Exception){
            return emptyList()
        }
        return emptyList()
    }

}