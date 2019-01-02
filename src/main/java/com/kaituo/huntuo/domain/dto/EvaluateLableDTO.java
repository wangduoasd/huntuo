package com.kaituo.huntuo.domain.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class EvaluateLableDTO {
    @NotBlank(message = "参数缺失：lableName不能为空")
    private String lableName;

    private Integer id;
}
