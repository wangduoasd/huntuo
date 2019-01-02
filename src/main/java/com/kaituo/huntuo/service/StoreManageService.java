package com.kaituo.huntuo.service;

import com.kaituo.huntuo.domain.dto.SearchCountListDTO;
import com.kaituo.huntuo.domain.dto.StoreDTO;
import com.kaituo.huntuo.domain.request.*;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.utils.PagerUtil;

/**
 * 商品案例service层
 * @author @chnxy_xrabbit
 * @date 2018/9/5 10:42
 */
public interface StoreManageService {

    /**
     * 按ID查询店铺详情
     * @param storeId
     * @return StorePO
     * @throws HuntuoException
     */
    StoreDTO getStoreDTOById(Integer storeId )throws HuntuoException;

    /**
     * 修改店铺状态
     * @param storeId
     * @return Integer
     * @throws HuntuoException
     */
    Integer updateStoreStateById(Integer state,Integer storeId)throws HuntuoException;
    /**
     * 添加店铺
     * @param request
     * @return Integer
     * @throws HuntuoException
     */
    Integer addStore(CreateStoreRequest request)throws HuntuoException;

    /**
     * 修改店铺详情
     * @param request
     * @return Integer
     * @throws HuntuoException
     */
    Integer updateStoreById(UpdateStoreRequest request)throws HuntuoException;

    /**
     * 店铺搜索（统计）
     * @param request
     * @return PagerUtil
     * @throws HuntuoException
     */
    SearchCountListDTO search(SearchRequest request) throws HuntuoException;

    /**
     * 店铺搜索（按名称）
     * @param request
     * @return PagerUtil
     * @throws HuntuoException
     */
    PagerUtil searchStore(SearchEntityRequest request) throws HuntuoException;
}
