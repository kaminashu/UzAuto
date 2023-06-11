package com.example.uzauto.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarDao {
    @Query("SELECT * FROM user")
    List<UserModel> getAll();

    @Query("SELECT * FROM user WHERE userId IN (:userIds)")
    List<UserModel> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE name LIKE :first AND " +
            "name LIKE :last LIMIT 1")
    UserModel findByName(String first, String last);

    @Insert
    void insertAll(UserModel... users);

    @Delete
    void delete(UserModel user);
}