package com.think.awhealth.bean;

import com.google.gson.annotations.SerializedName;
import com.think.awhealth.bean.entity.Drug;

import java.util.List;

/**
 * Created by XiuWuZhuo on 2016/2/11.
 * Emial:nimdanoob@163.com
 */
public class DrugSearchData extends BaseData{


    private int total;

    @SerializedName("tngou")
    private List<Drug> mDrugs;


    public void setTotal(int total) {
        this.total = total;
    }

    public void setTngou(List<Drug> tngou) {
        this.mDrugs = tngou;
    }


    public int getTotal() {
        return total;
    }

    public List<Drug> getDrugs() {
        return mDrugs;
    }

    public static class TngouEntity {
        private int count;
        private String description;
        private int fcount;
        private int id;
        private String img;
        private String keywords;
        private String message;
        private String name;
        private int price;
        private int rcount;
        private String tag;
        private String type;

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

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setType(String type) {
            this.type = type;
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

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public int getRcount() {
            return rcount;
        }

        public String getTag() {
            return tag;
        }

        public String getType() {
            return type;
        }
    }

    @Override
    public String toString() {
        return "DrugSearchData{" +
                "status=" + status +
                ", total=" + total +
                ", mDrugs=" + mDrugs +
                '}';
    }
}
