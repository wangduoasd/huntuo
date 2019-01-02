package com.kaituo.huntuo.service.impl;

import com.kaituo.huntuo.dao.ProductDao;
import com.kaituo.huntuo.domain.dto.ProductDTO;
import com.kaituo.huntuo.domain.dto.SearchCountDTO;
import com.kaituo.huntuo.domain.dto.SearchCountListDTO;
import com.kaituo.huntuo.domain.dto.SearchDTO;
import com.kaituo.huntuo.domain.po.ProductPO;
import com.kaituo.huntuo.domain.request.SearchEntityRequest;
import com.kaituo.huntuo.domain.request.SearchRequest;
import com.kaituo.huntuo.enums.ResultEnum;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.KeyWordService;
import com.kaituo.huntuo.service.ProductService;
import com.kaituo.huntuo.service.SolrService;
import com.kaituo.huntuo.utils.ConversionUtil;
import com.kaituo.huntuo.utils.PagerUtil;
import com.kaituo.huntuo.utils.SearchHighlight;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品service层
 * @author zhoulian
 * @date 2018/8/21
 * Created by idea 2018.1
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private SolrService solrService;
    @Autowired
    private KeyWordService keyWordService;
    @Autowired
    private SolrClient client;

    private static final String SOLR_COLLECTION = "product";

    @Override
    public ProductDTO getById(Integer id) throws HuntuoException {
        ProductPO productPO;
        try {
            productPO = productDao.getById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
        if (null == productPO) {
            throw new HuntuoException(ResultEnum.EMPTY);
        } else {
            return ConversionUtil.getProductDTO(productPO);
        }
    }
    @Override
    public SearchCountListDTO search(SearchRequest request) throws HuntuoException {
        try {
            SolrQuery params = new SolrQuery();
            params.set("defType","edismax");
            params.set("qf","lable_name pinyin product_name");
            params.set("q", request.getKeyWord());
            //分页
//            params.setStart((request.getPageNo() -1 ) * request.getPageSize());
//            params.setRows(request.getPageSize());
            //过滤
            if(request.getCateType()==1||request.getCateType()==2){
                params.set("fq", "cate_type:"+request.getCateType());
            }
            //排序
            // params.addSort("show_price", SolrQuery.ORDER.asc);
            //设置facet=on
            params.setFacet(true);
            //设置需要facet的字段
            params.addFacetField(new String[] {"cate_id" });
            String name="product_name";
            //高亮
            //SearchHighlight.highlight( request, params,name);
            QueryResponse queryResponse = solrService.search(SOLR_COLLECTION, params);
            SolrDocumentList results = queryResponse.getResults();
            if (results.isEmpty()) {
                return null;
            }
            List<FacetField> facets = queryResponse.getFacetFields();
            long numFound = facets.size();
            if (numFound <= 0) {
                return null;
            }
            String keyword=(String)results.get(0).getFirstValue(name);
            Integer type=request.getCateType();
            if (request.getCateType()>3||request.getCateType()<=0){
                type=1;
                keyWordService.addKeyWordOrUpdateTimes(keyword,type);
            }
            if (request.getCateType()>3||request.getCateType()<=0){
                type=2;
                keyWordService.addKeyWordOrUpdateTimes(keyword,type);
            }else{
                keyWordService.addKeyWordOrUpdateTimes(keyword,type);
            }
            SearchCountListDTO searchCountListDTO=SearchCountListDTO.builder()
                    .cate_type(request.getCateType())
                    .build();
            //获取统计数量
            for (FacetField facet : facets) {
                List<SearchCountDTO> lt = new ArrayList<>();
                List<FacetField.Count> counts = facet.getValues();
                for (FacetField.Count count : counts) {
                    if(count.getCount()!=0){
                        SearchCountDTO searchCountDTO=SearchCountDTO.builder()
                                .cateId(Integer.valueOf(count.getName()))
                                .Count(count.getCount())
                                .build();
                        lt.add(searchCountDTO);
                    }
                }
                searchCountListDTO.setSearchCountDTOList(lt);
            }
            return searchCountListDTO;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new HuntuoException(ResultEnum.UNKONW_ERROR);
        }
    }
    @Override
    public PagerUtil searchByLableName(SearchEntityRequest request) throws HuntuoException {
        try {

            SolrQuery params = new SolrQuery();
            params.set("qt","/select");
            params.set("defType","edismax");
            params.set("qf","lable_name pinyin product_name plate_number");
            String queryWord="";
            String  cateType=null;
            String order=request.getOrder();
            String chooses=request.getChooses();
            if(!chooses.contains("keyword")){
                return null;
            }
            //分页
            String page=request.getPage();
            queryWord=SearchHighlight.filterString(params,chooses,queryWord,order);
            params.set("q", queryWord);
            String name="product_name";

            Integer pageNo=1;
            Integer pageSize=20;
            SearchHighlight.page(page,params,pageNo,pageSize);
            QueryResponse queryResponse = solrService.search(SOLR_COLLECTION, params);
            SolrDocumentList results = queryResponse.getResults();
            if (results.isEmpty()) {
                return null;
            }
            long numFound = results.getNumFound();
            if (numFound <= 0) {
                return null;
            }
            int index=chooses.lastIndexOf("cateType:")+"cateType:".length();
            cateType=chooses.substring(index,index+1);
            if(cateType!=null&&SearchHighlight.isNumeric(cateType)){
                String keyword=(String)results.get(0).getFirstValue(name);
                Integer type=Integer.valueOf(cateType);
                if (type>3||type<=0){
                    type=1;
                    keyWordService.addKeyWordOrUpdateTimes(keyword,type);
                }
                if (type>3||type<=0){
                    type=2;
                    keyWordService.addKeyWordOrUpdateTimes(keyword,type);
                }else{
                    keyWordService.addKeyWordOrUpdateTimes(keyword,type);
                }
            }
            PagerUtil pager = new PagerUtil(pageNo, pageSize, (int)numFound);
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
