package edu.neumont.nutrtionassistant.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NutritionFood {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public int calories;

    /**
     * Stored in the format yyyy-mm-dd
     */
    public String date;

    public NutritionFood(String name, int calories, String date) {
        this.name = name;
        this.calories = calories;
        this.date = date;
    }

}

