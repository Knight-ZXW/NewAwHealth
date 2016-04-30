package com.think.awhealth.bean.entity;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;

/**
 * Created by XiuWuZhuo on 2016/2/13.
 * Emial:nimdanoob@163.com
 */
@Table("QuestionDetail")public class QuestionDetail {

    /**
     * askclass : 1
     * count : 156
     * description : ”英国性爱专家邦尼·雅各布森博士在其书中指出，性爱前1~2天应至少安排两次浪漫接触机会，爱人间送个小礼物、一起看个浪漫电影，或者在工作间隙发个调情短信，这些举动都会增加对性爱的期待，尤其可以让女性更快进入状态
     * fcount : 0
     * id : 10
     * img : /ask/150801/a5b999a5822448e0d3e3b42862fd98b1.jpg
     * keywords : 性爱 标准 完美 如果 没有
     * message : 分享： 腾讯微博 QQ空间 腾讯QQ 新浪微博 | 收藏
     * rcount : 0
     * status : true
     * time : 1438394028000
     * title : 完美爱爱的黄金标准有哪些？
     * url : http://www.tngou.net/ask/show/10
     */

    private int askclass;
    private int count;
    private String description;
    private int fcount;
    @NotNull
    @Unique
    @Column("id")
    private int id;
    private String img;
    private String keywords;
    private String message;
    private int rcount;
    private boolean status;
    private long time;
    private String title;
    private String url;

    public void setAskclass(int askclass) {
        this.askclass = askclass;
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

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAskclass() {
        return askclass;
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

    public String getKeywords() {
        return keywords;
    }

    public String getMessage() {
        return message;
    }

    public int getRcount() {
        return rcount;
    }

    public boolean isStatus() {
        return status;
    }

    public long getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
