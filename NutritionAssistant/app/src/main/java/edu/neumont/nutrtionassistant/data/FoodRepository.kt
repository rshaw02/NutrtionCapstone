package edu.neumont.nutrtionassistant.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepository @Inject constructor(
    private val foodDao: FoodDao
) {

    fun getAll(): Flow<List<Food>> = foodDao.loadFoods()

    fun getById(ids: IntArray) = foodDao.loadFoodsByIds(ids)

    fun getByName(name: String) = foodDao.loadFoodByName(name)

    suspend fun addFood(food: Food) = withContext(Dispatchers.IO) { foodDao.insertFood(food) }

    fun remove(food: Food) = foodDao.delete(food)

}