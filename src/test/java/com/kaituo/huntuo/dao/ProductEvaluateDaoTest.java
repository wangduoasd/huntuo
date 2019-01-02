//package com.kaituo.huntuo.dao;
//
//import com.kaituo.huntuo.domain.dto.EvAndELRelationDTO;
//import com.kaituo.huntuo.domain.po.ELRelationPO;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProductEvaluateDaoTest {
//    @Autowired
//   ProductEvaluateDao productEvaluateDao;
//    @Test
//    public void getEvAndELRelation() {
//        List<EvAndELRelationDTO> list = productEvaluateDao.getEvAndELRelation(1,1);
//        for (EvAndELRelationDTO s:list
//             ) {
//            System.out.println(s);
//        }
//    }
//
//    @Test
//    public void getEvaluateByProductId() {
//
//        productEvaluateDao.getEvaluateByProductId(1);
//    }
//}