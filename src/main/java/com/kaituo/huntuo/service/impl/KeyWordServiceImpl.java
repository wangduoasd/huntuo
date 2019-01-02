package com.kaituo.huntuo.service.impl;

import com.kaituo.huntuo.dao.KeyWordDao;
import com.kaituo.huntuo.domain.po.KeyWordPO;
import com.kaituo.huntuo.enums.ResultEnum;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.KeyWordService;
import com.kaituo.huntuo.service.SolrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SuggesterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author @chnxy_xrabbit
 * @date 2018/9/25 11:43
 */
@Slf4j
@Service
public class KeyWordServiceImpl implements KeyWordService {
    @Autowired
    KeyWordDao keyWordDao;
    @Autowired
    private SolrService solrService;
    private static final String SOLR_COLLECTION = "keyword";


    /**
     * 添加搜索关键词（用于热搜词排序），数据库中不存在则插入;存在则不插入,times次数加一
     * 默认sort_no:0,time:1;
     * @param keyword
     * @param type
     * @return Integer 返回操作id
     * @throws HuntuoException
     */
    @Override
    public Integer addKeyWordOrUpdateTimes( String keyword,Integer type) throws HuntuoException {
        KeyWordPO keyWordPO=KeyWordPO.builder()
                .keyWord(keyword)
                .type(type)
                .build();
        if (keyWordPO.getType()>3||keyWordPO.getType()<=0){
            throw new HuntuoException(ResultEnum.NOEXIT);
        }
        Integer integer = null;
        try {
            //todo
            keyWordDao.addKeyWord(keyWordPO);
            integer=keyWordPO.getId();
            if (integer==0){
                keyWordDao.updateTimes(keyWordPO);
                integer=keyWordPO.getId();
            }
        } catch (Exception e) {
            log.error("KeyWordServiceImpl->addKeyWordOrUpdateTimes:"+e.getMessage());
            throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
        return integer;
    }

    /**
     * 搜索联想
     * @param htmlword
     * @return kylist(结果集)
     * @throws HuntuoException
     */
    @Override
    public List<String> searchKeyword(String htmlword) throws HuntuoException {
        ArrayList<String> kylist=new ArrayList<> ();
        SolrQuery params = new SolrQuery ();
        params.set ("qt","/suggest");
        params.setQuery (htmlword);
        QueryResponse response = null;
        response = solrService.search (SOLR_COLLECTION,params);
        SuggesterResponse suggest = response.getSuggesterResponse();
        Map<String, List<String>> termMap = suggest.getSuggestedTerms ();
        for (List<String> strs : termMap.values ()) {
               for (String s:strs){
                  log.info (s);
                   kylist.add(s);
               }
        }

        return kylist;
    }

    @Override
    public void delete_keyword() throws HuntuoException {
        try {
            keyWordDao.deleteKeyword();
        }catch (HuntuoException e){
        throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
    }
}




