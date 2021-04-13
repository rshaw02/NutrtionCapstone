package edu.neumont.nutrtionassistant.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.neumont.nutrtionassistant.model.Food;

@Dao
public interface FoodDao {
    @Query("SELECT * FROM food")
    List<Food> getAll();

    @Query("SELECT * FROM food WHERE id IN (:foodIds)")
    List<Food> loadAllByIds(int[] foodIds);

    @Query("SELECT * FROM food WHERE name LIKE :name")
    Food findByName(String name, String last);

    @Insert
    void insertAll(Food... foods);

    @Delete
    void delete(Food food);
}
