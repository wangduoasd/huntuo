package com.kaituo.huntuo.utils;

import com.kaituo.huntuo.domain.response.BaseResponse;
import com.kaituo.huntuo.enums.ResultEnum;

/**
 * @author zhoulian
 * @date 2018/8/22
 * Created by idea 2018.1
 */
public class ResultUtil {
    public static BaseResponse success(Object object) {
        BaseResponse response = new BaseResponse();
        response.setCode(ResultEnum.SUCCESS.getCode());
        response.setMsg(ResultEnum.SUCCESS.getMsg());
        response.setData(object);
        return response;
    }
    public static BaseResponse success(Integer code,String msg,Object object) {
        BaseResponse response = new BaseResponse();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(object);
        return response;
    }
    public static BaseResponse success() {
        return success(null);
    }

    public static BaseResponse error(Integer code, String msg) {
        BaseResponse response = new BaseResponse();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
