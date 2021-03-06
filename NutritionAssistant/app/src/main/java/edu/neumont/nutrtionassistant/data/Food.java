package edu.neumont.nutrtionassistant.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Food {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public int calories;

//    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
//    public byte[] image;

    public Food(String name, int calories/*, byte[] image*/) {
        this.name = name;
        this.calories = calories;
//        this.image = image;
    }

}
