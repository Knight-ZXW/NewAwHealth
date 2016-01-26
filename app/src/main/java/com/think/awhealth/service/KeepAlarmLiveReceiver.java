package com.think.awhealth.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.think.awhealth.util.AlarmManagerUtils;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class KeepAlarmLiveReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && Intent.ACTION_USER_PRESENT.equals(intent)){
            AlarmManagerUtils.register(context);
        }
    }
}
