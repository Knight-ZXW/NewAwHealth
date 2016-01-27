package com.think.awhealth;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.think.awhealth.ui.base.BaseMainActivity;
import com.think.awhealth.ui.healthInfor.HealthInforViewPagerFragment;
import com.think.awhealth.util.AlarmManagerUtils;

import butterknife.InjectView;

public class MainActivity extends BaseMainActivity {
    @InjectView(R.id.fab)
    FloatingActionButton mFab;
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
        initData();
        switchFragment(new HealthInforViewPagerFragment(), getString(R.string.title_HealthInfor), R.menu.menu_healthinfor);
        mNavigationView.setCheckedItem(R.id.nav_healthInfor);
    }

    private void initData() {

    }

    private void initVariables() {
        mFragmentManager = getSupportFragmentManager();
    }


    @Override
    public void navigationItemSelected(MenuItem id) {
        int itemId = id.getItemId();
        if (mCurrentItemId == itemId)
            return;
        switch (itemId) {
            case R.id.nav_healthInfor:
                break;
        }
        mCurrentItemId = itemId;
    }

    private void switchFragment(Fragment fragment, String title, int resourceMenu) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.id_fragmentContainer, fragment);
        getSupportActionBar().setTitle(title);
        fragmentTransaction.commit();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this).build();

        if (menu != null) {
            menu.clear();
            getMenuInflater().inflate(resourceMenu, menu);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_healthinfor, menu);
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
