package com.kaituo.huntuo.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author @chnxy_xrabbit
 * @date 2018/10/8 9:36
 */
@Data
public class SearchRequest {
    /**
     * 搜索词
     */
    @NotBlank(message = "参数缺失：keyWord不能为空")
    private String keyWord;
    /**
     *类型，1服务2商品
     */
    @NotNull(message = "参数缺失：cateType不能为空")
    private Integer cateType;
    /**
     * 当前页码
     */
    private Integer pageNo = 1;
    /**
     * 每页显示数量
     */
    private Integer pageSize = 20;
    /**
     * 关键词是否高亮
     */
    private Boolean highLight = false;

    private String highLightHead = "<span style='color:red'>";
    private String highLightTail = "</span>";
}
