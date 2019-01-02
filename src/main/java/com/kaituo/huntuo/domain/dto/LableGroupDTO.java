package com.kaituo.huntuo.domain.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author wangduo
 * @date 2018/9/5 - 13:50
 */
@Data
@Builder
public class LableGroupDTO implements Serializable {
    /**
     * 标签组名称
     */
    @NotBlank(message = "标签组名称不能为空")
    private String groupName;
    /**
     *类别id
     */
    @NotNull(message = "标签组中类别id不能为空")
    private Integer cateId;
    /**
     * 排序
     */
    @NotNull(message ="标签组中排序序号不能为空")
    private Integer sortNo;


}
