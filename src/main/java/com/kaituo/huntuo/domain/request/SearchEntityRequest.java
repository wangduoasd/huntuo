package com.kaituo.huntuo.domain.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhoulian
 * @date 2018/8/24
 * Created by idea 2018.1
 */
@Data
public class SearchEntityRequest {
    /**
     * 当前页码,每页显示数量
     * pageNo:1,pageSize:20
     */
    private String page ;
    /**
     * 筛选
     * eg: lableName:红色,黑色,蓝色;薄款,厚款?styleId:1,2,3?cateId:1?cateType:1?showPrice:10,200?keyword:拉面?plateNumber:123456789
     */
    @NotBlank(message = "参数缺失：chooses不能为空")
    private String chooses;

    /**
     * 多排序格式 order=show_price:1,order_num:0,rank:1;
     * 0 降序，1 升序
     */
    private String order;
    /**
     * 关键词是否高亮
     */
    private Boolean highLight = false;

    private String highLightHead = "<span style='color:red'>";
    private String highLightTail = "</span>";

}
