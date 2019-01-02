package com.kaituo.huntuo.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author zhoulian
 * @date 2018/8/22
 * Created by idea 2018.1
 */
@Data
@Builder
public class ProductDTO {
    /**
     * 商品ID
     */
    private Integer productId;
    /**
     * 商品名称
     */
    private String productName;

}
