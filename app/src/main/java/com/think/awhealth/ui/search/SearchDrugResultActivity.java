package com.think.awhealth.ui.search;

import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.think.awhealth.R;
import com.think.awhealth.api.AwFactory;
import com.think.awhealth.data.entity.Drug;
import com.think.awhealth.ui.adapter.RecyclerSearchAdapter;
import com.think.awhealth.ui.base.BaseListActivity;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchDrugResultActivity extends BaseListActivity {

    private String mDrugKey;
    private List<Drug> mDrugDatas;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_search_result_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDrugKey = getIntent().getStringExtra("name");
        initVariables();
        showProgressDialog();
        loadData();
    }


    private void initVariables() {
        ((RecyclerSearchAdapter)mAdapter).setOnItemClickListener(new RecyclerSearchAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Drug drug = mDrugDatas.get(position);
                showDetailWindow(mRecyclerView,drug);
            }
        });
    }

    protected void loadData() {
        if (mDrugKey == null) {
            mDrugKey = "";
        }
        getCompositeSubscription().add(AwFactory.getSingleTinaGouApi().getDrugData(mDrugKey, "name,message")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(drugSearchData -> {
                    Log.w("logger","刷新得到数据"+drugSearchData.toString()+drugSearchData.getDrugs());
                    mDrugDatas.clear();
                    mDrugDatas.addAll(drugSearchData.getDrugs());
                    if (mDrugDatas.size() == 0){
                        Toast.makeText(this,"没有得到结果，也许你可以尝试搜索其他类别",Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    } else {
                        Toast.makeText(this, "得到" + mDrugDatas.size() + "条结果", Toast.LENGTH_SHORT).show();
                    }
                        mAdapter.notifyDataSetChanged();

                    hideProgressDialog();
                }, throwable -> {
                    hideProgressDialog();
                    Log.w("logger",throwable);
                    showError(throwable);
                }));

    }

    @Override
    protected RecyclerView.Adapter provideAdapter() {
        mDrugDatas = new ArrayList<>();
        RecyclerSearchAdapter recyclerSearchAdapter = new RecyclerSearchAdapter(mDrugDatas);
        return recyclerSearchAdapter;
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected boolean canBack() {
        return true;
    }

    public void showDetailWindow(View view, Drug drug){
        LayoutInflater layoutInflater = LayoutInflater.from(view.getContext());
        setWindowAlpha(0.4f);
        View contentView = layoutInflater.inflate(R.layout.view_drug_detail, null);
        PopupWindow popupWindow = new PopupWindow(contentView, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(view, Gravity.CENTER,20,20);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.setElevation(20f);
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setWindowAlpha(1f);
            }
        });

        //设置contentView的显示内容
//        contentView.findViewById()
        TextView tvTitle= (TextView)contentView.findViewById(R.id.id_item_title);
        SimpleDraweeView drugimage = (SimpleDraweeView) contentView.findViewById(R.id.id_item_image);
        TextView tvDescription= (TextView)contentView.findViewById(R.id.id_item_description);
        TextView tvStyle= (TextView)contentView.findViewById(R.id.id_item_style);
        //详情
        TextView tvMessage= (TextView)contentView.findViewById(R.id.id_item_message);

        tvTitle.setText(drug.getName());
        tvDescription.setText(drug.getDescription());
        tvStyle.setText(drug.getType());
        tvMessage.setText(drug.getMessage());
        drugimage.setImageURI(Uri.parse(drug.getImg()));
    }

    public void setWindowAlpha(float alpha) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = alpha;
        getWindow().setAttributes(attributes);
    }
}
