package com.think.awhealth.data.entity;

import java.io.Serializable;

/**
 * Created by XiuWuZhuo on 2016/2/12.
 * Emial:nimdanoob@163.com
 */
public class Hospital implements Serializable {


    private static final long serialVersionUID = -8571961446422914047L;
    private String name ;   //      医院名称
    private String img ;   //      医院展示效果图  医院LOGO
    private Long area;     //区域
    private String address     ;   //     地址
    private Float x     ;   //       地图x
    private Float y         ;   //       地图y
    private String tel     ;   //      电话
    private String fax     ;   //       传真
    private String zipcode     ;   //       邮编
    private String url     ;   //       网站URL
    private String mail     ;   //      医院邮箱
    private String gobus     ;   //     坐车方式
    private String level     ;   //      医院等级
    private String nature     ;   //       经营性质
    private String mtype ;   //      医保类型
    private String message     ;   //     医院介绍
    private int  count     ;   //     访问量
    private int  rcount     ;
    private int  fcount     ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGobus() {
        return gobus;
    }

    public void setGobus(String gobus) {
        this.gobus = gobus;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", area=" + area +
                ", address='" + address + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", tel='" + tel + '\'' +
                ", fax='" + fax + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", url='" + url + '\'' +
                ", mail='" + mail + '\'' +
                ", gobus='" + gobus + '\'' +
                ", level='" + level + '\'' +
                ", nature='" + nature + '\'' +
                ", mtype='" + mtype + '\'' +
                ", message='" + message + '\'' +
                ", count=" + count +
                ", rcount=" + rcount +
                ", fcount=" + fcount +
                '}';
    }
}

