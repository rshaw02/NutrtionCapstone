package edu.neumont.nutrtionassistant.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

@Dao
public interface NutritionFoodDao {
    @Query("SELECT * FROM nutritionFood ORDER BY name")
    Flow<List<NutritionFood>> loadFoods();

    @Query("SELECT * FROM nutritionFood WHERE id IN (:foodIds)")
    Flow<List<NutritionFood>> loadFoodsByIds(int[] foodIds);

    @Query("SELECT * FROM nutritionFood WHERE date LIKE :date")
    Flow<List<NutritionFood>> loadFoodByDate(String date);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFood(NutritionFood food);

    @Delete
    void delete(NutritionFood food);
}
