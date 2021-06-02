package edu.neumont.nutrtionassistant.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NutritionFoodRepository @Inject constructor(
    private val nutritionFoodDao: NutritionFoodDao
) {

    fun getAll(): Flow<List<NutritionFood>> = nutritionFoodDao.loadFoods()

    fun getById(ids: IntArray) = nutritionFoodDao.loadFoodsByIds(ids)

    fun getByDate(date: String): Flow<List<NutritionFood>> = nutritionFoodDao.loadFoodByDate(date)

    suspend fun addFood(food: NutritionFood) = withContext(Dispatchers.IO) { nutritionFoodDao.insertFood(food) }

    fun remove(food: NutritionFood) = nutritionFoodDao.delete(food)

}