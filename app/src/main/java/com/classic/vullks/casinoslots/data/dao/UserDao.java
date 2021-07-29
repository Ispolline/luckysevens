package com.classic.vullks.casinoslots.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.classic.vullks.casinoslots.data.entities.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE id = :id")
    public User getUserById(long id);

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}