package com.kaituo.huntuo.domain.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author wangduo
 * @date 2018/9/10 - 10:51
 */
@Data
@Builder
public class SelectLableRequest implements Serializable {
    /**
     * 标签组名称
     */
    @NotBlank(message = "标签组名称不能为空")
    private String groupName;

    List<LableRequest> lableRequests;
}
