package com.think.awhealth.database;

import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.think.awhealth.App;
import com.think.awhealth.bean.entity.CollectedHealthInfor;
import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.bean.entity.QuestionDetail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/**
 * Created by XiuWuZhuo on 2016/1/27.
 * Emial:nimdanoob@163.com
 */
public class DbHelper {
    public static class HealthInforDb {
        public static boolean containInDb(int id) {
            return App.sDb.query(new QueryBuilder<HealthInfor>(HealthInfor.class)
                    .where(" id = ?", new Integer[]{id})).size() != 0 ? true : false;
        }

        public static boolean collectHelathInfor(HealthInfor healthInfor) {
            CollectedHealthInfor collectedHealthInfor = new CollectedHealthInfor();
            collectedHealthInfor.id = healthInfor.getId();
            collectedHealthInfor.healthInfor = healthInfor;
            long save = App.sDb.save(collectedHealthInfor);
            return save > 0;
        }

        public static boolean unCollectedHealthInfor(int healthInforId) {
            int delete = App.sDb.delete(
                    WhereBuilder.create
                            (CollectedHealthInfor.class,
                                    HealthInfor.COL_ID + " = ?",
                                    new Object[]{healthInforId}));
            return delete > 0;
        }

        public static boolean isCollected(int healthInforId) {
            CollectedHealthInfor collectedHealthInfor = App.sDb.queryById(healthInforId, CollectedHealthInfor.class);
            return collectedHealthInfor != null;
        }

        /**
         * 获得所有收藏的HealthInfor
         *
         * @return
         */
        public static List<HealthInfor> getAllCollectedHealth() {
            ArrayList<CollectedHealthInfor> collecteHealthInfors = App.sDb.query(CollectedHealthInfor.class);
            ArrayList<HealthInfor> healthInfors = new ArrayList<>();
            for (CollectedHealthInfor collectedHealthInfor : collecteHealthInfors) {
                healthInfors.add(collectedHealthInfor.healthInfor);
            }
            return healthInfors;
        }

    }

    public static class QuestionDetailDb {
        public static boolean containInDb(int id) {
            return App.sDb.query(new QueryBuilder<QuestionDetail>(QuestionDetail.class)
                    .where(QuestionDetail.COL_ID + " = ?", new Integer[]{id})).size() != 0 ? true : false;
        }

    }

}
