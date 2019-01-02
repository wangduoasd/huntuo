//package com.kaituo.huntuo.service.impl;
//
//import com.kaituo.huntuo.domain.dto.EvAndELRelationDTO;
//import com.kaituo.huntuo.domain.dto.EvaluateLableDTO;
//import com.kaituo.huntuo.domain.dto.ProductEvaluateDTO;
//import com.kaituo.huntuo.domain.po.ELRelationPO;
//import com.kaituo.huntuo.domain.po.LablePO;
//import com.kaituo.huntuo.domain.po.ProductEvaluatePO;
//import com.kaituo.huntuo.service.EvaluateService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
///**
// * 商品评价管理测试类
// * @author songchen
// * @date 2018/9/12
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class EvaluateServiceImplTest {
//
//    @Autowired
//    EvaluateService evaluateService;
//    @Test
//    public void insertLable() {
//        EvaluateLableDTO evaluateLableDTO = EvaluateLableDTO.builder().build();
//        evaluateLableDTO.setLableName("不好");
//        evaluateService.insertLable(evaluateLableDTO);
//
//    }
//
//    @Test
//    public void deleteLable() {
//        evaluateService.deleteLable(1);
//    }
//
//    @Test
//    public void getLableByTime() {
//       List<LablePO> list = evaluateService.getLableByTime();
//        for (LablePO po:list) {
//            System.out.println(po);
//        }
//
//    }
//
//    @Test
//    public void insertEvaluate(){
//        ProductEvaluateDTO productEvaluatePO = ProductEvaluateDTO.builder().build();
//        productEvaluatePO.setRank(5);
//        productEvaluatePO.setContent("非常好");
//        productEvaluatePO.setPics("hcdc98y2r3ch32.jpg");
//        productEvaluatePO.setLableId(3);
//        evaluateService.insertEvaluate(productEvaluatePO);
//    // evaluateService.insertEvaluateLable(evaluateLablePO);
//    }
//    @Test
//    public void getEvaluateByProductId(){
//        List<ProductEvaluatePO> list = evaluateService.getEvaluateByProductId(1);
//        for (ProductEvaluatePO evaluatePO:list){
//            System.out.println(evaluatePO);
//        }
//    }
//    @Test
//    public void deleteEvaluate() {
//        ProductEvaluatePO productEvaluatePO = ProductEvaluatePO.builder().build();
//        productEvaluatePO.setId(1);
//        evaluateService.deleteEvaluate(productEvaluatePO);
//    }
//
//    @Test
//    public void getEvAndELRelation() {
//        List<EvAndELRelationDTO> list = evaluateService.getEvAndELRelation(1,1);
//        for (EvAndELRelationDTO s:list
//                ) {
//            System.out.println(s);
//        }
//    }
//}