package com.think.awhealth.ui.map;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by XiuWuZhuo on 2016/2/12.
 * Emial:nimdanoob@163.com
 */
public class MyOrientationListener implements SensorEventListener{

    private SensorManager mSensorManager;
    private Context mContext;

    private Sensor mSensor;
    private float lastX;

    public MyOrientationListener(Context context) {
        mContext  = context;
    }

    /**
     * 开始鉴定传感器的数据
     *
     */
    public void start(){
            mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
            if (mSensorManager != null) {
                mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
            }
            if (mSensor != null) {
                //这里的第三个参数表示的精度，一般游戏要求比较高
                mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_UI);
            }
    }

    /**
     * 停止监听传感器。将注册器移除
     */
    public void stop(){
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if ( event.sensor.getType() == Sensor.TYPE_ORIENTATION){//如果是方向传感器的话
            float x = event.values[SensorManager.DATA_X];

            if (Math.abs(x - lastX) >1.0){
                //数值回调给监听接口
                if (mOnOrientationListener != null)
                {
                    mOnOrientationListener.onOrientationChanged(x);
                }
            }
            lastX = x;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private OnOrientationListener mOnOrientationListener;

    public void setOnOrientationListener(OnOrientationListener mOnOrientationListener) {
        this.mOnOrientationListener = mOnOrientationListener;
    }

    public interface OnOrientationListener{
        void onOrientationChanged(float x);
    }
}
