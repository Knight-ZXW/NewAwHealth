package com.think.awhealth.ui.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;

import com.think.awhealth.R;
import com.think.awhealth.ui.setting.Settings;

import butterknife.ButterKnife;

/**
 * Created by XiuWuZhuo on 2016/1/25.
 * Emial:nimdanoob@163.com
 */
public abstract class BaseMainActivity extends ToolBarActivity implements NavigationView.OnNavigationItemSelectedListener{

    protected NavigationView mNavigationView;

    @Override
    protected int provideContentViewId() {
        return 0;
    }
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
//        int id = item.getItemId();

//        if (id == R.id.nav_healthInfor) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return navigationItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (canExit()) {
                super.onBackPressed();
            }
        }
    }
    private long lastPressTime = 0;
    private boolean canExit() {
        Log.w("logger","settings isexit =="+Settings.isExitConfirm);
        if (Settings.isExitConfirm) {
            if (System.currentTimeMillis() - lastPressTime > 2000) {
                lastPressTime = System.currentTimeMillis();
                Snackbar.make(getCurrentFocus(), R.string.text_exit_confirm, Snackbar.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    public abstract boolean navigationItemSelected(MenuItem id);
}
