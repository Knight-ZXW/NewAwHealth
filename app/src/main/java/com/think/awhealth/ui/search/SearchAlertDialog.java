package com.think.awhealth.ui.search;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.think.awhealth.R;

/**
 * Created by XiuWuZhuo on 2016/2/11.
 * Emial:nimdanoob@163.com
 */
public class SearchAlertDialog {


    private TextView mDialogTitle;
    private EditText mDialogSearchKeyValue;
    private Button mDialogBtnPositive;
    private Context mContext;

    private AlertDialog mAlertDialog;

    public SearchAlertDialog(Context context) {
        mContext = context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View dialogView = layoutInflater.inflate(R.layout.dialog_search, null);
        mAlertDialog = new AlertDialog.Builder(mContext).create();
        mAlertDialog.setView(dialogView);
        mAlertDialog.show();
        Window window = mAlertDialog.getWindow();
        mDialogTitle = (TextView) window.findViewById(R.id.dialog_title);
        mDialogBtnPositive = (Button) window.findViewById(R.id.dialog_btn_positive);
        mDialogSearchKeyValue = (EditText) window.findViewById(R.id.dialog_search_key_value);
        //没有弹出键盘。设置一席
        InputMethodManager inputManager =
                (InputMethodManager)mDialogSearchKeyValue.getContext().
                        getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(mDialogSearchKeyValue, 0);
    }


    public AlertDialog getRealAlertDialog() {
        return mAlertDialog;
    }


    public void setDialogTitle(CharSequence title) {
        mDialogTitle.setText(title);
    }

    public void setOnPositiveBtnClickListener(View.OnClickListener listener) {
        this.mDialogBtnPositive.setOnClickListener(listener);
    }

    public String getSearchKey() {
        return mDialogSearchKeyValue.getText().toString();
    }
}
