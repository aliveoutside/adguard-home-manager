package ru.toxyxd.adguardhome.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.toxyxd.adguardhome.data.repository.StorageRepositoryImpl
import ru.toxyxd.adguardhome.domain.repository.StorageRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {
    @Provides
    @Singleton
    fun provideStorageRepository(@ApplicationContext ctx: Context): StorageRepository {
        return StorageRepositoryImpl(ctx)
    }
}