package com.kaituo.huntuo.domain.vo;

import lombok.Builder;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * @author @chnxy_xrabbit
 * @date 2018/9/11 11:48
 */
@SolrDocument(solrCoreName = "store")
@Data
@Builder
public class StoreSolrVO {
    /**
     * 商铺ID
     */
    @Field("id")
    private Integer id;
    /**
     * 商铺名称
     */
    @Field("storeName")
    private String storeName;
}
