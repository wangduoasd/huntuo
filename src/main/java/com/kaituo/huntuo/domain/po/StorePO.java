package com.kaituo.huntuo.domain.po;

import lombok.Builder;
import lombok.Data;

/**
 * @author @chnxy_xrabbit
 * @date 2018/9/4 15:07
 */
@Data
@Builder
public class StorePO {
    /**
     * 商铺ID
     */
    private Integer id;
    /**
     * 商铺名称
     */
    private String storeName;
    /**
     * 营业执照(企业信用代码号)
     */
    private String license;
    /**
     * 联系方式
     */
    private String contactNumber;
    /**
     * 办公电话
     */
    private String tel;
    /**
     *  负责人名
     */
    private String personInCharge;
    /**
     * 营业时间
     */
    private String workTime;
    /**
     * 公司简介
     */
    private String description;
    /**
     * 城市id
     */
    private Integer cityId;
    /**
     * 经纬度坐标
     */
    private String position;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 店铺状态
     */
    private Integer state;
    /**
     * 商家综合评分1-5星
     */
    private Integer rank;
    /**
     * 店铺公告
     */
    private String notice;
    /**
     * 店铺类型(1,企业;2,个人)
     */
    private Integer type;
    /**
     *密码
     */
    private String password;
    /**
     * token
     */
    private String token;
    /**
     * 服务城市id，逗号间隔。
     */
    private String cityIds;
}
