package com.think.awhealth.ui.user;

import android.content.Context;

import com.think.awhealth.bean.entity.User;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Zousfu on 2016/5/3.
 * Email:nimdanoob@163.com
 */
public class RegisterPresenter implements RegisterContract.Presenter {
    RegisterContract.View mRegisterView;
    public RegisterPresenter(RegisterContract.View view) {
        mRegisterView = view;
    }

    @Override
    public void register(User user, Context context) {

        user.signUp(context, new SaveListener() {
            @Override
            public void onSuccess() {
                mRegisterView.registerSuccess();
            }

            @Override
            public void onFailure(int i, String s) {
                mRegisterView.registerFailed(i,s);
            }
        });
    }
}
