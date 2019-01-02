package com.kaituo.huntuo.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author @chnxy_xrabbit
 * @date 2018/10/8 10:23
 */
@Data
@Builder
public class SearchDTO {

    /**
     * 商铺ID
     */
    private Integer id;
    /**
     * 商铺名称
     */
    private String Name;

}
