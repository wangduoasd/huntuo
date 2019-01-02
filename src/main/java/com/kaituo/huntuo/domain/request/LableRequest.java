package com.kaituo.huntuo.domain.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wangduo
 * @date 2018/9/10 - 15:02
 */
@Data
@Builder
public class LableRequest implements Serializable {
    /**
     *标签id
     */
    private Integer id;
    /**
     * 标签名称
     */
    @NotBlank(message="标签名不能为空")
    private String lableName;
}
