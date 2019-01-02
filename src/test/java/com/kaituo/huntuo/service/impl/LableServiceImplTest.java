//package com.kaituo.huntuo.service.impl;
//
//import com.kaituo.huntuo.domain.dto.LableDTO;
//import com.kaituo.huntuo.domain.dto.LableGroupDTO;
//import com.kaituo.huntuo.domain.po.LableGroupPO;
//import com.kaituo.huntuo.domain.request.SelectLableRequest;
//import com.kaituo.huntuo.service.LableService;
//import com.sun.media.jfxmedia.logging.Logger;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
///**
// * @author wangduo
// * @date 2018/9/5 - 10:32
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class LableServiceImplTest {
//    @Autowired
//    private LableService lableService;
//
//    /**
//     * 添加标签组
//     */
//    @Test
//    public void createLG() {
//        LableGroupDTO lableGroupDTO= LableGroupDTO .builder ()
//                .groupName ("拉拉")
//                .cateId (2)
//                .sortNo (5)
//                .build ();
//
////        LableGroupDTO result=lableService.createLG (lableGroupDTO);
////        Assert.assertNotNull(result);
//    }
//    /**
//     * 删除标签组
//     */
//    @Test
//    public void deleteLG() {
//       lableService.deleteLG (4);
//    }
//
//    /**
//     * 添加标签
//     */
//    @Test
//    public void create() {
//        LableDTO lableDTO= LableDTO .builder ()
//                .lableName ("拉拉")
//                .lableGroupId (2)
//                .sortNo (5)
//                .build ();
//
////        LableDTO result=lableService.create (lableDTO);
////        Assert.assertNotNull(result);
//    }
//
//    /**
//     * 删除标签
//     */
//    @Test
//    public void delete() {
//        //todo
//        lableService.delete (5);
//    }
//
//    @Test
//    /**
//     * 查询所有标签组中标签按标签顺序和标签组顺序
//     */
//    public void getAll() {
//        List<SelectLableRequest>  lableGroupDTO= lableService.getAll (1);
//        log.info (lableGroupDTO.toString ());
//    }
//}