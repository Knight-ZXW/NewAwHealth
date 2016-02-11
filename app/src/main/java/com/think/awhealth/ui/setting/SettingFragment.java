package com.think.awhealth.ui.setting;


import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.think.awhealth.R;
import com.think.awhealth.util.AppUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {


    private Preference mClearCache;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        mClearCache = findPreference(getString(R.string.setting_key_clear_cache));
        System.out.format("清楚缓存,目前缓存文件大小 %.2fKb",AppUtils.getFileCacheSizeIfConfigIsDefault(getActivity())/(1024.0f));
        mClearCache.setTitle("清除缓存,目前文件缓存大小:"+AppUtils.getFileCacheSizeIfConfigIsDefault(getActivity())/(1024.0f)+"Kb");
        Log.w("logger",AppUtils.getFileCacheSizeIfConfigIsDefault(getActivity())+"b");
        long cache = AppUtils.getFileCacheSizeIfConfigIsDefault(getActivity());
        mClearCache.setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        return false;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        if (preference == mClearCache){
            AppUtils.ClearAllCache();
            Snackbar.make(getView(),"清除缓存成功",Snackbar.LENGTH_SHORT).show();

            mClearCache.setTitle("清除缓存,目前缓存大小: 0 Mb");
        }
        return false;
    }

}
