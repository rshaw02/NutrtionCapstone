package edu.neumont.nutrtionassistant.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

@Dao
public interface FoodDao {
    @Query("SELECT * FROM food ORDER BY name")
    Flow<List<Food>> loadFoods();

    @Query("SELECT * FROM food WHERE id IN (:foodIds)")
    Flow<List<Food>> loadFoodsByIds(int[] foodIds);

    @Query("SELECT * FROM food WHERE name LIKE :name")
    Flow<Food> loadFoodByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFood(Food food);

    @Delete
    void delete(Food food);
}
