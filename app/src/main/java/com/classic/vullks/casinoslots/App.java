package com.classic.vullks.casinoslots;
import com.appsflyer.AppsFlyerLib;

import android.app.Application;

import androidx.room.Room;

import com.classic.vullks.casinoslots.data.database.AppDatabase;
import com.classic.vullks.casinoslots.data.entities.User;
import com.onesignal.OneSignal;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

public class App extends Application {

    public static App instance;
    private AppDatabase mDatabase;

    private static final String ONESIGNAL_APP_ID = "0b39a9cf-a5ab-4a58-961a-3ec53cfe1dba";
    private static final String Yandex_Metrica_APP_key = "11375168-b9ef-40e0-b3e9-10fea7dea9be";
    private static final String AppsFlyerLib_DEV_KEY = "bSiQz4zRRTErHDbyxPM6fg";

    @Override
    public void onCreate() {
        super.onCreate();

        AppsFlyerLib.getInstance().init(AppsFlyerLib_DEV_KEY, null, this);
        AppsFlyerLib.getInstance().start(this);

        // Creating an extended library configuration.
        YandexMetricaConfig config = YandexMetricaConfig.newConfigBuilder(Yandex_Metrica_APP_key).build();
        // Initializing the AppMetrica SDK.
        YandexMetrica.activate(getApplicationContext(), config);
        // Automatic tracking of user activity.
        YandexMetrica.enableActivityAutoTracking(this);

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