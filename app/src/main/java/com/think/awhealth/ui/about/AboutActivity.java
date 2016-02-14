package com.think.awhealth.ui.about;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.think.awhealth.R;
import com.think.awhealth.util.ShareUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class AboutActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.inject(this);

        mCollapsingToolbarLayout.setTitle(getString(R.string.app_name));
        setSupportActionBar(mToolbar);
//      此API的调用会在toolbar左端显示一个后退的图片，可以为此设置点击事件
//      当用户触摸这个图标时，系统会调用带有android.R.id.home ID的onOptionsItemSelected()方法。
//      请记住要在Intent对象中使用FLAG_ACTIVITY_CLEAR_TOP标识，
//      以便你不会这个父Activity存在的情况下，再创建一个新的实例。
//      例如，如果你不使用FLAG_ACTIVITY_CLEAR_TOP标识，那么向上导航后，
//      再按回退按钮，实际上会把用户带到应用程序的下级页面，这是很奇怪的。
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_share:
//                todo 分享操作
                ShareUtils.share(this,R.string.share_text);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
