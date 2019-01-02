package com.kaituo.huntuo.domain.po;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.sql.Timestamp;
import java.util.List;
/**
 * 评价关联类
 * @author songchen
 * @date 2018/9/12
 */
@Data

public class ELRelationPO {
    /**
     * 评价关联表id
     */
    private Integer id;
    /**
     * 标签id
     */
    private Integer lableId;
    /**
     * 评价id
     */
    private Integer evaluateId;
    /**
     * 评价时间
     */
    private Timestamp createTime;

}
