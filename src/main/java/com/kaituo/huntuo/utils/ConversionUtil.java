package com.kaituo.huntuo.utils;

import com.kaituo.huntuo.domain.dto.ProductDTO;
import com.kaituo.huntuo.domain.po.ProductPO;
import com.kaituo.huntuo.domain.vo.ProductSolrVO;

import java.math.BigDecimal;

/**
 * DTO PO 转换类
 * @author zhoulian
 * @date 2018/8/23
 * Created by idea 2018.1
 */
public class ConversionUtil {
    /**
     * ProductPO to ProductDTO
     * @param productPO
     * @return
     */
    public static ProductDTO getProductDTO(ProductPO productPO) {
        if (null == productPO) {
            return null;
        }
        ProductDTO productDTO = ProductDTO.builder()
                .productId(productPO.getId())
                .productName(productPO.getProductName())
                .build();
        return productDTO;
    }
}
