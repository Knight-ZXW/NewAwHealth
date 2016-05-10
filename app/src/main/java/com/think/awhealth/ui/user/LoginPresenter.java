package com.think.awhealth.ui.user;

import android.content.Context;

import com.think.awhealth.bean.entity.User;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Zousfu on 2016/5/3.
 * Email:nimdanoob@163.com
 */
public class LoginPresenter implements LoginContract.Presenter {
    LoginContract.View mLoginView;
    public LoginPresenter(LoginContract.View view) {
        mLoginView = view;
    }

    @Override
    public void login(User user, Context context) {
        user.login(context, new SaveListener() {
            @Override
            public void onSuccess() {
                mLoginView.forwardToMainView();
            }

            @Override
            public void onFailure(int i, String s) {
                //todo 行为记录分析
                mLoginView.showLoginFaield(i,s);
            }
        });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
