package com.think.awhealth.ui.base;

import android.app.ProgressDialog;

/**
 * Created by XiuWuZhuo on 2016/2/12.
 * Emial:nimdanoob@163.com
 */
public abstract class BaseToolBarAndNetWorkActivity extends ToolBarActivity{
    protected ProgressDialog mProgressDialog;

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
}
