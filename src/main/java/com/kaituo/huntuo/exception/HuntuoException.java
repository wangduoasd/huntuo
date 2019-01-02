package com.kaituo.huntuo.exception;

import com.kaituo.huntuo.enums.ResultEnum;
import lombok.Data;

import java.io.IOException;

/**
 * 统一异常处理
 * @author zhoulian
 * @date 2018/8/23
 * Created by idea 2018.1
 */
@Data
public class HuntuoException extends RuntimeException  {
    private Integer code;

    public HuntuoException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
