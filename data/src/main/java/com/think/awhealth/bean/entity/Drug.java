package com.think.awhealth.bean.entity;

/**
 * Created by XiuWuZhuo on 2016/2/11.
 * Emial:nimdanoob@163.com
 */
public class  Drug  {

    /**
     * count : 0
     * description : 功能主治 润肠通便。用于病后津液不足，肝火内炽，便秘腹胀。
     * fcount : 0
     * id : 1196
     * img : http://tnfs.tngou.net/img/drug/081018/380e43ecf71e08cfb820fe71a149f143.jpg
     * keywords : 收起 展开 上海市 生产 口服
     * message : 【药品名称】   通用名称：更衣胶囊   【成份】   芦荟280g，朱砂200g。  【性状】    本品为胶囊剂，内容物为赭红色粉末；味苦。   【功能主治】  润肠通便。用于病后津液不足，肝火内炽，便秘腹胀。 [展开] 润肠通便。用于病后津液不足，肝火内炽，便秘腹胀。 [收起]  【规格】   50粒/瓶   【用法用量】  口服。一次 3～6 粒，一日 1～2次，饭前服。 [展开] 口服。一次 3～6 粒，一日 1～2次，饭前服。 [收起]  【不良反应】  尚不明确。 [展开] 尚不明确。 [收起]  【禁忌】  孕妇忌服。 [展开]  孕妇忌服。  [收起]  【注意事项】  请遵医嘱。 [展开] 请遵医嘱。  [收起]  【贮藏】     密闭，在凉暗干燥处保存。    【包装】    50粒/瓶      【批准文号】    国药准字Z20033077   【批准日期】    2010-9-27 0:00:00   【生产企业】   企业名称：上海雷允上药业有限公司  生产地址：上海市汉口路398号华盛大厦十七楼   联系电话：021-63503535 如有问题可与生产企业联系  【产地】
     * name : 更衣胶囊
     * price : 271
     * rcount : 0
     * tag : 便秘
     * type : 中成药
     */

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

    @Override
    public String toString() {
        return "Drug{" +
                "count=" + count +
                ", description='" + description + '\'' +
                ", fcount=" + fcount +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", keywords='" + keywords + '\'' +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rcount=" + rcount +
                ", tag='" + tag + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
