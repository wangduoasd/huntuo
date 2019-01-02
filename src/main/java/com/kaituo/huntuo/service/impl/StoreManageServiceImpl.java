package com.kaituo.huntuo.service.impl;

import com.kaituo.huntuo.dao.ProductDao;
import com.kaituo.huntuo.dao.StoreDao;
import com.kaituo.huntuo.domain.dto.SearchCountDTO;
import com.kaituo.huntuo.domain.dto.SearchCountListDTO;
import com.kaituo.huntuo.domain.dto.StoreDTO;
import com.kaituo.huntuo.domain.dto.SearchDTO;
import com.kaituo.huntuo.domain.po.StorePO;
import com.kaituo.huntuo.domain.request.CreateStoreRequest;
import com.kaituo.huntuo.domain.request.SearchEntityRequest;
import com.kaituo.huntuo.domain.request.SearchRequest;
import com.kaituo.huntuo.domain.request.UpdateStoreRequest;
import com.kaituo.huntuo.enums.ResultEnum;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.KeyWordService;
import com.kaituo.huntuo.service.SolrService;
import com.kaituo.huntuo.service.StoreManageService;
import com.kaituo.huntuo.utils.PagerUtil;
import com.kaituo.huntuo.utils.SearchHighlight;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品案例service实现层
 * @author @chnxy_xrabbit
 * @date 2018/9/5 10:47
 */
@Slf4j
@Service
public class StoreManageServiceImpl implements StoreManageService {
    @Autowired
    StoreDao storeDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    private KeyWordService keyWordService;
    @Autowired
    private SolrService solrService;
    private static final String SOLR_COLLECTION = "store";
    /**
     * 按ID查询店铺详情
     * @param storeId
     * @return StorePO
     * @throws HuntuoException
     */
    @Override
    public StoreDTO getStoreDTOById(Integer storeId) throws HuntuoException {
        if (storeId==null){
            throw new HuntuoException(ResultEnum.PARAM_EMPTY);
        }
        StorePO storePO;
        try {
            storePO=storeDao.getStorePOById(storeId);
        } catch (Exception e) {
            log.error("StoreManageServiceImpl->getStoreDTOById:"+e.getMessage());
            throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
        if (null == storePO) {
            throw new HuntuoException(ResultEnum.EMPTY);
        } else {
            StoreDTO storeDTO=StoreDTO.builder()
                    .id(storePO.getId())
                    .storeName(storePO.getStoreName())
                    .license(storePO.getLicense())
                    .contactNumber(storePO.getContactNumber())
                    .tel(storePO.getTel())
                    .personInCharge(storePO.getPersonInCharge())
                    .workTime(storePO.getWorkTime())
                    .description(storePO.getDescription())
                    .cityId(storePO.getCityId())
                    .position(storePO.getPosition())
                    .address(storePO.getAddress())
                    .state(storePO.getState())
                    .notice(storePO.getNotice())
                    .type(storePO.getType())
                    .cityIds(storePO.getCityIds())
                    .build();
            return storeDTO;
        }
    }

    /**
     * 修改店铺状态
     * @param storeId
     * @return Integer
     * @throws HuntuoException
     */
    @Override
    public Integer updateStoreStateById(Integer state,Integer storeId) throws HuntuoException {
        if (storeId==null){
            throw new HuntuoException(ResultEnum.PARAM_EMPTY);
        }
        StorePO storePO=storeDao.getStorePOById(storeId);
        if (storePO==null){
            throw new HuntuoException(ResultEnum.EMPTY);
        }
        if (state==null||state.equals("")||state<-2||state>1){
            throw new HuntuoException(ResultEnum.NO_STATE);
        }
        try {
            storeDao.updateStoreStateById(state,storeId);
        } catch (Exception e) {
            log.error("StoreManageServiceImpl->updateStoreStateById:"+e.getMessage());
            throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
        return state;
    }
    /**
     * 添加店铺
     * @param request
     * @return Integer
     * @throws HuntuoException
     */
    @Override
    public Integer addStore(CreateStoreRequest request) throws HuntuoException {
        StorePO storePO=StorePO.builder()
                .id(request.getId())
                .storeName(request.getStoreName())
                .license(request.getLicense())
                .contactNumber(request.getContactNumber())
                .tel(request.getTel())
                .personInCharge(request.getPersonInCharge())
                .workTime(request.getWorkTime())
                .description(request.getDescription())
                .cityId(request.getCityId())
                .position(request.getPosition())
                .address(request.getAddress())
                .rank(0)
                .notice(request.getNotice())
                .state(0)
                .type(request.getType())
                .password(request.getPassword())
                .token(request.getToken())
                .cityIds(request.getCityIds())
                .build();

        try {
            Integer id = storeDao.addStore(storePO);
            if (null != id && id > 0) {
                return storePO.getId();
            }
        } catch (Exception e) {
            log.error("StoreManageServiceImpl->addStore:"+e.getMessage());
            throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
        return null;
    }
    /**
     * 修改店铺详情
     * @param request
     * @throws HuntuoException
     */
    @Override
    public Integer updateStoreById(UpdateStoreRequest request) throws HuntuoException {
        StorePO storePO = StorePO.builder()
                .id(request.getId())
                .storeName(request.getStoreName())
                .contactNumber(request.getContactNumber())
                .tel(request.getTel())
                .personInCharge(request.getPersonInCharge())
                .workTime(request.getWorkTime())
                .description(request.getDescription())
                .cityId(request.getCityId())
                .position(request.getPosition())
                .address(request.getAddress())
                .notice(request.getNotice())
                .type(request.getType())
                .password(request.getPassword())
                .cityIds(request.getCityIds())
                .build();

        try {
            Integer id = storeDao.updateStoreById(storePO);
            if (null != id && id > 0) {

                return request.getId();
            }
        } catch (Exception e) {
            log.error("StoreManageServiceImpl->updateStoreById:"+e.getMessage());
            throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
        return null;
    }
    @Override
    public SearchCountListDTO search(SearchRequest request) throws HuntuoException {
        try {
            SolrQuery params = new SolrQuery();

            //查询条件, 这里的 q
            params.set("defType","edismax");
            params.set("qf","storeName pinyin");
            params.set("q", request.getKeyWord());
//            params.setStart((request.getPageNo() -1 ) * request.getPageSize());
//            params.setRows(request.getPageSize());
            //默认域
            params.set("df", "storeName");
            //只查询指定域
            params.set("fl", "id,storeName");
            //高亮
            String name="storeName";
            //SearchHighlight.highlight( request, params,name);
            QueryResponse queryResponse = solrService.search(SOLR_COLLECTION, params);
            SolrDocumentList results = queryResponse.getResults();
            if (results.isEmpty()) {
                return null;
            }
            long numFound = results.getNumFound();
            if (numFound <= 0) {
                return null;
            }
            String keyword=(String)results.get(0).getFirstValue(name);
            Integer type=request.getCateType();
            if (type>3||type<=0){
                type=3;
            }
            keyWordService.addKeyWordOrUpdateTimes(keyword,type);
            SearchCountListDTO searchCountListDTO=SearchCountListDTO.builder()
                    .cate_type(request.getCateType())
                    .build();
            //获取统计数量
            List<SearchCountDTO> lt = new ArrayList<>();
            SearchCountDTO searchCountDTO=SearchCountDTO.builder()
                    .cateId(0)
                    .Count(numFound)
                    .build();
            lt.add(searchCountDTO);
            searchCountListDTO.setSearchCountDTOList(lt);
            return searchCountListDTO;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
    }

    @Override
    public PagerUtil searchStore(SearchEntityRequest request) throws HuntuoException {
        try {
            SolrQuery params = new SolrQuery();

            //查询条件, 这里的 q
            params.set("defType","edismax");
            params.set("qf","storeName pinyin");
            String queryWord="";
            String order=request.getOrder();
            String chooses=request.getChooses();
            if(!chooses.contains("keyword")){
                return null;
            }
            //分页
            String page=request.getPage();
            queryWord=SearchHighlight.filterString(params,chooses,queryWord,order);
            params.set("q", queryWord);
            String name="storeName";
            Integer pageNo=1;
            Integer pageSize=20;
            SearchHighlight.page(page,params,pageNo,pageSize);
            //默认域
            params.set("df", "storeName");
            //只查询指定域
            params.set("fl", "id,storeName");
            //高亮
            SearchHighlight.highlight( request, params,name);
            QueryResponse queryResponse = solrService.search(SOLR_COLLECTION, params);
            SolrDocumentList results = queryResponse.getResults();
            if (results.isEmpty()) {
                return null;
            }
            long numFound = results.getNumFound();
            if (numFound <= 0) {
                return null;
            }
                String keyword=(String)results.get(0).getFirstValue(name);
                keyWordService.addKeyWordOrUpdateTimes(keyword,3);
            PagerUtil pager = new PagerUtil(pageNo, pageSize, (int)numFound);
            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            List<SearchDTO> list = new ArrayList<>();
            list=SearchHighlight.highilight( request, name, queryResponse,results, list);
            pager.setList(list);
            return pager;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
    }

}
