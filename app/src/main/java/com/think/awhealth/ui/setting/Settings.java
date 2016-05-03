package com.think.awhealth.ui.setting;

import android.content.Context;
import android.content.SharedPreferences;

import com.think.awhealth.App;

/**
 * Created by XiuWuZhuo on 2016/2/5.
 * Emial:nimdanoob@163.com
 */
public class Settings {
    public static final String XML_NAME = "settings";

    public static final String CLEAR_CACHE = "clear_cache";
    public static final String CHANGE_LANGUAGE = "change_language";
    public static final String SLIDE_BACK = "slide_back";
    public static final String NOTIFY_MESSAGE = "notify_message";
    public static final String EXIT_CONFIRM = "exit_confirm";


    public static boolean isExitConfirm = true;
    public static boolean isSlideBack = false;
    public static boolean isNotifyMessage = true;

    private static Settings sInstance;

    private static SharedPreferences mPrefs;

    public static Settings getInstance() {
        if (sInstance == null) {
            sInstance = new Settings(App.AppContext);
            isExitConfirm = mPrefs.getBoolean(Settings.EXIT_CONFIRM, false);
            isNotifyMessage = mPrefs.getBoolean(Settings.NOTIFY_MESSAGE, true);
        }
        return sInstance;
    }

    private Settings(Context context) {
        mPrefs = context.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
    }

    public Settings putBoolean(String key, boolean value) {
        mPrefs.edit().putBoolean(key, value).commit();
        return this;
    }

    public static boolean getBoolean(String key, boolean def) {
        return mPrefs.getBoolean(key, def);
    }

    public Settings putInt(String key, int value) {
        mPrefs.edit().putInt(key, value).commit();
        return this;
    }

    public int getInt(String key, int defValue) {
        return mPrefs.getInt(key, defValue);
    }

    public Settings putString(String key, String value) {
        mPrefs.edit().putString(key, value).commit();
        return this;
    }

    public String getString(String key, String defValue) {
        return mPrefs.getString(key, defValue);
    }
}
