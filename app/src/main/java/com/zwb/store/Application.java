package com.zwb.store;

import android.util.Log;

import androidx.multidex.BuildConfig;
import androidx.multidex.MultiDexApplication;

import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mmkv.MMKV;
import com.zwb.store.utils.SpUtils;

public class Application extends MultiDexApplication {
    private static android.app.Application mApp;
    private static final String TAG = "StoreApplication_zwb";

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "e205dc13a6", false);

        String versionName = BuildConfig.VERSION_NAME;
        Log.e(TAG, "StoreApplication_Version Name--->" + versionName);

        String rootDir = MMKV.initialize(this);
        //启动服务
        Log.e(TAG, "onCreate: " + rootDir);
        SpUtils.getInstance();

        mApp = this;
    }

    public static android.app.Application getApp() {
        return mApp;
    }
}
