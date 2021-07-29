package com.classic.vullks.casinoslots.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.classic.vullks.casinoslots.data.dao.UserDao;
import com.classic.vullks.casinoslots.data.entities.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao mUserDao();
}