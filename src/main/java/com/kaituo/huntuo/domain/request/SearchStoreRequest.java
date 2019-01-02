package com.kaituo.huntuo.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author @chnxy_xrabbit
 * @date 2018/9/11 16:02
 */
@Data
public class SearchStoreRequest {
    /**
     * 当前页码
     */
    private Integer pageNo = 1;

    /**
     * 每页显示数量
     */
    private Integer pageSize = 20;

    /**
     * 搜索词
     */
    @NotBlank(message = "参数缺失：keyWord不能为空")
    private String keyWord;

    /**
     * 排序方式, 0 降序，1 升序
     */
    private Integer sort = 0;

    /**
     * 排序字段 price/comment/default/star
     */
    private String orderBy;

    /**
     * 关键词是否高亮
     */
    private Boolean highLight = true;

    private String highLightHead = "<span style='color:red'>";
    private String highLightTail = "</span>";
}
