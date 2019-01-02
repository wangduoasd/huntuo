package com.kaituo.huntuo.controller;

import com.kaituo.huntuo.domain.dto.EvAndELRelationDTO;
import com.kaituo.huntuo.domain.dto.EvaluateLableDTO;
import com.kaituo.huntuo.domain.dto.ProductEvaluateDTO;
import com.kaituo.huntuo.domain.po.ELRelationPO;
import com.kaituo.huntuo.domain.po.LablePO;
import com.kaituo.huntuo.domain.po.ProductEvaluatePO;
import com.kaituo.huntuo.domain.response.BaseResponse;
import com.kaituo.huntuo.enums.ResultEnum;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.EvaluateService;
import com.kaituo.huntuo.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 商品评价管理Controller层
 * @author songchen
 * @date 2018/9/12
 */
@RestController
@RequestMapping("/evaluate")
public class EvaluateLableController {
    @Autowired
    EvaluateService evaluateService;

    @PostMapping("/insert_lable")
    public BaseResponse insertLable(@Valid EvaluateLableDTO evaluateLableDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            evaluateService.insertLable(evaluateLableDTO);
            Integer id = evaluateLableDTO.getId();
            return ResultUtil.success(id);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }

    @PostMapping("get_lable_by_time")
    public BaseResponse getLableByTime(@Valid LablePO lablePO, BindingResult bindingResult) {
        try {
            List<LablePO> lablePOList = evaluateService.getLableByTime();
            if (lablePOList.size() == 0) {
                throw new HuntuoException(ResultEnum.LABLE_EMPTY);
            }
            return ResultUtil.success(lablePOList);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }

    @PostMapping("/delete_lable")
    public BaseResponse deleteLable(@Valid Integer lableId) {
        try {
            evaluateService.deleteLable(lableId);
            return ResultUtil.success();
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }

    @PostMapping("insert_evaluate")
    public BaseResponse insertEvaluate(@Valid ProductEvaluateDTO productEvaluateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            evaluateService.insertEvaluate(productEvaluateDTO);
            Integer id = productEvaluateDTO.getId();
            return ResultUtil.success(id);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }

    @PostMapping("/get_evaluate_by_productId")
    public BaseResponse getEvaluateByProductId(@Valid Integer productId) {
        try {
            List<ProductEvaluatePO> productEvaluatePOList = evaluateService.getEvaluateByProductId(productId);
            return ResultUtil.success(productEvaluatePOList);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }

    @PostMapping("/delete_evaluate")
    public BaseResponse deleteEvaluate(@Valid ProductEvaluatePO productEvaluatePO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            evaluateService.deleteEvaluate(productEvaluatePO);
            Integer id = productEvaluatePO.getId();
            return ResultUtil.success(id);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }

    @PostMapping("/get_ev_and_eL_relation")
    public BaseResponse getEvAndELRelation(@Param("productId") Integer productId, @Param("lableId")Integer lableId) {
        try {
            List<EvAndELRelationDTO> evAndELRelationDTOList = evaluateService.getEvAndELRelation(productId,lableId);
            return ResultUtil.success(evAndELRelationDTOList);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }

    @PostMapping("/update_reply")
    public BaseResponse updateReply(@Valid ProductEvaluatePO productEvaluatePO,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            evaluateService.updateReply(productEvaluatePO);
            Integer id = productEvaluatePO.getId();
            return ResultUtil.success(id);
        } catch (HuntuoException e) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        }
    }
}
