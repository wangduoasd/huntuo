package com.kaituo.huntuo.service.impl;

import com.kaituo.huntuo.dao.LableDao;
import com.kaituo.huntuo.dao.LableGroupDao;
import com.kaituo.huntuo.domain.dto.LableDTO;
import com.kaituo.huntuo.domain.dto.LableGroupDTO;
import com.kaituo.huntuo.domain.po.LableGroupPO;
import com.kaituo.huntuo.domain.po.LablePO;
import com.kaituo.huntuo.domain.request.SelectLableRequest;
import com.kaituo.huntuo.domain.request.LableRequest;
import com.kaituo.huntuo.enums.ResultEnum;
import com.kaituo.huntuo.exception.HuntuoException;
import com.kaituo.huntuo.service.LableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangduo
 * @date 2018/9/5 - 17:20
 */
@Service
@Slf4j
public class LableServiceImpl implements LableService{
    @Autowired
    private LableDao lableDao;
    @Autowired
    private LableGroupDao lableGroupDao;
    /**
     * 添加标签
     * @param lableDTO
     * @return
     */
    @Override
    public int create(LableDTO lableDTO) {
            LablePO lablePO=LablePO.builder ()
                    .lableName (lableDTO.getLableName ())
                    .lableGroupId (lableDTO.getLableGroupId ())
                    .sortNo (lableDTO.getSortNo ())
                    .build ()
                    ;
            try {
                lableDao.insertlable (lablePO);

                //ctrl+alt+T
            } catch (HuntuoException e) {
                throw new HuntuoException(ResultEnum.EMPTY);
            }
            int id=lablePO.getId ();
            return id;
    }

    /**
     * 删除标签
     * @param id
     */
    @Override
    public void delete(Integer id) {
        //todo
        if (id==null){
            throw new HuntuoException (ResultEnum.PARAM_EMPTY);
        }
        //验证是否有商品再使用此标签，再删除此标签
        lableDao.deleteByKeylable (id);
    }
    /**
     * 查询标签
     * @param cateId
     * @return
     */
    @Override
    public List<SelectLableRequest> getAll(Integer cateId){
        if(cateId==null){
            throw new HuntuoException (ResultEnum.PARAM_EMPTY);
        }
        List<LableGroupPO> lableGroupPO;
        List<SelectLableRequest> selectLableRequestslist=new ArrayList<> ();
        try {
              lableGroupPO = lableGroupDao.selectBycateId (cateId);
        } catch (HuntuoException e) {
           throw new HuntuoException (ResultEnum.EMPTY);
        }

        //将标签组po集合取出遍历出标签放入list中

        for ( LableGroupPO lableGroupPOlist:lableGroupPO){
            List<LableRequest> lableRequest =new ArrayList<> ();
            List<LablePO> lablePO= null;
            try {
                lablePO = lableDao.selectByGroupId (lableGroupPOlist.getId ());
            } catch (Exception e) {
                e.printStackTrace ();
            }
            //将标签po集合取出遍历出标签放入list中
            for (LablePO lablePo:lablePO){
                //标签的po转成dto
                LableRequest lableRequestlists = LableRequest.builder()
                        .id (lablePo.getId ())
                        .lableName (lablePo.getLableName ())
                        .build();
                //将标签其放入到dto集合
                lableRequest.add (lableRequestlists);
            }
            //标签的po和dto的转换
            SelectLableRequest selectLableRequest=SelectLableRequest.builder ()
                    .lableRequests (lableRequest)
                    //.id (lableGroupPOlist.getId ())
                    .groupName (lableGroupPOlist.getGroupName ())
                    .build ();
            //将标签组其放入到dto集合
            selectLableRequestslist.add (selectLableRequest);
        }

        return selectLableRequestslist;
    }

    /**
     * 添加标签组
     * @param lableGroupDTO
     * @return
     */
    @Override
    public int createLG(LableGroupDTO lableGroupDTO) {
        LableGroupPO lableGroupPO=LableGroupPO.builder ()
                .groupName (lableGroupDTO.getGroupName ())
                .cateId (lableGroupDTO.getCateId ())
                .sortNo (lableGroupDTO.getSortNo ())
                .build ()
                ;
        try {
            lableGroupDao.insertlablegroup (lableGroupPO);//ctrl+alt+T
        } catch (HuntuoException e) {
            throw new HuntuoException(ResultEnum.EMPTY);
        }
        int id=lableGroupPO.getId ();
        return id;
    }

    /**
     * 删除标签组
     * @param id
     */
    @Override
    public void deleteLG(Integer id) {
        //todo
        //验证是否有标签使用此标签组，再执行删除
        if (id==null){
            throw new HuntuoException (ResultEnum.PARAM_EMPTY);
        }
        if(lableDao.selectByGroupId (id).size ()>0){
            throw new HuntuoException (ResultEnum.DEL_FULL);
        }
            lableGroupDao.deleteByKeylablegroup (id);

    }

}
