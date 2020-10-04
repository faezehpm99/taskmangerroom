package com.example.taskmanagerapplicationwuthroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface userDAO {
    @Insert
    void register(UserEntity userEntity);
    @Query("SELECT * FROM users WHERE userId=(:username) AND password=(:password)")
    UserEntity login(String username,String password);

}
