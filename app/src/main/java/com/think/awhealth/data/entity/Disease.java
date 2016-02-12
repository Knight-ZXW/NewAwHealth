package com.think.awhealth.data.entity;

/**
 * Created by XiuWuZhuo on 2016/2/12.
 * Emial:nimdanoob@163.com
 */
public class Disease {
    private String name;//疾病名称
    private String img;//图片
    private String department;//疾病科室
    private String place;//疾病部位
    private String message;//简介，摘要
    private String keywords;
    private String description;
    private String symptomtext;//病状描述
    private String symptom;//相关症状
    private String drug;//相关药品
    private String drugtext;//用药说明
    private String food;//相关食品
    private String foodtext;//健康保健
    private String causetext;//病因
    private String checks;//检测项目
    private String checktext;//检测说明
    private String disease;//并发疾病
    private String diseasetext;//并发症状说明
    private String caretext;//预防护理
    private int count;
    private int rcount;//回复
    private int fcount;//收藏

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymptomtext() {
        return symptomtext;
    }

    public void setSymptomtext(String symptomtext) {
        this.symptomtext = symptomtext;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getDrugtext() {
        return drugtext;
    }

    public void setDrugtext(String drugtext) {
        this.drugtext = drugtext;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFoodtext() {
        return foodtext;
    }

    public void setFoodtext(String foodtext) {
        this.foodtext = foodtext;
    }

    public String getCausetext() {
        return causetext;
    }

    public void setCausetext(String causetext) {
        this.causetext = causetext;
    }

    public String getChecks() {
        return checks;
    }

    public void setChecks(String checks) {
        this.checks = checks;
    }

    public String getChecktext() {
        return checktext;
    }

    public void setChecktext(String checktext) {
        this.checktext = checktext;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDiseasetext() {
        return diseasetext;
    }

    public void setDiseasetext(String diseasetext) {
        this.diseasetext = diseasetext;
    }

    public String getCaretext() {
        return caretext;
    }

    public void setCaretext(String caretext) {
        this.caretext = caretext;
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
}
