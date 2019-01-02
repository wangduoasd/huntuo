package com.kaituo.huntuo.domain.vo;

import lombok.Builder;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;


/**
 * @author zhoulian
 * @date 2018/8/28
 * Created by idea 2018.1
 */
@SolrDocument(solrCoreName = "product")
@Data
@Builder
public class ProductSolrVO {
    /**
     * 商品ID
     */
    @Field("id")
    private Integer productId;
    /**
     * 商品名称
     */
    @Field("product_name")
    private String productName;
}
