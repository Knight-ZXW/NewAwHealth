package com.think.awhealth.database;

import com.litesuits.orm.db.assit.QueryBuilder;
import com.think.awhealth.App;
import com.think.awhealth.bean.entity.HealthInfor;

/**
 * Created by XiuWuZhuo on 2016/1/27.
 * Emial:nimdanoob@163.com
 */
public class DbHelper {
    public static boolean containInDb(Class clazz,int id){
        return App.sDb.query(new QueryBuilder<HealthInfor>(clazz)
        .where(" id = ?",new Integer[]{id})).size() !=0?true:false;
    }
}
