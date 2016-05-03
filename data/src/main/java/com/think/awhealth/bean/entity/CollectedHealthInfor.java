package com.think.awhealth.bean.entity;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Mapping;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;
import com.litesuits.orm.db.enums.Relation;

/**
 * Created by Zousfu on 2016/5/1.
 * Email:nimdanoob@163.com
 */
@Table("CollectedHealthInfor")
public class CollectedHealthInfor {
    @Column(HealthInfor.COL_ID)
    @PrimaryKey(AssignType.BY_MYSELF)
    public int id;

    @Mapping(Relation.OneToOne)
    public HealthInfor healthInfor;
}
