package com.kaituo.huntuo.utils;

import com.kaituo.huntuo.service.KeyWordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
/**
 * spring 注解执行定时任务;
 * @author @chnxy_xrabbit
 * @date 2018/9/26 15:22
 */
@Slf4j
@Service
public class ScheduledUtil {
    @Autowired
    private KeyWordService keyWordService;
    /**
     * spring 注解执行定时任务;
     */
    @Scheduled(cron = "0/30 * * * * *")
    public void updateSolrStore(){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("command", "delta-import");
        postParameters.add("verbose", "false");
        postParameters.add("clean", "false");
        postParameters.add("commit", "true");
        postParameters.add("core", "store");
        postParameters.add("name", "dataimport");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<MultiValueMap<String, Object>> r = new HttpEntity<>(postParameters, headers);
        String time = String.valueOf(System.currentTimeMillis());
        String url = "http://192.168.3.252:8983/solr/store/dataimport?_=" + time + "&indent=on&wt=json";
        String responseMessage = restTemplate.postForObject(url, r, String.class);
       // log.info("更新solr索引：返回值：{}",responseMessage);
    }
    @Scheduled(cron = "0/30 * * * * *")
    public void updateSolrProduct(){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("command", "delta-import");
        postParameters.add("verbose", "false");
        postParameters.add("clean", "false");
        postParameters.add("commit", "true");
        postParameters.add("core", "product");
        postParameters.add("name", "dataimport");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<MultiValueMap<String, Object>> r = new HttpEntity<>(postParameters, headers);
        String time = String.valueOf(System.currentTimeMillis());
        String url = "http://192.168.3.252:8983/solr/product/dataimport?_=" + time + "&indent=on&wt=json";
        String responseMessage = restTemplate.postForObject(url, r, String.class);
        // log.info("更新solr索引：返回值：{}",responseMessage);
    }
    @Scheduled(cron = "0/30 * * * * *")
    public void updateSolrSuggest(){
        RestTemplate restTemplate = new RestTemplate();//RestTemplate提供了多种便捷访问远程Http服务的方法,能够大大提高客户端的编写效率。
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("command", "delta-import");
        postParameters.add("verbose", "false");
        postParameters.add("clean", "false");
        postParameters.add("commit", "true");
        postParameters.add("core", "keyword");
        postParameters.add("name", "dataimport");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<MultiValueMap<String, Object>> r = new HttpEntity<>(postParameters, headers);
        String time = String.valueOf(System.currentTimeMillis());
        String url = "http://192.168.3.252:8983/solr/keyword/dataimport?_=" + time + "&indent=on&wt=json";
        String responseMessage = restTemplate.postForObject(url, r, String.class);
        log.info("更新solr索引：返回值：{}",responseMessage);
    }
    public void deletekeyword(){
        keyWordService.delete_keyword ();
    }
}
