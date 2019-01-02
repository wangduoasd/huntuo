package com.kaituo.huntuo.domain.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 * 商品评价DTO类
 * @author songchen
 * @date 2018/9/12
 */
@Data
@Builder
public class ProductEvaluateDTO {
    /**
     *商品评价id
     */
    private Integer id;
    /**
     *评价星级1--5
     */
    @NotNull(message = "参数缺失：rank不能为空")
    private Integer rank;
    /**
     *评价内容
     */
    @NotBlank(message = "参数缺失：content不能为空")
    private String content;
    /**
     *图片路径，逗号分隔
     */
    @NotBlank(message = "参数缺失：pics不能为空")
    private String pics;
    /**
     *评价id
     */
    private Integer evaluateId;
    /**
     *标签id
     */
    @NotNull(message = "参数缺失：lableId不能为空")
    private Integer lableId;
}
