package com.think.awhealth.ui.question;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.think.awhealth.App;
import com.think.awhealth.R;
import com.think.awhealth.api.AppConstant;
import com.think.awhealth.data.entity.QuestionDetail;
import com.think.awhealth.database.DbHelper;
import com.think.awhealth.ui.base.ToolBarActivity;
import com.think.awhealth.util.AppUtils;
import com.think.awhealth.util.HtmlRegexpUtil;
import com.think.awhealth.util.TimeUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by XiuWuZhuo on 2016/2/13.
 * Emial:nimdanoob@163.com
 */

/**
 * 这个页面用的跟healthInforDetail 一样的布局，懒得重构了。将就下，服务器的api也有bug很多信息错位的
 */
public class QuestionDetailActivity extends ToolBarActivity {
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
    private QuestionDetail mQuestionDetail;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_question_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        inforId = intent.getExtras().getInt("InforId");

        loadData();
        initView();
    }

    private void initView() {

        mFab.setOnClickListener(view->{

            if (!DbHelper.containInDb(QuestionDetail.class,mQuestionDetail.getId())){
                App.sDb.save(mQuestionDetail);
                Snackbar.make(toolbar, R.string.collect_success, Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(toolbar, R.string.collect_repeat, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    protected void loadData() {
        sTianGouIO.getQuestionDetailByQId(inforId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(healthInfor -> {
                    this.mQuestionDetail = healthInfor;
                    showData(mQuestionDetail);
                }, throwable -> showError(throwable));
    }

    private void showData(QuestionDetail questionDetail) {
        tv_contentTitle.setText(questionDetail.getTitle());
        tv_contentDate.setText(TimeUtils.getTime(questionDetail.getTime()));
        tv_contentMain.setText(Html.fromHtml(HtmlRegexpUtil.fiterHtmlTag(questionDetail.getMessage(), "img"), AppUtils.getHtmlImageGetter(), null));
        mImage.setImageURI(Uri.parse(AppConstant.IMAGE_URL_PREFIX + questionDetail.getImg()));
    }

    @Override
    protected boolean canBack() {
        return true;
    }
}
