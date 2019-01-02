package com.kaituo.huntuo.service;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.List;

/**
 * @author zhoulian
 * @date 2018/8/24
 * Created by idea 2018.1
 */
public interface SolrService{
    /**
     * solr 添加或更新索引
     * @param collection
     * @param solrEntity
     * @return
     */
    boolean save(String collection, Object solrEntity);

    /**
     * 根据ID删除索引
     * @param collection
     * @param id
     * @return
     */
    boolean deleteById(String collection, String id);

    /**
     * 根据IDList删除索引，批量
     * @param collection
     * @param idList
     * @return
     */
    boolean deleteById(String collection, List<String> idList);

    /**
     * 搜索
     * @param collection
     * @param query
     * @return
     */
    QueryResponse search(String collection, SolrQuery query) ;

}
