package com.think.awhealth.ui.healthInfor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.think.awhealth.R;
import com.think.awhealth.api.AppConstant;
import com.think.awhealth.bean.entity.HealthComment;
import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.bean.entity.User;
import com.think.awhealth.database.DbHelper;
import com.think.awhealth.ui.adapter.CommentAdapter;
import com.think.awhealth.ui.base.ToolBarActivity;
import com.think.awhealth.util.AppUtils;
import com.think.awhealth.util.HtmlRegexpUtil;
import com.think.awhealth.util.TimeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
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

    @InjectView(R.id.id_recommend_edt)
    EditText recommendEtv;
    @InjectView(R.id.id_recommend_submit)
    Button submitRecommendBtn;
    @InjectView(R.id.id_comment_recyclerView)
    RecyclerView mCommentRecyclerView;

    private int inforId;
    private HealthInfor mHealthInfor;
    private CommentAdapter mCommentAdapter;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_health_infor_detail;
    }

    List<HealthComment> healthCommentList;

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
        healthCommentList = new ArrayList<>();

        initVariables();
        initView();
        loadData();
    }

    private void initVariables() {
        mCommentAdapter = new CommentAdapter(this, healthCommentList, R.layout.item_comment);
    }

    private void initView() {

        mFab.setOnClickListener(view -> {

            collectHealthInfor();
        });
        mCommentRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mCommentRecyclerView.setAdapter(mCommentAdapter);
    }

    private void collectHealthInfor() {
        if (!DbHelper.HealthInforDb.isCollected(mHealthInfor.getId())) {
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
    }

    @OnClick(R.id.id_recommend_submit)
    public void subMitRecommend() {
        String recommendStr = recommendEtv.getText().toString();
        HealthComment healthComment = new HealthComment();
        healthComment.postId = inforId;
        healthComment.comment = recommendStr;
        BmobUser currentUser = User.getCurrentUser(this);
        if (currentUser != null) {
            healthComment.UserName = currentUser.getUsername();
        } else {
            healthComment.UserName = "匿名者";
        }
        healthComment.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Log.w("logger", "上传成功");
                recommendEtv.setText("");
                mCommentAdapter.add(healthComment);
                mCommentRecyclerView.scrollToPosition(mCommentAdapter.getItemCount());
                Toast.makeText(getBaseContext(), "评论成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Log.w("logger", "上传失败");
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

        //加载评论数据刷新视图
        BmobQuery<HealthComment> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("postId", inforId)
                .findObjects(this, new FindListener<HealthComment>() {
                    @Override
                    public void onSuccess(List<HealthComment> list) {
                        Log.w("logger", "onSuccess" + list + list.size());

                        healthCommentList.clear();
                        healthCommentList.addAll(list);
                        mCommentAdapter.addAll(list);
                        mCommentAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(int i, String s) {
                        Log.w("logger", "error" + s);
                    }
                });
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
