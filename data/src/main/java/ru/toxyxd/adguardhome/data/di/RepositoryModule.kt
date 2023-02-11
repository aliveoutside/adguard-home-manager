package ru.toxyxd.adguardhome.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.toxyxd.adguardhome.data.repository.*
import ru.toxyxd.adguardhome.data.utils.BaseRequestFlow
import ru.toxyxd.adguardhome.domain.repository.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAdGuardClientsRepository(
        baseRequestFlow: BaseRequestFlow
    ): ClientsRepository = ClientsRepositoryImpl(baseRequestFlow)

    @Provides
    @Singleton
    fun provideAdGuardFilteringRepository(
        baseRequestFlow: BaseRequestFlow
    ): FilteringRepository = FilteringRepositoryImpl(baseRequestFlow)

    @Provides
    @Singleton
    fun provideAdGuardGlobalRepository(
        baseRequestFlow: BaseRequestFlow
    ): GlobalRepository = GlobalRepositoryImpl(baseRequestFlow)

    @Provides
    @Singleton
    fun provideAdGuardLogsRepository(
        baseRequestFlow: BaseRequestFlow
    ): LogsRepository = LogsRepositoryImpl(baseRequestFlow)

    @Provides
    @Singleton
    fun provideAdGuardParentalRepository(
        baseRequestFlow: BaseRequestFlow
    ): ParentalRepository = ParentalRepositoryImpl(baseRequestFlow)

    @Provides
    @Singleton
    fun provideAdGuardSafeBrowsingRepository(
        baseRequestFlow: BaseRequestFlow
    ): SafeBrowsingRepository = SafeBrowsingRepositoryImpl(baseRequestFlow)

    @Provides
    @Singleton
    fun provideAdGuardSafeSearchRepository(
        baseRequestFlow: BaseRequestFlow
    ): SafeSearchRepository = SafeSearchRepositoryImpl(baseRequestFlow)

    @Provides
    @Singleton
    fun provideAdGuardStatsRepository(
        baseRequestFlow: BaseRequestFlow
    ): StatsRepository = StatsRepositoryImpl(baseRequestFlow)
}