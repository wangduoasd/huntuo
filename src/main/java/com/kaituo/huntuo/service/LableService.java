package com.kaituo.huntuo.service;

import com.kaituo.huntuo.domain.dto.LableDTO;
import com.kaituo.huntuo.domain.dto.LableGroupDTO;
import com.kaituo.huntuo.domain.request.SelectLableRequest;

import java.util.List;


/**
 * @author wangduo
 * @date 2018/9/4 - 14:03
 */
public interface LableService {

    /**
     * 添加标签
     * @param lableDTO
     * @return
     */
    int create (LableDTO lableDTO);

    /**
     * 删除标签
     * @param id
     */
    void delete(Integer id);

    /**
     * 查询
     * @param cateId
     * @return
     */
    List<SelectLableRequest> getAll(Integer cateId);
    /**
     * 添加标签组
     * @param lableGroupDTO
     * @return
     */
    int createLG (LableGroupDTO lableGroupDTO);

    /**
     * 删除标签组
     * @param id
     */
    void deleteLG(Integer id);
}
