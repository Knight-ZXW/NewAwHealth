package com.think.awhealth.ui.user;

import android.content.Context;

import com.think.awhealth.base.BasePresenter;
import com.think.awhealth.base.BaseView;
import com.think.awhealth.bean.entity.User;

import rx.Observable;

/**
 * Created by Zousfu on 2016/5/3.
 * Email:nimdanoob@163.com
 */
public interface LoginContract {
    interface View extends BaseView<Presenter>{
        void forwardToMainView();
        void forwardToRegister();
        void showLoginFaield(int meesageId, String message);
    }
    interface Presenter extends BasePresenter{
        void login(User user, Context context);
    }
}
