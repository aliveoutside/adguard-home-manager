package ru.toxyxd.feature.server.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import ru.toxyxd.feature.core.FeatureEntry
import ru.toxyxd.feature.core.di.FeatureEntryKey
import ru.toxyxd.feature.server.ServerFeature
import ru.toxyxd.feature.server.ServerFeatureImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ServerFeatureModule {
    @Singleton
    @Binds
    @IntoMap
    @FeatureEntryKey(value = ServerFeature::class)
    fun serverFeature(entry: ServerFeatureImpl): FeatureEntry
}