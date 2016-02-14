package com.think.awhealth.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.think.awhealth.MainActivity;
import com.think.awhealth.R;
import com.think.awhealth.util.HeadsUpUtils;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class AlarmReceiver extends BroadcastReceiver{
    private final int NOTIFY_CODE = 123123;
    @Override
    public void onReceive(Context context, Intent intent) {
        //todo 如何配置的需要通知
        HeadsUpUtils.show(context, MainActivity.class,
                context.getString(R.string.headsup_titile),
                context.getString(R.string.headsup_content),
                R.mipmap.ic_notify,
                R.mipmap.ic_female,NOTIFY_CODE);
    }
}
