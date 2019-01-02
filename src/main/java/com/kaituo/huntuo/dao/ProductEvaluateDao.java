package com.kaituo.huntuo.dao;

import com.kaituo.huntuo.domain.dto.EvAndELRelationDTO;
import com.kaituo.huntuo.domain.dto.ProductEvaluateDTO;
import com.kaituo.huntuo.domain.po.ELRelationPO;
import com.kaituo.huntuo.domain.po.ProductEvaluatePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * 商品评价管理（商品评价）
 * @author songchen
 * @date 2018/9/12
 */
@Mapper
@Component
public interface ProductEvaluateDao {
    /**
     * 添加评价
     * @param productEvaluateDTO
     * @return id
     */
    Integer insertEvaluate(ProductEvaluateDTO productEvaluateDTO);
    /**
     * 添加评价标签
     * @param productEvaluateDTO
     * @return null
     */
    void insertEvaluateLable(ProductEvaluateDTO productEvaluateDTO);
    /**
     * 按照商品id查询评价
     * @param productId
     * @return  List<ProductEvaluatePO>
     */
    List<ProductEvaluatePO> getEvaluateByProductId(Integer productId);
    /**
     *获取商品id
     * @return productId
     */
    Integer getProductId();
    /**
     * 删除评价
     * @param productEvaluatePO
     * @return null
     */
    void deleteEvaluate(ProductEvaluatePO productEvaluatePO);
    /**
     * 按照商品id和评价id查询标签
     * @param productId
     * @param lableId
     * @return  List<EvAndELRelationDTO>
     */
    List<EvAndELRelationDTO> getEvAndELRelation(@Param("productId") Integer productId,@Param("lableId")Integer lableId);
    /**
     * 回复评价
     * @param productEvaluatePO
     * @return  id
     */
    void updateReply(ProductEvaluatePO productEvaluatePO);
}
