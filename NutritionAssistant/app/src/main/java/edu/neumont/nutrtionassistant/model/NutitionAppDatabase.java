package edu.neumont.nutrtionassistant.model;

import androidx.room.RoomDatabase;

import edu.neumont.nutrtionassistant.dao.FoodDao;

public abstract class NutitionAppDatabase extends RoomDatabase {
    public abstract FoodDao foodDao();
}
