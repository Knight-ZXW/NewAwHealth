package com.think.awhealth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.think.awhealth.ui.base.BaseMainActivity;
import com.think.awhealth.ui.healthInfor.HealthInforFragment;
import com.think.awhealth.util.AlarmManagerUtils;

public class MainActivity extends BaseMainActivity {
    private FragmentManager mFragmentManager;
    private int mCurrentItemId;
    private Menu menu;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlarmManagerUtils.register(this);
        initVariables();

        switchFragment(new HealthInforFragment(), "title", 0);
        mNavigationView.setCheckedItem(R.id.nav_healthInfor);
    }

    private void initVariables() {
        mFragmentManager = getSupportFragmentManager();
    }


    @Override
    public void navigationItemSelected(MenuItem id) {
        int itemId = id.getItemId();
        if (mCurrentItemId == itemId)
            return;
        switch (itemId){
            case R.id.nav_healthInfor:

                break;
        }
        mCurrentItemId = itemId;
    }

    private void switchFragment(Fragment fragment,String title,int resourceMenu){
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.id_fragmentContainer, fragment);
        getSupportActionBar().setTitle(title);
        fragmentTransaction.commit();
        if (menu != null){
//            getMenuInflater().inflate();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
