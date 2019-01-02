package com.kaituo.huntuo.domain.po;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author @chnxy_xrabbit
 * @date 2018/9/25 10:34
 */
@Data
@Builder
public class KeyWordPO {
    /**
     * 关键词id
     */
    private  int id;
    /**
     * 搜索词
     */
    private String  keyWord;
    /**
     * 搜索类型
     * 1服务2商品3店铺
     */
    private int type;
    /**
     * 搜索次数
     */
    private int times;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 更新时间
     */
    private Date update_time;
}
