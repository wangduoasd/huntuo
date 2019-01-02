package com.kaituo.huntuo.controller;

import com.kaituo.huntuo.domain.dto.SearchCountListDTO;
import com.kaituo.huntuo.domain.request.SearchRequest;
import com.kaituo.huntuo.domain.response.BaseResponse;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.KeyWordService;
import com.kaituo.huntuo.service.ProductService;
import com.kaituo.huntuo.service.StoreManageService;
import com.kaituo.huntuo.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author @chnxy_xrabbit
 * @date 2018/10/8 9:35
 */
@Slf4j
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    KeyWordService keyWordService;
    @Autowired
    ProductService productService;
    @Autowired
    StoreManageService storeManageService;
    @PostMapping(path = "search_home")
    public BaseResponse search(@Valid SearchRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            SearchCountListDTO searchCountPaoructListDTOS=null;
            SearchCountListDTO searchCountStoreListDTOS=null;
            switch (request.getCateType()){
                case 1:
                    searchCountPaoructListDTOS = productService.search(request);
                    return ResultUtil.success(searchCountPaoructListDTOS);
                case 2:
                    searchCountPaoructListDTOS = productService.search(request);
                    return ResultUtil.success(searchCountPaoructListDTOS);
                case 3:
                    searchCountStoreListDTOS = storeManageService.search(request);
                    return ResultUtil.success(searchCountStoreListDTOS);
                case 0:
                    searchCountPaoructListDTOS = productService.search(request);
                    searchCountStoreListDTOS = storeManageService.search(request);
                    if(searchCountStoreListDTOS!=null){
                        searchCountPaoructListDTOS.getSearchCountDTOList()
                                .addAll(searchCountStoreListDTOS.getSearchCountDTOList());
                    }
                    return ResultUtil.success(searchCountPaoructListDTOS);
                default:
                    searchCountPaoructListDTOS = productService.search(request);
                    searchCountStoreListDTOS = storeManageService.search(request);
                    if(searchCountStoreListDTOS!=null){
                        searchCountPaoructListDTOS.getSearchCountDTOList()
                                .addAll(searchCountStoreListDTOS.getSearchCountDTOList());
                    }
                    return ResultUtil.success(searchCountPaoructListDTOS);

            }
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }
    /**
     * 搜索联想
     */
    @PostMapping(path = "/search_suggest")
    public BaseResponse search(@RequestParam("htmlword") String htmlword) {
        List<?> suggestlist = keyWordService.searchKeyword (htmlword);
            return ResultUtil.success (suggestlist);
    }
}
