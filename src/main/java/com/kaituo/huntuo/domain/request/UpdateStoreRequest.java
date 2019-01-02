package com.kaituo.huntuo.domain.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author @chnxy_xrabbit
 * @date 2018/10/9 16:59
 */
@Data
@Builder
public class UpdateStoreRequest {
    /**
     * 商铺ID
     */
    @NotNull(message = "参数缺失：id不能为空")
    private Integer id;
    /**
     * 商铺名称
     */
    @NotBlank(message = "参数缺失：storeName不能为空")
    private String storeName;
    /**
     * 联系方式
     */
    @NotBlank(message = "参数缺失：contactNumber不能为空")
    private String contactNumber;
    /**
     * 办公电话
     */
    @NotBlank(message = "参数缺失：tel不能为空")
    private String tel;
    /**
     *  负责人名
     */
    @NotBlank(message = "参数缺失：personInCharge不能为空")
    private String personInCharge;
    /**
     * 营业时间
     */
    @NotBlank(message = "参数缺失：workTime不能为空")
    private String workTime;
    /**
     * 公司简介
     */
    @NotBlank(message = "参数缺失：description不能为空")
    private String description;
    /**
     * 城市id
     */
    @NotNull(message = "参数缺失：cityId不能为空")
    private Integer cityId;
    /**
     * 经纬度坐标
     */
    @NotBlank(message = "参数缺失：position不能为空")
    private String position;
    /**
     * 详细地址
     */
    @NotBlank(message = "参数缺失：address不能为空")
    private String address;
    /**
     * 店铺公告
     */
    private String notice;
    /**
     * 店铺类型(1,企业;2,个人)
     */
    @NotNull(message = "参数缺失：type不能为空")
    private Integer type;
    /**
     *密码
     */
    @NotBlank(message = "参数缺失：password不能为空")
    private String password;
    /**
     * 服务城市id，逗号间隔。
     */
    @NotBlank(message = "参数缺失：cityIds不能为空")
    private String cityIds;
}
