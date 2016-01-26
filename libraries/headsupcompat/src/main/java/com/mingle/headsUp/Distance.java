package com.mingle.headsUp;

import android.content.Context;
import android.hardware.SensorManager;
import android.view.ViewConfiguration;

/**
 * Created by zzz40500 on 15/1/29.
 */
public class Distance {
    //摩擦力度大小的系数
    private float mFlingFriction = ViewConfiguration.getScrollFriction();
    //deceleration减速 reate力度  e为底0.78/e为底0.9幕
    private static float DECELERATION_RATE = (float) (Math.log(0.78) / Math.log(0.9));
    //弯曲 拐点
    private static final float INFLEXION = 0.35f;
    //物理系数？
    private float mPhysicalCoeff;


   public Distance(Context context){
        //160dp
        final float ppi = context.getResources().getDisplayMetrics().density * 160.0f;
        mPhysicalCoeff = SensorManager.GRAVITY_EARTH // g (m/s^2)
                * 39.37f // inch/meter
                * ppi
                * 0.84f; // look and feel tuning
    }
    public double getSplineFlingDistance(int velocity) {
        final double l = getSplineDeceleration(velocity);
        final double decelMinusOne = DECELERATION_RATE - 1.0;
        return mFlingFriction * mPhysicalCoeff * Math.exp(DECELERATION_RATE / decelMinusOne * l);
    }

    private double getSplineDeceleration(int velocity) {
        return Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * mPhysicalCoeff));
    }

    /* Returns the duration, expressed in milliseconds */
    public int getSplineFlingDuration(int velocity) {
        final double l = getSplineDeceleration(velocity);
        final double decelMinusOne = DECELERATION_RATE - 1.0;
        return (int) (1000.0 * Math.exp(l / decelMinusOne));
    }
}
