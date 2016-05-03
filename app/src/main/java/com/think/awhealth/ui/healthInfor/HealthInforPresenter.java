package com.think.awhealth.ui.healthInfor;

import android.util.Log;

import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.model.repository.HealthInforRepository;
import com.think.awhealth.result.Result;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Zousfu on 2016/5/1.
 * Email:nimdanoob@163.com
 */
public class HealthInforPresenter implements HealthInforContract.Presenter {
    int mClassId;
    //业务逻辑比较简单 直接通过Model来操作，负责的界面应该在抽象出一层doMain
    HealthInforRepository mHealthInforRepository;
    private final HealthInforContract.View mHealthNewsView;
    public HealthInforPresenter(int classId, HealthInforRepository healthInforRepository,
                                 HealthInforContract.View view) {
        this.mClassId = classId;
        this.mHealthInforRepository = healthInforRepository;
        this.mHealthNewsView = view;
    }

    @Override
    public void subscribe() {
        Log.w("zxw","subscribe so load");
        loadHealthInfors(mClassId,1);
    }

    @Override
    public void unSubscribe() {

    }
    @Override
    public void loadHealthInfors(int classId, int page) {
        mHealthNewsView.showLoading(true);
        mHealthInforRepository.getHealthInforsByClassId(mClassId,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result<List<HealthInfor>>>() {
                    @Override
                    public void onCompleted() {
                        Log.w("zxw","完成了");
                        mHealthNewsView.showLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.w("zxw","出错了"+e.getMessage());
                    }

                    @Override
                    public void onNext(Result<List<HealthInfor>> listResult) {
                        Log.w("zxw","listResult"+listResult);
                        mHealthNewsView.additionMoreHealthInforView(listResult.getData());
                    }
                });
    }


}
