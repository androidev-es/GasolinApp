package es.jujoru.gasolinapp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.jujoru.gasolinapp.core.Constants.BASE_URL
import es.jujoru.gasolinapp.data.api.APIService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }


    @Singleton
    @Provides
    fun providerOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return  OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providerRetrofit(client: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())

    @Singleton
    @Provides
    fun providerAPIService(retrofitBuilder: Retrofit.Builder): APIService =
        retrofitBuilder
            .baseUrl(BASE_URL)
            .build()
            .create(APIService::class.java)
}