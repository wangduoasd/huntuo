//package com.kaituo.huntuo.service;
//
//import com.kaituo.huntuo.domain.dto.StoreDTO;
//import com.kaituo.huntuo.domain.po.StorePO;
//import com.kaituo.huntuo.domain.request.CreateStoreRequest;
//import com.kaituo.huntuo.domain.request.SearchStoreRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
///**
// * @author @chnxy_xrabbit
// * @date 2018/9/5 11:17
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class StoreManageServiceTest {
//    @Autowired
//    StoreManageService storeManageService;
//    /**
//     * 按ID查询店铺详情
//     */
//    @Test
//    public void getStorePOById() {
//        StoreDTO storeDTO=storeManageService.getStoreDTOById(1);
//        System.out.println(storeDTO.toString());
//    }
//    /**
//     * 修改店铺状态
//     */
//    @Test
//    public void updateStoreStateById() {
//        storeManageService.updateStoreStateById(1);
//    }
//    /**
//     * 添加店铺
//     */
//    @Test
//    public void addStore(){
//        CreateStoreRequest request=CreateStoreRequest.builder()
//                .storeName("阿凡提")
//                .tel("123456789")
//                .workTime("24")
//                .description("good")
//                .cityId(2)
//                .position("西青区")
//                .address("中北镇")
//                .rank(0)
//                .notice("开业啦")
//                .state(1)
//                .build();
//        Integer id=storeManageService.addStore(request);
//        log.info("id="+id);
//    }
//    /**
//     * 修改店铺详情
//     */
//    @Test
//    public void updateStoreById(){
//        CreateStoreRequest request=CreateStoreRequest.builder()
//                .id(33)
//                .storeName("阿凡提拉面")
//                .tel("1234567891")
//                .workTime("241")
//                .description("good1")
//                .cityId(21)
//                .position("西青区1")
//                .address("中北镇1")
//                .rank(1)
//                .notice("开业啦1")
//                .state(-1)
//                .build();
//        storeManageService.updateStoreById(request);
//    }
//    /**
//     * 关键词搜索店铺
//     */
//    @Test
//    public void search() {
//        SearchStoreRequest searchStoreRequest=new SearchStoreRequest();
//        searchStoreRequest.setKeyWord("拉面");
//    }
//    }