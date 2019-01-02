package com.kaituo.huntuo.dao;

import com.kaituo.huntuo.domain.po.KeyWordPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author @chnxy_xrabbit
 * @date 2018/9/25 10:22
 */
@Mapper
public interface KeyWordDao {
    /**
     * 添加搜索关键词（用于热搜词排序）
     * 数据库中不存在则插入，返回插入的id;存在则不插入，返回 0;
     * 默认sort_no:0,time:1;
     * @param keyWordPO(keyWord,type)
     */
    void addKeyWord(@Param("keyWordPO")KeyWordPO keyWordPO);

    /**
     * 每次搜索已存在的关键词，增加Times（搜索次数）
     * @param keyWordPO
     */
    void updateTimes(@Param("keyWordPO")KeyWordPO keyWordPO);

    /**
     * 定时删除冗余数据
     */
    void deleteKeyword();
}
