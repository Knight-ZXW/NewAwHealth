package com.think.awhealth.bean;

import com.google.gson.annotations.SerializedName;
import com.think.awhealth.bean.entity.HealthInfor;

import java.util.List;

/**
 * Created by XiuWuZhuo on 2016/1/24.
 * Emial:nimdanoob@163.com
 */
public class HealthInforData{
    /**
     * status : true
     * total : 694
     * tngou : [{"count":185,"description":"公司在蓝色膏药发明人李志耿董事长带领下，以\u201c引领新航向树立新坐标\u201d为发展理念，致力于成为中原乃至全国医药保健行业的\u201c新坐标\u201d","fcount":0,"id":1811,"img":"/info/150729/3a221908985cbbdd5717947254414ab3.jpg","infoclass":1,"keywords":"蓝色 膏药 坐标 有限公司 公司 ","rcount":0,"time":1438146618000,"title":"新坐标药业集团股份有限公司膏药市场的一匹悍马"},{"count":179,"description":"除专设的药品研发机构外，公司拥有非常优秀的产品策划、质量管理和市场运作团队；有专业的推广队伍，全部拥有药学大专以上学历或多年工作经验；有专业的投标人员，致力于全国各地招标工作的研究，分析和投标；有较高专业水平的品牌营养专家及顾问，通过与国内药品研究机构合作，持续开发各类新品种和独家新品种","fcount":0,"id":1810,"img":"/info/150729/5a3451e16f9118f2beb4126641200ea9.jpg","infoclass":1,"keywords":"公司 有限公司 经营 品牌 东方 ","rcount":0,"time":1438146610000,"title":"武汉东方圣龙医药有限公司坚定不移走品牌路线"},{"count":174,"description":"盛杰奥品牌营销中心系列产品只操作终端渠道，在全国终端品牌中创先采用最新工艺的包装材质，使系列产品的外包装形象在同类产品中脱颖而出，迅速占领中断柜台，抓住消费者的眼球","fcount":0,"id":1809,"img":"/info/default.jpg","infoclass":1,"keywords":"品牌 公司 营销中心 医药企业 市场 ","rcount":0,"time":1438146609000,"title":"盛杰奥品牌营销中心让药企百花齐失色"},{"count":170,"description":"坚持以产品质量打天下，保证产品质量的同时也给企业树立了良好的品牌形象，让企业在这个医药混乱的今天得意健康的生存下来","fcount":0,"id":1808,"img":"/info/150729/8eb982447dcba8e05009b36bc495ddc1.jpg","infoclass":1,"keywords":"公司 产品质量 有限责任 药业 企业 ","rcount":0,"time":1438146608000,"title":"洛阳天生药业有限责任公司用药品质量打天下"},{"count":157,"description":"公司始终秉承\u201c笑迎九州客，真心铸市场\u201d的企业理念，通过多年的专营，现已形成了以湖北临床市场为根基的临床部，以上海信谊品牌产品为主体的信谊产品部，以OTC终端全科需求为宗旨的OTC事业部，在2011年为适应全国医改的步伐及基药销售的大形势特成立了以全国基药销售为主的基药部","fcount":0,"id":1807,"img":"/info/150729/99829f817a0c8c54244528905a6678f7.jpg","infoclass":1,"keywords":"公司 市场 销售 全国 湖北 ","rcount":0,"time":1438146607000,"title":"武汉九真世纪医药有限公司令众多药企暗淡无光"},{"count":158,"description":"武汉同济康达药品有限公司将一如既往地坚持\u201c高质量、低价格、广覆盖、优服务\u201d的经营理念，\u201c质量为核心，健康送万家\u201d的质量方针，立足武汉，面向湖北，努力打造并成长为具有现代化营销水平和高度文化内涵的大型医药批发流通企业","fcount":0,"id":1806,"img":"/info/150729/d219a38745bc09622c08609f0cad587f.jpg","infoclass":1,"keywords":"有限公司 武汉 同济 药品 企业 ","rcount":0,"time":1438146606000,"title":"武汉同济康达药品有限公司把良药送达千万家"},{"count":145,"description":"江西永丰苗家堂生物科技有限公司目前已经建立起\u201c产、销、研\u201d一体的发展流程，良好的物流陪送网络，努力成为对消费者、客户、同行、商业伙伴和社会有价值的公司，为人们的健康发展做出更大的贡献","fcount":0,"id":1805,"img":"/info/150729/201d81cb477c433e2188ecc1dcb34d07.jpg","infoclass":1,"keywords":"生物科技 有限公司 公司 企业 江西 ","rcount":0,"time":1438146605000,"title":"江西永丰苗家堂生物科技有限公司备受业内瞩目"},{"count":143,"description":"公司拥有一流的化工专家及执业药师，拥有先进的生产工艺及设备","fcount":0,"id":1804,"img":"/info/150729/7deeaa70ca9f241cb13310d460ce2d44.jpg","infoclass":1,"keywords":"公司 拥有 产品 医药企业 生物科技 ","rcount":0,"time":1438146603000,"title":"江西岐黄生物科技有限公司以崭新形象迎发展"},{"count":102,"description":"迄今为止，武汉东方圣龙医药有限公司已成功运作以B18赖氨肌醇维B12口服溶液、B18多维铁口服溶液、B18赖氨葡锌颗粒为核心产品的B18儿科系列等多个品牌，临床亦有丰富的专业产品和院线资源，年销售额达五千余万元","fcount":0,"id":1803,"img":"/info/150729/a3478602e9369d637b540a8141aa28f0.jpg","infoclass":1,"keywords":"有限公司 品牌 我们 医药企业 公司 ","rcount":0,"time":1438146601000,"title":"武汉东方圣龙医药有限公司患者第一　客户至上"},{"count":112,"description":"河南永安医药有限公司成立于1999年，公司前身为郑州市医药供应公司永安街批发部，因国有企业改制于1999年9月24日并入郑州市恒源医药有限责任公司，更名为郑州市恒源医药有限公司永安分公司，后又随总公司更名为郑州三九恒源医药有限公司永安分公司，郑州恒源医药有限公司永安分公司","fcount":0,"id":1802,"img":"/info/default.jpg","infoclass":1,"keywords":"有限公司 医药 永安 公司 河南 ","rcount":0,"time":1438146589000,"title":"河南永安医药有限公司创十年利剑"},{"count":102,"description":"天光药业在发展中结合国内及国际医药市场趋势，不断完善和规范经营管理的各个环节，保证了公司的良性运作，在国内市场形成了东北、西北、西南、华北、华东、华中、华南、华西的成熟销售网络，产品遍布全国二十多个省市、自治区、直辖市","fcount":0,"id":1801,"img":"/info/150729/0fdefb1d3bc96747b655b29a2aea42ff.jpg","infoclass":1,"keywords":"有限公司 天光 药业 医药 吉林省 ","rcount":0,"time":1438146588000,"title":"吉林省天光药业有限公司肩扛社会殷切重托"},{"count":92,"description":"深圳市金安堂生物科技有限公司成立于2008年，是一家具有尖端研发能力和一流现代化经营管理水平的生物高科技企业，为全国多个区域代理商和连锁药店提供优质的产品服务和售后支持；公司为客户提供品质卓越的产品及服务，力求满足客户的需求，并以追求客户满意为服务宗旨","fcount":0,"id":1800,"img":"/info/150729/c373fe8ef1d4427abfcdb2afdcfe9dda.jpg","infoclass":1,"keywords":"生物科技 有限公司 公司 发展 客户 ","rcount":0,"time":1438146583000,"title":"深圳金安堂生物科技有限公司以高品质为目的"},{"count":57,"description":"通过高起点谋划、高标准控制、低成本扩张、低成本运营，使公司成为在国内具有较强竞争实力，在消费者和供货商中成为较高知名度和信誉度的年销售额超过20亿元的大型医药批发企业集团","fcount":0,"id":1799,"img":"/info/150729/3714c7269a3854e7de3a9ffa02f7fb15.jpg","infoclass":1,"keywords":"有限公司 河南省 药业 大禹 批发 ","rcount":0,"time":1438146573000,"title":"河南省大禹药业有限公司缜密治业　厚德待人"},{"count":60,"description":"重视科技投入，视质量为生命，开展药材GAP基地、指纹图谱质量检测、药材CO2超临界萃取等技术研究，其中\u201c指纹图谱质量检测研究及其药材GAP示范基地建设\u201d荣获广州市科学技术进步二等奖","fcount":0,"id":1798,"img":"/info/150729/6582dda2d53d423f76b872f6f81e5e19.jpg","infoclass":1,"keywords":"股份有限公司 企业 广州 中药 中成药 ","rcount":0,"time":1438146572000,"title":"广州白云山敬修堂药业股份有限公司在药界久享盛誉"},{"count":58,"description":"公司自成立以来，就由一批诚信、实干、奋发向上的青年医药才干组成的高素质业务队伍，本着立足珠海、面向全国的战略思想，围绕以市场为导向，以客户为中心，广拓渠道，厚积资源，诚交朋友，共享利益的经营理念","fcount":0,"id":1797,"img":"/info/150729/832f9009a75f7d87dd54d5e16f377d76.jpg","infoclass":1,"keywords":"公司 有限公司 药品 企业 不断提高 ","rcount":0,"time":1438146571000,"title":"珠海安宝健药业有限公司承载文化的熏陶"},{"count":53,"description":"长春宝华医药有限公司利用自身优势营销平台，积极选择国内其它药品生产企业的优秀品种，建立了完善的产品代理销售体系，和众多企业建立了良好的代理合作关系","fcount":0,"id":1796,"img":"/info/150729/3addd1739dd229c7b3196c121bc03690.jpg","infoclass":1,"keywords":"医药 有限公司 企业 药品 产品 ","rcount":0,"time":1438146570000,"title":"长春宝华医药有限公司为强盛奋斗牢牢挂钩"},{"count":60,"description":"人尽其能，能尽其用，是制药厂的用人理念；把提高员工素质和竞争意识作为企业发展的关键，建立健全各项管理规章制度，发扬\u201c团结、求实、奋进、创新\u201d的企业精神，弘扬\u201c诚、信、廉、敏、勤\u201d的企业文化，改革创新，开拓进取","fcount":0,"id":1795,"img":"/info/150729/440a158640bc0cc1a486d2f36891e173.jpg","infoclass":1,"keywords":"中医学院 制药厂 企业 陕西 经营 ","rcount":0,"time":1438146569000,"title":"陕西中医学院制药厂人尽其能　能尽其用"},{"count":52,"description":"湖北东明医药（集团）有限公司是在武汉东明药房连锁有限公司发展十多年的基础上成立的以经营中药材、中成药、化学药制剂、抗生素制剂、生化药品、生物制品、保健食品、医疗器械等为主的大型医药批发及零售连锁型集团公司，公司总部坐落于风景别致、素有武汉后花园之称的台商经济开发区\u2014\u2014吴家山经济开发区内，注册资金壹仟万元","fcount":0,"id":1794,"img":"/info/150729/c183183bd4ab33997f1ca53db79768e0.jpg","infoclass":1,"keywords":"有限公司 东明 武汉 连锁 公司 ","rcount":0,"time":1438146567000,"title":"历史发展轨迹赋予湖北东明医药有限公司使命"},{"count":56,"description":"公司目前正在加紧推进三年规划战略，强力推进绩效考核体系和制度管理体系建设，目前已经建立起\u201c产、销、\u201d一体的发展流程，良好的物流配送网络，努力成为对消费者、客户、同行、商业伙伴和社会有价值的公司，为人们的健康发展做出更大的贡献","fcount":0,"id":1793,"img":"/info/150729/505c12a69ba0f9a6677fde373d2dcb4a.jpg","infoclass":1,"keywords":"公司 医药企业 生物科技 有限公司 江西 ","rcount":0,"time":1438146566000,"title":"江西正源生物科技有限公司十年磨一剑"},{"count":75,"description":"河南省国药医药有限公司回首过去，展望美好的未来，公司将一如既往地贯彻\u201c以市场为先导，以产品为核心竞争力，服务与管理并重\u201d的战略，继续坚持\u201c诚信经营、弘扬国粹、\u2018国药\u2019精品、造福人类\u201d的经营方针，不断创新、勇于进取，立志为中国的医药事业做出更大的贡献，以优秀的产品、优惠的价格、优良的服务来回报广大新老客户，河南省国药医药有限公司欢迎社会各界朋友前来洽谈合作，共同发展，共创未来","fcount":0,"id":1792,"img":"/info/150729/6b18fc5b50dabecfd4b97c7f879297db.jpg","infoclass":1,"keywords":"有限公司 河南省 国药 医药 企业 ","rcount":0,"time":1438146563000,"title":"河南省国药医药有限公司用行动弘扬国粹"}]
     */

    private boolean status;
    private int total;
    /**
     * count : 185
     * description : 公司在蓝色膏药发明人李志耿董事长带领下，以“引领新航向树立新坐标”为发展理念，致力于成为中原乃至全国医药保健行业的“新坐标”
     * fcount : 0
     * id : 1811
     * img : /info/150729/3a221908985cbbdd5717947254414ab3.jpg
     * infoclass : 1
     * keywords : 蓝色 膏药 坐标 有限公司 公司
     * rcount : 0
     * time : 1438146618000
     * title : 新坐标药业集团股份有限公司膏药市场的一匹悍马
     */
    @SerializedName("tngou")
    private List<HealthInfor> healthInfors;

    public List<HealthInfor> getHeathInfors() {
        return healthInfors;
    }

    public void setHealthInfors(List<HealthInfor> tngou) {
        this.healthInfors = tngou;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public int getTotal() {
        return total;
    }

}
