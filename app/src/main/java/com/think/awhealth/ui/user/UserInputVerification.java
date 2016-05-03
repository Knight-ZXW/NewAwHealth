package com.think.awhealth.ui.user;

import android.text.TextUtils;

/**
 * Created by Zousfu on 2016/5/3.
 * Email:nimdanoob@163.com
 */
public class UserInputVerification {
    public static boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    public static boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return !TextUtils.isEmpty(password)&&password.length() > 4;
    }
}
