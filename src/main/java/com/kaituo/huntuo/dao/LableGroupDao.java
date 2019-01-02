package com.kaituo.huntuo.dao;
import com.kaituo.huntuo.domain.dto.LableDTO;
import com.kaituo.huntuo.domain.po.LableGroupPO;
import com.kaituo.huntuo.domain.po.LablePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangduo
 * @date 2018/9/4 - 15:19
 */
@Mapper
public interface LableGroupDao {
    /**
     * 添加标签组
     * @param lableGroupPO
     * @return
     */
    int insertlablegroup (LableGroupPO lableGroupPO);

    /**
     * 删除标签组
     * @param Id
     * @return
     */
    int deleteByKeylablegroup(Integer Id);

    /**
     * 根据cateId查询标签组
     * @param cateId
     * @return
     */
    List<LableGroupPO> selectBycateId(Integer cateId);

}
