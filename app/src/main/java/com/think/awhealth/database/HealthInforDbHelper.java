package com.think.awhealth.database;

import com.litesuits.orm.db.assit.QueryBuilder;
import com.think.awhealth.App;
import com.think.awhealth.data.entity.HealthInfor;

/**
 * Created by XiuWuZhuo on 2016/1/27.
 * Emial:nimdanoob@163.com
 */
public class HealthInforDbHelper {
    public static boolean containInDb(int id){
        return App.sDb.query(new QueryBuilder<HealthInfor>(HealthInfor.class)
        .where(" id = ?",new Integer[]{id})).size() !=0?true:false;
    }
}
