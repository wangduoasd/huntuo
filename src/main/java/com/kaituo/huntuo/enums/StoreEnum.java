package com.kaituo.huntuo.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author @chnxy_xrabbit
 * @date 2018/9/10 10:45
 */
@Getter
public enum StoreEnum {

    STATE_LOCK(-1,"现状态锁定"),
    STATE_UNLOCK(1,"现状态正常")
    ;

    private Integer code;
    private String msg;

    StoreEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
