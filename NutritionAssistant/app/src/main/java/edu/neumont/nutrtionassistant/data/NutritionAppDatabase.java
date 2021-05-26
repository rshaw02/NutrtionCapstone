package edu.neumont.nutrtionassistant.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Food.class}, version = 1)
public abstract class NutritionAppDatabase extends RoomDatabase {

    public abstract FoodDao foodDao();

    private static volatile NutritionAppDatabase INSTANCE;

    public static NutritionAppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (NutritionAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), NutritionAppDatabase.class, "Nutrition_Database").build();
                }
            }
        }
        return INSTANCE;
    }

}
