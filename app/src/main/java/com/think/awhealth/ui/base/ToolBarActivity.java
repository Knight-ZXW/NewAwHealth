package com.think.awhealth.ui.base;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;

import com.think.awhealth.R;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public abstract class ToolBarActivity extends BaseActivity{
    protected AppBarLayout mAppBar;

    protected Toolbar mToolbar;
    protected  boolean mIsHidden =false;

    protected abstract int provideContentViewId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentViewId());
        mAppBar = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar == null || mAppBar == null){
            throw new IllegalStateException("content layout must be have appbar and toolbar");
        }
        mToolbar.setOnClickListener(v -> onToolbarClick());
        setSupportActionBar(mToolbar);

        if (canBack()){
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null){
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                mAppBar.setElevation(10.6f);
            }
        }

    }



    protected boolean canBack() {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    protected void setAppBarAlpha (float alpha){
        mAppBar.setAlpha(alpha);
    }

    protected void hideOrShowToolBar(){
        mAppBar.animate()
                .translationY(mIsHidden? 0 : -mAppBar.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        mIsHidden = !mIsHidden;
    }

    protected void onToolbarClick() {

    }
}
