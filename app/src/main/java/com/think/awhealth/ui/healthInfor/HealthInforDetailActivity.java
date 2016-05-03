package com.think.awhealth.ui.healthInfor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.think.awhealth.App;
import com.think.awhealth.R;
import com.think.awhealth.api.AppConstant;
import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.bean.entity.QuestionDetail;
import com.think.awhealth.database.DbHelper;
import com.think.awhealth.ui.base.ToolBarActivity;
import com.think.awhealth.util.AppUtils;
import com.think.awhealth.util.HtmlRegexpUtil;
import com.think.awhealth.util.TimeUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HealthInforDetailActivity extends ToolBarActivity {

//    public static final String View_HEADER_IMAGE ="detail:header:image";
//    public static final String View_HEADER_TITLE ="detail:header:title";

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.content_title)
    TextView tv_contentTitle;
    @InjectView(R.id.content_date)
    TextView tv_contentDate;
    @InjectView(R.id.content_main)
    TextView tv_contentMain;
    @InjectView(R.id.id_image_infor)
    SimpleDraweeView mImage;
    @InjectView(R.id.fab)
    FloatingActionButton mFab;
    private int inforId;
    private HealthInfor mHealthInfor;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_health_infor_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        inforId = intent.getExtras().getInt("InforId");

        //在透明主题中有bug 待解决
//        ViewCompat.setTransitionName(mImage,View_HEADER_IMAGE);
//        ViewCompat.setTransitionName(tv_contentTitle,View_HEADER_TITLE);
        loadData();
        initView();
    }

    private void initView() {

        mFab.setOnClickListener(view->{

            if (!DbHelper.HealthInforDb.isCollected(mHealthInfor.getId())){
                boolean success = DbHelper.HealthInforDb.collectHelathInfor(mHealthInfor);
                if (success) {
                    Snackbar.make(toolbar, R.string.collect_success, Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(toolbar, "收藏失败", Snackbar.LENGTH_SHORT).show();
                }
            } else {
                DbHelper.HealthInforDb.unCollectedHealthInfor(mHealthInfor.getId());
                Snackbar.make(toolbar, R.string.collect_repeat, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    protected void loadData() {
        sTianGouIO.getHealthInforDetail(inforId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(healthInfor -> {
                    this.mHealthInfor = healthInfor;
                    showData(healthInfor);
                }, throwable -> showError(throwable));
    }

    private void showData(HealthInfor healthInfor) {
        tv_contentTitle.setText(healthInfor.getTitle());
        tv_contentDate.setText(TimeUtils.getTime(healthInfor.getTime()));
        tv_contentMain.setText(Html.fromHtml(HtmlRegexpUtil.fiterHtmlTag(healthInfor.getMessage(), "img"), AppUtils.getHtmlImageGetter(), null));
        mImage.setImageURI(Uri.parse(AppConstant.IMAGE_URL_PREFIX + healthInfor.getImg()));
    }

    @Override
    protected boolean canBack() {
        return true;
    }

}
