package com.kaituo.huntuo.controller;

import com.kaituo.huntuo.domain.dto.SearchDTO;
import com.kaituo.huntuo.domain.request.SearchEntityRequest;
import com.kaituo.huntuo.domain.response.BaseResponse;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.KeyWordService;
import com.kaituo.huntuo.service.ProductService;
import com.kaituo.huntuo.utils.PagerUtil;
import com.kaituo.huntuo.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author @chnxy_xrabbit
 * @date 2018/9/26 9:17
 */
@Slf4j
@RestController
@RequestMapping("product_search")
public class ProductSearchController {
    @Autowired
    KeyWordService keyWordService;
    @Autowired
    ProductService productService;

    @PostMapping(path = "search_by_lableName")
    public BaseResponse search(@Valid SearchEntityRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            // 参数默认值
            PagerUtil<SearchDTO> searchResult = productService.searchByLableName(request);
            if (null == searchResult) {
                searchResult = new PagerUtil<>();
            }
            return ResultUtil.success(searchResult);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }
}
