package com.kaituo.huntuo.service;

import com.kaituo.huntuo.domain.dto.EvAndELRelationDTO;
import com.kaituo.huntuo.domain.dto.EvaluateLableDTO;
import com.kaituo.huntuo.domain.dto.ProductEvaluateDTO;
import com.kaituo.huntuo.domain.po.ELRelationPO;
import com.kaituo.huntuo.domain.po.LablePO;
import com.kaituo.huntuo.domain.po.ProductEvaluatePO;

import java.util.List;
/**
 * 商品评价管理Service层
 * @author songchen
 * @date 2018/9/12
 */
public interface EvaluateService {
    /**
     * 添加标签
     * @param evaluateLableDTO
     * @return id
     */
    public void insertLable(EvaluateLableDTO evaluateLableDTO);

    public void deleteLable(Integer lableId);
    /**
     * 时间倒叙查询列表
     * @return List<LablePO>
     */
    public List<LablePO> getLableByTime();
    /**
     * 添加评价
     * @param productEvaluateDTO
     * @return id
     */
    public void insertEvaluate(ProductEvaluateDTO productEvaluateDTO);
    /**
     * 按照商品id查询评价
     * @param productId
     * @return  List<ProductEvaluatePO>
     */
    public List<ProductEvaluatePO> getEvaluateByProductId(Integer productId);
    /**
     * 删除评价
     * @param productEvaluatePO
     * @return null
     */
    public void deleteEvaluate(ProductEvaluatePO productEvaluatePO);
    /**
     * 按照商品id和评价id查询标签
     * @param productId
     * @param lableId
     * @return  List<EvAndELRelationDTO>
     */
    public List<EvAndELRelationDTO> getEvAndELRelation(Integer productId,Integer lableId);
    /**
     * 回复评价
     * @param productEvaluatePO
     * @return  id
     */
    public void updateReply(ProductEvaluatePO productEvaluatePO);
}
