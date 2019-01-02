package com.kaituo.huntuo.domain.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author @chnxy_xrabbit
 * @date 2018/9/26 9:24
 */
@Data
@Builder
public class CreateKeyWordRequest {

    @NotBlank(message = "参数缺失：keyWord不能为空")
    private String  keyWord;
    /**
     * 搜索类型
     * 1服务2商品3店铺
     */
    @NotNull(message = "参数缺失：type不能为空")
    private int type;
}
