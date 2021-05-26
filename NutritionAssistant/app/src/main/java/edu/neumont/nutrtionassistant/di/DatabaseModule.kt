package edu.neumont.nutrtionassistant.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.neumont.nutrtionassistant.data.FoodDao
import edu.neumont.nutrtionassistant.data.NutritionAppDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideNutritionAppDatabase(@ApplicationContext context: Context): NutritionAppDatabase {
        return NutritionAppDatabase.getInstance(context)
    }

    @Provides
    fun provideFoodDao(appDatabase: NutritionAppDatabase): FoodDao {
        return appDatabase.foodDao()
    }
}