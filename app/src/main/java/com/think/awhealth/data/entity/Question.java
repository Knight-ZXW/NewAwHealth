package com.think.awhealth.data.entity;

/**
 * Created by XiuWuZhuo on 2016/2/13.
 * Emial:nimdanoob@163.com
 */
public class Question {

    /**
     * askclass : 2
     * count : 785
     * description : 爱美的人士喜欢照镜子，这是能够理解的行为，因为仪容对于一个人的外在是非常重要，但是如果你属于那类频繁照镜子而且又无法忍受自己的缺点那么你就需要小心了
     * fcount : 0
     * id : 2966
     * img : /ask/default.jpg
     * keywords : 自己 照镜子 很多人 综合症 而且
     * rcount : 0
     * time : 1438401974000
     * title : 频繁照镜子也是一种病吗？
     */

    private int askclass;
    private int count;
    private String description;
    private int fcount;
    private int id;
    private String img;
    private String keywords;
    private int rcount;
    private long time;
    private String title;

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

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getRcount() {
        return rcount;
    }

    public long getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }
}
