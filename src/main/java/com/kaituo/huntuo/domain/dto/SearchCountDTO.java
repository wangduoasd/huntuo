package com.kaituo.huntuo.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author @chnxy_xrabbit
 * @date 2018/10/15 16:46
 */
@Data
@Builder
public class SearchCountDTO {
    /**
     * 分类id
     */
    private Integer cateId;
    /**
     * 数量
     */
    private Long Count;

}
