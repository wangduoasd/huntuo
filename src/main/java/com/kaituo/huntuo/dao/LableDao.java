package com.kaituo.huntuo.dao;

import com.kaituo.huntuo.domain.dto.EvaluateLableDTO;

import com.kaituo.huntuo.domain.po.LablePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 商品评价管理(标签)
 * @author songchen
 * @date 2018/9/12
 */
@Mapper
public interface LableDao {
    /**
     * 添加标签
     * @param evaluateLableDTO
     * @return id
     */
    void insertLable(EvaluateLableDTO evaluateLableDTO);

    Integer deleteLable(int lableId);
    /**
     * 时间倒叙查询列表
     * @return List<LablePO>
     */
    List<LablePO> getLableByTime();
    /**
     * @param lablePO
     * 添加标签
     */
    int insertlable(LablePO lablePO);
    /**
     * @param Id
     *  删除标签
     */
    int deleteByKeylable(Integer Id);

    /**
     * 根据groupId查询标签
     * @param groupId
     * @return
     */
    List<LablePO> selectByGroupId(Integer groupId);

}
