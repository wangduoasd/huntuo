package com.kaituo.huntuo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@Slf4j
@EnableScheduling//spring 注解执行定时任务:
public class HuntuoApplication {
    public static void main(String[] args) {
        SpringApplication.run(HuntuoApplication.class, args);
    }

}
