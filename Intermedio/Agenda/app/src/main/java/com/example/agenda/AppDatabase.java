package com.example.agenda;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Contact.class},version = 1)
public abstract class  AppDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();

    private static AppDatabase instance;

    // Patrón Singleton
    public static AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context,
                    AppDatabase.class,
                    "database").allowMainThreadQueries().build();
        }
        return instance;
    }
}
