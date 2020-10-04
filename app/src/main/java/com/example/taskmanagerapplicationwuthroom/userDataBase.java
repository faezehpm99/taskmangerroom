package com.example.taskmanagerapplicationwuthroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class},version = 1)
public  abstract class userDataBase extends RoomDatabase {
    public static final String dbName = "user";
    public static userDataBase sUserDatabase;

    public static synchronized userDataBase getUserDatabase(Context context) {
        if (sUserDatabase == null) {
            sUserDatabase =Room.databaseBuilder(context,userDataBase.class,dbName).fallbackToDestructiveMigration().build();

        }
        return sUserDatabase;
    }

    public abstract userDAO userDAO();

}
