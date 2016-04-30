package com.think.awhealth.bean.entity;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;

/**
 * Created by XiuWuZhuo on 2016/1/24.
 * Emial:nimdanoob@163.com
 */
@Table("healthInfors")public class HealthInfor extends Soul{

    /**
     * count : 59
     * description : 北京市卫生计生委借“互联网+”拓展健康服务网 举措：2014年底，受国家卫生计生委委托，北京市开始研究北京地区的医师电子注册，经过2015年在朝阳区卫生计生委和部分医疗服务机构的试点，现已初步建立在京医师执业信息的电子化注册系统，梳理出在京医生的执业状况分布，并着手为每一位执业医师建立完善的职业信息档案
     * fcount : 0
     * id : 6307
     * img : /info/160122/3b160073a31cc31699c5178726028950.jpg
     * infoclass : 2
     * keywords : 北京市 医院 执业 医疗 北京
     * rcount : 0
     * time : 1453422259000
     * title : 北京市卫生计生委也在铺设一张互联网
     */

    private int count;
    private String description;
    private int fcount;
    @NotNull
    @Unique
    @Column("id")private int id;
    private String img;
    private int infoclass;
    private String keywords;
    private int rcount;
    private long time;
    private String title;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setInfoclass(int infoclass) {
        this.infoclass = infoclass;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }

    public int getFcount() {
        return fcount;
    }

    public int getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public int getInfoclass() {
        return infoclass;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getRcount() {
        return rcount;
    }

    public long getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "HealthInfor{" +
                "count=" + count +
                ", description='" + description + '\'' +
                ", fcount=" + fcount +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", infoclass=" + infoclass +
                ", keywords='" + keywords + '\'' +
                ", rcount=" + rcount +
                ", time=" + time +
                ", title='" + title + '\'' +
                '}';
    }


}
