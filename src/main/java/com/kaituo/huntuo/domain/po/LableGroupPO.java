package com.kaituo.huntuo.domain.po;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * @author wangduo
 * @date 2018/9/4 - 11:14
 */
@Data
@Builder
public class LableGroupPO {
    /**
     * 标签组id
     */

    private Integer id;
    /**
     * 标签组名称
     */
    private String groupName;
    /**
     *类别id
     */
     private Integer cateId;
    /**
     * 排序
     */
    private Integer sortNo;
    private Date createTime;
    private Date updateTime;


}
