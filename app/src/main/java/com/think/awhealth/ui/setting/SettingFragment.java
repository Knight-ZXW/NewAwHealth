package com.think.awhealth.ui.setting;


import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.think.awhealth.R;
import com.think.awhealth.util.AppUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {

    private Settings mSettings;

    private Preference mClearCache;
    private Preference mLanguage;
//    private CheckBoxPreference mSlideBack;
    private CheckBoxPreference mExitConfirm;
    //是否每日提醒消息
    private CheckBoxPreference mNotifyMessage;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        mSettings = Settings.getInstance();

        mLanguage = findPreference(getString(R.string.setting_key_change_language));
        mLanguage.setOnPreferenceClickListener(this);


//        mSlideBack = (CheckBoxPreference) findPreference(getString(R.string.setting_key_slide_back));
//        mSlideBack.setOnPreferenceChangeListener(this);
//        mSlideBack.setChecked(Settings.isSlideBack);

        mExitConfirm = (CheckBoxPreference) findPreference(getString(R.string.setting_key_exit_confirm));
        mExitConfirm.setOnPreferenceChangeListener(this);
        mExitConfirm.setChecked(Settings.isExitConfirm);

        mNotifyMessage = (CheckBoxPreference)findPreference(getString(R.string.setting_key_notify_message));
        mNotifyMessage.setOnPreferenceChangeListener(this);
        mNotifyMessage.setChecked(Settings.isNotifyMessage);

        mClearCache = findPreference(getString(R.string.setting_key_clear_cache));
        mClearCache.setTitle("清除缓存,目前文件缓存大小:"+AppUtils.getFileCacheSizeIfConfigIsDefault(getActivity())/(1024.0f)+"Kb");
        mClearCache.setOnPreferenceClickListener(this);


    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Log.w("logger","preference change and value is "+newValue.toString());
        if (preference == mExitConfirm){
            Settings.isExitConfirm = Boolean.valueOf(newValue.toString());
            Log.w("logger","settings isExitConfirm =="+Settings.isExitConfirm);
            mSettings.putBoolean(Settings.EXIT_CONFIRM,Settings.isExitConfirm);
            return true;
//        } else if (preference == mSlideBack){
//            Settings.isSlideBack = Boolean.valueOf(newValue.toString());
//            mSettings.putBoolean(Settings.SLIDE_BACK,Settings.isSlideBack);
//            Toast.makeText(getActivity(),"兼容问题，暂不支持",Toast.LENGTH_LONG).show();
//            return true;
        } else if (preference == mNotifyMessage){
            Settings.isNotifyMessage = Boolean.valueOf(newValue.toString());
            mSettings.putBoolean(Settings.NOTIFY_MESSAGE,Settings.isNotifyMessage);
            return true;
        }

        return false;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        if (preference == mClearCache){
            AppUtils.ClearAllCache();
            Snackbar.make(getView(),"清除缓存成功",Snackbar.LENGTH_SHORT).show();
            mClearCache.setTitle("清除缓存,目前缓存大小: 0 Mb");
            return true;
        } else if (preference == mLanguage){
            Toast.makeText(getActivity(),"暂不支持多语言",Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

}
