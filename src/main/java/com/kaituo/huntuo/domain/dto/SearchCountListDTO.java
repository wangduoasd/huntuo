package com.kaituo.huntuo.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author @chnxy_xrabbit
 * @date 2018/10/17 11:28
 */
@Data
@Builder
public class SearchCountListDTO {
    /**
     * 搜索类型 1服务2商品3店铺0全部
     */
    private Integer cate_type;
    /**
     *  searchCountDTO集合
     */
    private List<SearchCountDTO> searchCountDTOList;
}
