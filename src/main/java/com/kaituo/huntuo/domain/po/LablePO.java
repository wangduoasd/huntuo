package com.kaituo.huntuo.domain.po;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

/**
 * @author wangduo
 * @date 2018/9/4 - 11:08
 */
@Data
@Builder
public class LablePO{
    /**
     *标签id
     */
    private Integer id;
    /**
     * 标签名称
     */
    private String lableName;
    /**
     *标签组id
     */
    private Integer lableGroupId;
    /**
     * 排序序号
     */
    private  Integer sortNo;
    private Date createTime;
    private Date updateTime;
}
