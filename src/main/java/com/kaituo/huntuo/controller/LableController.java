package com.kaituo.huntuo.controller;

import com.kaituo.huntuo.domain.dto.LableDTO;
import com.kaituo.huntuo.domain.dto.LableGroupDTO;

import com.kaituo.huntuo.domain.po.LablePO;
import com.kaituo.huntuo.domain.request.SelectLableRequest;
import com.kaituo.huntuo.domain.response.BaseResponse;
import com.kaituo.huntuo.enums.ResultEnum;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.LableService;
import com.kaituo.huntuo.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wangduo
 * @date 2018/9/5 - 13:16
 */
@RestController
@Slf4j
@RequestMapping
@CrossOrigin
public class LableController {
    @Autowired
    private LableService lableService;

    /**
     *创建新的标签组
     * @param lableGroupDTO
     * @param bindingResult
     * @return BaseResponse
     */

    @PostMapping ("/lable_group/create")
    public BaseResponse createLG(@Valid LableGroupDTO lableGroupDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors ()) {
            return ResultUtil.error (ResultEnum.PARAM_EMPTY.getCode(), bindingResult.getFieldError ().getDefaultMessage ());
        }
        try {
             int id=lableService.createLG (lableGroupDTO);
            return ResultUtil.success (id);
        } catch (HuntuoException e) {
            return ResultUtil.error (e.getCode (), e.getMessage ());
        }

    }

    /**
     * 删除标签组
     * @param id
     * @return BaseResponse
     */

    @PostMapping("/lable_group/delete")
    public BaseResponse deleteLG(@RequestParam("groupId") Integer id){
        try {
            lableService.deleteLG (id);
        } catch (HuntuoException e) {
            return ResultUtil.error (e.getCode (), e.getMessage ());
        }
        return ResultUtil.success ();
    }

    /**
     * 添加标签
     * @param lableDTO
     * @param bindingResult
     * @return BaseResponse
     */
    @PostMapping ("/lable/create")
    public BaseResponse create(@Valid LableDTO lableDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors ()) {
            return ResultUtil.error (ResultEnum.PARAM_EMPTY.getCode(), bindingResult.getFieldError ().getDefaultMessage ());
        }
        try {
           int id=lableService.create (lableDTO);
            return ResultUtil.success (id);
        } catch (HuntuoException e) {
            return ResultUtil.error (e.getCode (), e.getMessage ());
        }

    }
    /**
     * 删除标签
     * @param id
     * @return BaseResponse
     */
    @PostMapping("/lable/delete")
    public BaseResponse delete(@RequestParam("lableId") Integer id){
        //todo
        try {
            lableService.delete (id);
        } catch (HuntuoException e) {
            return ResultUtil.error (e.getCode (), e.getMessage ());
        }
        return ResultUtil.success ();
    }

    /**
     * 查询标签
     * @param id
     * @return BaseResponse
     */
    @PostMapping(path = "/lable/select")
    public BaseResponse getBycateId(@RequestParam("cateId") Integer id) {
        try {
            List<SelectLableRequest> selectLableRequestList=lableService.getAll (id);
            return ResultUtil.success(selectLableRequestList);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }


}
