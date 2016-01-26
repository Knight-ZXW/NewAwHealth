package com.think.awhealth.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;

import com.mingle.headsUp.HeadsUp;
import com.mingle.headsUp.HeadsUpManager;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class HeadsUpUtils {
    public static void show(Context context, Class targetActivity,
                            String title, String content, int largeIcon, int smallIcon, int code) {
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                11,
                new Intent(context, targetActivity),
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        HeadsUpManager manager = HeadsUpManager.getInstant(context);
        HeadsUp.Builder builder = new HeadsUp.Builder(context);
        builder.setContentTitle(title)
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                .setContentIntent(pendingIntent)
                .setFullScreenIntent(pendingIntent, false)
                .setAutoCancel(true)
                .setContentText(content);
        if (Build.VERSION.SDK_INT >= 21){
            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),largeIcon))
                    .setSmallIcon(smallIcon);
        } else {
            builder.setSmallIcon(largeIcon);
        }

        HeadsUp headsUp = builder.buildHeadUp();
        headsUp.setSticky(true);
        manager.notify(code,headsUp);

    }
}
