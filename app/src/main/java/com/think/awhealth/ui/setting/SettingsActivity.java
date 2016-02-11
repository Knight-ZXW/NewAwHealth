package com.think.awhealth.ui.setting;

import android.os.Bundle;

import com.think.awhealth.R;
import com.think.awhealth.ui.base.ToolBarActivity;

public class SettingsActivity extends ToolBarActivity {

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_settings;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.id_fragmentContainer,new SettingFragment())
                .commit();
    }

    @Override
    protected boolean canBack() {
        return true;
    }
}
