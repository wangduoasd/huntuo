package com.kaituo.huntuo.domain.dto;

import com.kaituo.huntuo.domain.po.ELRelationPO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.sql.Timestamp;
import java.util.List;
/**
 * 评价类和评价关联类
 * @author songchen
 * @date 2018/9/12
 */
@Data
@Builder
public class EvAndELRelationDTO {
    /**
     * 商品评价id
     */
    private int id;
    /**
     * 评价内容
     */
    private String content;
    /**
     * 图片路径，逗号分隔
     */
    private String pics;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 昵称，冗余字段
     */
    private String nickName;
    /**
     * 订单id
     */
    private int orderId;
    /**
     * 订单编号
     */
    private String orderSn;
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 等级1--5星
     */
    private int rank;
    /**
     * 回复内容
     */
    private String replyContent;
    /**
     * 回复时间
     */
    private Timestamp replyTime;
    /**
     * 评价时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp updateTime;
    /**
     *状态:  正常、审核中、隐藏
     */
    private int state;
    /**
     *ELRelationPO表集合
     */
    private List<ELRelationPO> elRelationPOList;

}
