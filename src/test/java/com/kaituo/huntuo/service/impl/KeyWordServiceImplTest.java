package com.kaituo.huntuo.service.impl;

import com.kaituo.huntuo.service.KeyWordService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangduo
 * @date 2018/10/17 - 17:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KeyWordServiceImplTest {
    @Autowired
    KeyWordService keyWordService;
    public  void aa(String str){
        str="aaaaa";
    }
    @Test
    public void searchKeyword() {
            String str="ssss";
            str="111";
            aa(str);
            System.out.println (str);

    }
}