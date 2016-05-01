package com.think.awhealth.ui.healthInfor;

import com.think.awhealth.base.BaseLceView;
import com.think.awhealth.base.BasePresenter;
import com.think.awhealth.base.BaseView;
import com.think.awhealth.bean.entity.HealthInfor;

import java.util.List;

/**
 * Created by Zousfu on 2016/5/1.
 * Email:nimdanoob@163.com
 */
public interface HealthInforContract {
    interface View extends BaseLceView<Presenter> {
        void additionMoreHealthInforView(List<HealthInfor> healthInfors);
    }

    interface Presenter extends BasePresenter{

        void loadHealthInfors(int classId, int page);
    }
}
