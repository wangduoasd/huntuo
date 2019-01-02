package com.kaituo.huntuo.dao;

import com.kaituo.huntuo.domain.po.StorePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 店铺Dao
 * @author @chnxy_xrabbit
 * @date 2018/9/10 9:40
 */
@Mapper
public interface StoreDao {
    /**
     * 按ID查询店铺详情
     * @param id
     * @return StorePO
     */
    StorePO getStorePOById(@Param("id")Integer id );

    /**
     * 修改店铺状态
     * @param state
     * @param id
     */
    void updateStoreStateById(@Param("state")Integer state,@Param("id")Integer id);

    /**
     * 添加店铺
     * @param storePO
     * @return Integer
     */
    Integer addStore(@Param("storePO")StorePO storePO);

    /**
     * 修改店铺详情
     * @param storePO
     * @return Integer
     */
    Integer updateStoreById(@Param("storePO")StorePO storePO);
}
