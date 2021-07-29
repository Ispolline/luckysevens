package com.classic.vullks.casinoslots;

import android.app.Application;

import androidx.room.Room;

import com.classic.vullks.casinoslots.data.database.AppDatabase;
import com.classic.vullks.casinoslots.data.entities.User;
import com.onesignal.OneSignal;

public class App extends Application {

    public static App instance;
    private AppDatabase mDatabase;

    private static final String ONESIGNAL_APP_ID = "0b39a9cf-a5ab-4a58-961a-3ec53cfe1dba";

    @Override
    public void onCreate() {
        super.onCreate();

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        instance = this;
        mDatabase = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();

        if (mDatabase.mUserDao().getUserById(1) == null) {

            User user = new User();
            user.id = 1;
            user.auth = 0;
            user.name = "test";
            user.phone = "test";

            mDatabase.mUserDao().insertUser(user);
        }
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return mDatabase;
    }
}