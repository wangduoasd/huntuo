package com.kaituo.huntuo.service.impl;

import com.kaituo.huntuo.dao.LableDao;
import com.kaituo.huntuo.dao.ProductEvaluateDao;
import com.kaituo.huntuo.domain.dto.EvAndELRelationDTO;
import com.kaituo.huntuo.domain.dto.EvaluateLableDTO;
import com.kaituo.huntuo.domain.dto.ProductEvaluateDTO;
import com.kaituo.huntuo.domain.po.ELRelationPO;
import com.kaituo.huntuo.domain.po.LablePO;
import com.kaituo.huntuo.domain.po.ProductEvaluatePO;
import com.kaituo.huntuo.enums.ResultEnum;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.EvaluateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 商品评价管理Service实现层
 * @author songchen
 * @date 2018/9/12
 */
@Slf4j
@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    LableDao lableDao;

    @Autowired
    ProductEvaluateDao productEvaluateDao;

    @Autowired
    EvaluateService evaluateServic;

    @Override
    public void insertLable(EvaluateLableDTO evaluateLableDTO) {
        lableDao.insertLable(evaluateLableDTO);

    }

    @Override
    public void deleteLable(Integer lableId) {
        if (null == lableId || lableId == 0) {
            throw new HuntuoException(ResultEnum.LABLE_NAME_EMPTY);
        }
        lableDao.deleteLable(lableId);
    }

    @Override
    public List<LablePO> getLableByTime() {
        return lableDao.getLableByTime();

    }

    @Override
    public void insertEvaluate(ProductEvaluateDTO productEvaluateDTO) {
        productEvaluateDao.insertEvaluate(productEvaluateDTO);
        Integer evaluateId = productEvaluateDTO.getId();
        productEvaluateDTO.setEvaluateId(evaluateId);
        productEvaluateDao.insertEvaluateLable(productEvaluateDTO);
    }

    @Override
    public List<ProductEvaluatePO> getEvaluateByProductId(Integer productId) {
        if (null == productId || productId == 0) {
            throw new HuntuoException(ResultEnum.PRODUCTID_EMPTY);
        } else if (productEvaluateDao.getEvaluateByProductId(productId).size() == 0) {
            throw new HuntuoException(ResultEnum.PRODUCTID_EMPTY);
        }
        return productEvaluateDao.getEvaluateByProductId(productId);
    }

    @Override
    public void deleteEvaluate(ProductEvaluatePO productEvaluatePO) {
        productEvaluatePO.setState(3);
        productEvaluateDao.deleteEvaluate(productEvaluatePO);
    }

    @Override
    public List<EvAndELRelationDTO> getEvAndELRelation(Integer productId,Integer lableId){
        return productEvaluateDao.getEvAndELRelation(productId,lableId);
    }

    @Override
    public void updateReply(ProductEvaluatePO productEvaluatePO) {
        productEvaluateDao.updateReply(productEvaluatePO);
    }

}
