package com.kaituo.huntuo.enums;

import lombok.Getter;

/**
 * 返回结果状态码枚举类
 * @author zhoulian
 * @date 2018/8/22
 * Created by idea 2018.1
 */
@Getter
public enum ResultEnum {

    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    EMPTY(100, "结果为空"),
    NOEXIT(97, "类型不存在"),
    NO_STATE(96,"状态不存在"),
    //商品评价的异常
    LABLE_NAME_EMPTY(2,"输入参数为空"),
    LABLE_EMPTY(3,"标签表内容为空"),
    EVALUATEID_EMPTY(4,"评价id为空"),
    PRODUCTID_EMPTY(5,"输入参数为空或不存在"),
    PARAM_EMPTY(99,"参数为空"),
    DEL_FULL(98,"数据已被关联")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
