package com.kaituo.huntuo.controller;

import com.kaituo.huntuo.domain.dto.SearchDTO;
import com.kaituo.huntuo.domain.dto.StoreDTO;
import com.kaituo.huntuo.domain.request.CreateStoreRequest;
import com.kaituo.huntuo.domain.request.SearchEntityRequest;
import com.kaituo.huntuo.domain.request.UpdateStoreRequest;
import com.kaituo.huntuo.domain.response.BaseResponse;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.StoreManageService;
import com.kaituo.huntuo.utils.PagerUtil;
import com.kaituo.huntuo.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 商品案例相关接口
 * @author @chnxy_xrabbit
 * @date 2018/9/5 14:29
 */
@Slf4j
@RestController
@RequestMapping("store_manage")
public class StoreManageController {
    @Autowired
    StoreManageService storeManageService;
    @Autowired
    private SolrClient client;
    /**
     * 按ID查询店铺详情
     * @param storeId
     * @return BaseResponse
     */
    @PostMapping(path = "/get_store_by_id")
    public BaseResponse getStoreById(Integer storeId) {
        try {
            StoreDTO storeDTO=storeManageService.getStoreDTOById(storeId);
            return ResultUtil.success(storeDTO);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }
    @PostMapping(path = "/update_store_state_by_id")
    public BaseResponse updateStoreStateById(Integer state,Integer storeId) {
        try {
            Integer id=storeManageService.updateStoreStateById(state,storeId);
            return ResultUtil.success(id);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }

    /**
     *  添加店铺
     * @param request
     * @param bindingResult
     * @return BaseResponse
     */
    @RequestMapping("add_store")
    public  BaseResponse addStore(@Valid CreateStoreRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            Integer id=storeManageService.addStore(request);
            return ResultUtil.success(id);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 修改店铺详情
     * @param request
     * @param bindingResult
     * @return BaseResponse
     */
    @RequestMapping("update_store_by_id")
    public  BaseResponse updateStoreById(@Valid UpdateStoreRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            Integer id=storeManageService.updateStoreById(request);
            return ResultUtil.success(id);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }
    @PostMapping(path = "search_store")
    public BaseResponse search(@Valid SearchEntityRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            // 参数默认值
            PagerUtil<SearchDTO> searchResult = storeManageService.searchStore(request);
            if (null == searchResult) {
                searchResult = new PagerUtil<>();
            }
            return ResultUtil.success(searchResult);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }
}
