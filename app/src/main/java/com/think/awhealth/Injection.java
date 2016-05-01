package com.think.awhealth;

/**
 * Created by Zousfu on 2016/5/1.
 * Email:nimdanoob@163.com
 */

import android.content.Context;
import android.support.annotation.NonNull;

import com.think.awhealth.model.healthInfo.HealthInforRepository;
import com.think.awhealth.model.impl.local.HealthInforLocalDataSource;
import com.think.awhealth.model.impl.remote.HealthInforRemoteDataSource;

import static com.think.awhealth.util.Preconditions.checkNotNull;
/**
 * 提供全局的获取所需对象的Injection
 * 有时间的话可用用dagger2 来替换
 */
public class Injection {
    public static HealthInforRepository provideHealthRepository(@NonNull Context context){
        checkNotNull(context);
        return HealthInforRepository.getInstance(HealthInforLocalDataSource.getINSTANCE(), HealthInforRemoteDataSource.getINSTANCE());
    }
}
