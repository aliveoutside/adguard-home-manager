package ru.toxyxd.adguardhome.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import okhttp3.OkHttpClient
import ru.toxyxd.adguardhome.data.utils.BaseRequestFlow
import ru.toxyxd.adguardhome.domain.repository.StorageRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkhttp() = OkHttpClient()

    @Provides
    @Singleton
    fun provideHttpClient(okHttpClient: OkHttpClient): HttpClient =
        HttpClient(OkHttp) {
            engine {
                preconfigured = okHttpClient
            }
            install(ContentNegotiation) {
                json()
            }
        }

    @Provides
    @Singleton
    fun provideBaseRequestFlow(
        httpClient: HttpClient,
        storageRepository: StorageRepository
    ): BaseRequestFlow = BaseRequestFlow(storageRepository, httpClient)
}