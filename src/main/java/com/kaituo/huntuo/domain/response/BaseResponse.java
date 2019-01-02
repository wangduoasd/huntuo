package com.kaituo.huntuo.domain.response;

import lombok.Data;

/**
 *
 * @author zhoulian
 * @date 2018/8/23
 * Created by idea 2018.1
 */
@Data
public class BaseResponse {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体的内容
     */
    private Object data;
}
