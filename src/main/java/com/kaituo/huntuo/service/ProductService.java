package com.kaituo.huntuo.service;

import com.kaituo.huntuo.domain.dto.ProductDTO;
import com.kaituo.huntuo.domain.dto.SearchCountListDTO;
import com.kaituo.huntuo.domain.request.SearchEntityRequest;
import com.kaituo.huntuo.domain.request.SearchRequest;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.utils.PagerUtil;


/**
 * 商品service层
 * @author zhoulian
 * @date 2018/8/22
 * Created by idea 2018.1
 */
public interface ProductService {
    /**
     * 根据ID获取商品信息
     * @param id
     * @return
     * @throws HuntuoException
     */
    ProductDTO getById(Integer id) throws HuntuoException;

    /**
     * 搜索
     * @param request
     * @return
     * @throws HuntuoException
     */
    SearchCountListDTO search(SearchRequest request) throws HuntuoException;
    /**
     * 搜索
     * @param request
     * @return
     * @throws HuntuoException
     */
    PagerUtil searchByLableName(SearchEntityRequest request) throws HuntuoException;
}
