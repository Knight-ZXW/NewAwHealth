package com.think.awhealth.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.think.awhealth.R;

/**
 * Created by XiuWuZhuo on 2016/2/11.
 * Emial:nimdanoob@163.com
 */
public abstract class BaseListActivity extends ToolBarActivity{

    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected RecyclerView.Adapter mAdapter;

    protected ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
        mLayoutManager = provideLayoutManager();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = provideAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    protected void showProgressDialog(){
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            ProgressDialog progressDialog = mProgressDialog;
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        mProgressDialog.show();
    }

    protected void hideProgressDialog(){
        if (mProgressDialog!=null && mProgressDialog.isShowing()){
            mProgressDialog.hide();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止窗口句柄泄露
        if (mProgressDialog!=null){
            mProgressDialog.dismiss();
        }
    }

    protected abstract RecyclerView.Adapter provideAdapter();

    protected abstract RecyclerView.LayoutManager provideLayoutManager();
}
