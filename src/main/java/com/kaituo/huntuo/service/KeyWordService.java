package com.kaituo.huntuo.service;

import com.kaituo.huntuo.exception.HuntuoException;
import net.sf.jsqlparser.statement.select.First;

import java.util.List;

/**
 * 关键词service层
 * @author @chnxy_xrabbit
 * @date 2018/9/25 11:37
 */

public interface KeyWordService {
    /**
     * 添加搜索关键词（用于热搜词排序），数据库中不存在则插入;
     * 存在则不插入,每次搜索已存在的关键词，增加Times（搜索次数）
     * 默认sort_no:0,time:1;
     * @param keyword
     * @param type
     * @return Integer 返回操作id
     * @throws HuntuoException
     */
    Integer addKeyWordOrUpdateTimes(String keyword,Integer type)throws HuntuoException;
    List<String> searchKeyword(String htmlword) throws HuntuoException ;
    void delete_keyword() throws HuntuoException;
}
