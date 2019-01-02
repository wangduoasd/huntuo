package com.kaituo.huntuo.service.impl;

import com.kaituo.huntuo.service.SolrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * @author zhoulian
 * @date 2018/8/24
 * Created by idea 2018.1
 */
@Slf4j
@Service
public class SolrServiceImpl implements SolrService {
    @Autowired
    private SolrClient client;
    @Override
    public boolean save(String collection, Object solrEntity) {
        try {
            UpdateResponse response = client.addBean(collection,solrEntity);
            Integer status = response.getStatus();
            UpdateResponse responseCommit = client.commit(collection);
            Integer statusCommit = responseCommit.getStatus();

            if (status == 0 && statusCommit == 0) {
                return true;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteById(String collection, String id) {
        try {
            client.deleteById(collection, id);
            client.commit(collection);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }



    @Override
    public boolean deleteById(String collection, List<String> idList) {
//        try {
//            client.deleteById(collection, idList);
//            client.commit(collection);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return true;
    }

    @Override
    public QueryResponse search(String collection, SolrQuery query) {
        try {
            QueryResponse queryResponse = client.query(collection, query);
            return queryResponse;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }


}
