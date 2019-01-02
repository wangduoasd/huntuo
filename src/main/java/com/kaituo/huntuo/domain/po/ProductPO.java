package com.kaituo.huntuo.domain.po;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author zhoulian
 * @date 2018/8/22
 * Created by idea 2018.1
 */
@Data
@Builder
public class ProductPO {
    /**
     * 商品ID
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 店铺Id
     */
    private Integer storeId;
    /**
     * 分类ID
     */
    private Integer cateId;
    private String detail ;

    private String video ;

    private String pics ;

    private String cityIds ;

    private Timestamp createTime;

    private Timestamp updateTime;

}
