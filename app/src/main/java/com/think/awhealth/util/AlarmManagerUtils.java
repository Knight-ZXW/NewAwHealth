package com.think.awhealth.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.think.awhealth.service.AlarmReceiver;

import java.util.Calendar;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class AlarmManagerUtils {
    public static final int REQUEST_CODE = 520;
    public static void register(Context context){
        Calendar today = Calendar.getInstance();
        Calendar now = Calendar.getInstance();

        today.set(Calendar.HOUR_OF_DAY,12);
        today.set(Calendar.MINUTE,0);
        today.set(Calendar.SECOND, 0);

        if (now.after(today)){
            return;
        }
        Intent intent = new Intent("com.think.awhealth.alarm");
        intent.setClass(context, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(context,REQUEST_CODE,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        manager.set(AlarmManager.RTC_WAKEUP,today.getTimeInMillis(),broadcast);
    }
}
