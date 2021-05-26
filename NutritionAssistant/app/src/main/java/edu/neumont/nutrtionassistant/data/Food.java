package edu.neumont.nutrtionassistant.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Food {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

//    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
//    public byte[] image;

    public Food(String name/*, byte[] image*/) {
        this.name = name;
//        this.image = image;
    }

}
