package com.think.awhealth.ui.user;

/**
 * Created by Zousfu on 2016/5/3.
 * Email:nimdanoob@163.com
 */
public class UserMessageIdHelp {
    public static  String caseId(int id){
        String message ="";
        switch (id) {
            case 202:
                message = "该用户名已被注册";
                break;
        }
        return message;
    }
}
