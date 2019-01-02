package com.kaituo.huntuo.domain.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kaituo.huntuo.domain.po.LableGroupPO;
import com.kaituo.huntuo.domain.po.LablePO;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @author wangduo
 * @date 2018/9/4 - 14:10
 */
@Data
@Builder
public class LableDTO implements Serializable {
    /**
     *标签id
     */
    private Integer id;
    /**
     * 标签名称
     */
    @NotBlank(message="标签名不能为空")
    private String lableName;
    /**
     *标签组id
     */
    @NotNull(message = "标签中的标签组id不能为空")
    private Integer lableGroupId;
    /**
     * 排序序号
     */
    @NotNull(message = "标签中排序序号不能为空")
    private  Integer sortNo;

}
