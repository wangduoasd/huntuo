package com.kaituo.huntuo.dao;

import com.kaituo.huntuo.domain.po.ProductPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品dao
 * @author zhoulian
 * @date 2018/8/22
 * Created by idea 2018.1
 */
@Mapper
public interface ProductDao {
    ProductPO getById(@Param("productId") Integer id);
    Integer insertAndGetId(ProductPO productPO);
}

