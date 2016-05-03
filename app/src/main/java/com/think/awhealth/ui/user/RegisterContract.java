package com.think.awhealth.ui.user;

import android.content.Context;

import com.think.awhealth.base.BaseView;
import com.think.awhealth.bean.entity.User;

/**
 * Created by Zousfu on 2016/5/3.
 * Email:nimdanoob@163.com
 */
public interface RegisterContract {
    interface View extends BaseView<Presenter>{
        public void registerFailed(int meesageId,String message);
        void forwardToMainActivity();
        void registerSuccess();
    }
    interface Presenter {
        void register(User user, Context context);
    }
}
