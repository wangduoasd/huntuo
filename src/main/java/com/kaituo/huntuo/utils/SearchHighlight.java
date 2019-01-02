package com.kaituo.huntuo.utils;

import com.kaituo.huntuo.domain.dto.SearchDTO;
import com.kaituo.huntuo.domain.request.SearchEntityRequest;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author @chnxy_xrabbit
 * @date 2018/10/8 10:58
 */
public class SearchHighlight {
    public static void   highlight(SearchEntityRequest request, SolrQuery params, String name){
        if (true == request.getHighLight()) {
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField(name);
            //设置前缀
            params.setHighlightSimplePre(request.getHighLightHead());
            //设置后缀
            params.setHighlightSimplePost(request.getHighLightTail());
        }
    }
    public static List highilight(SearchEntityRequest request, String name, QueryResponse queryResponse
    , SolrDocumentList results, List list){
        //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
        Map<String, Map<String, List<String>>> highlight = new HashMap<>();
        if (true == request.getHighLight()) {
            highlight = queryResponse.getHighlighting();
        }
        list= new ArrayList<>();

        for (SolrDocument result : results) {
            SearchDTO searchDTO = SearchDTO.builder().build();
            String id = (String) result.getFieldValue("id");
            String storeName = (String) result.getFieldValue(name);
            searchDTO.setId(Integer.valueOf(id));
            searchDTO.setName(storeName);

            // 查找高亮词
            if (true == request.getHighLight() && highlight.size() > 0) {
                Map<String, List<String>> map = highlight.get(result.get("id"));
                if (null == map || map.isEmpty()) {
                    list.add(searchDTO);
                    continue;
                }
                List<String> mapList = map.get(name);
                if (null != mapList) {
                    searchDTO.setName(mapList.get(0));
                }
            }
            list.add(searchDTO);
        }
        return list;
    }
    public static String  filterString(SolrQuery params,String chooses,String queryWord,String order){
        String[]  cs=chooses.split("\\?");
        for(int i=0;i<cs.length;i++){
            if(cs[i].contains("lableName")){
                cs[i]=cs[i].replaceAll("lableName:","(");
                cs[i]=cs[i].replaceAll(",","OR");
                cs[i]=cs[i].replaceAll(";",")AND(");
                StringBuilder sb = new StringBuilder(cs[i]);
                cs[i]=sb.insert(sb.length(),")").toString();
                queryWord=queryWord+cs[i].toString();
            }
            if(cs[i].contains("styleId")){
                cs[i]=cs[i].replaceAll("styleId","style_id");
                cs[i]=cs[i].replaceAll(","," OR style_id:");
                params.addFilterQuery(cs[i]);
            }
            if(cs[i].contains("cateId")){
                cs[i]=cs[i].replaceAll("cateId","cate_id");
                params.addFilterQuery(cs[i]);
            }
            if(cs[i].contains("cateType")){
                cs[i]=cs[i].replaceAll("cateType","cate_type");
//                cateType=cs[i].replaceAll("cateType:","");
                params.addFilterQuery(cs[i]);
            }
            if(cs[i].contains("showPrice")){
                cs[i]=cs[i].replaceAll("showPrice:","show_price:[");
                cs[i]=cs[i].replaceAll(","," TO ");
                StringBuilder sb = new StringBuilder(cs[i]);
                cs[i]=sb.insert(sb.length(),"]").toString();
                params.addFilterQuery(cs[i]);
            }
            if(cs[i].contains("keyword")){
                cs[i]=cs[i].replaceAll("keyword:","");
                queryWord=queryWord+cs[i].toString();
            }
            if(cs[i].contains("plateNumber")){
                cs[i]=cs[i].replaceAll("plateNumber:","");
                queryWord=queryWord+cs[i].toString();
            }
        }
        //排序 0降序，1升序 默认无排序
        //价格排序
        if(order!=""){
            order=order.replaceAll("showPrice","show_price");
            order=order.replaceAll("orderNum","order_num");
            String[]  od=order.split(",|:");
            for(int i=0;i<od.length;i++){
                System.out.println(od[i+1]);
                System.out.println(od[i]);
                if(od[i+1].equals("0")){
                    params.addSort(od[i].toString(), SolrQuery.ORDER.desc);
                }
                if(od[i+1].equals("1")){
                    params.addSort(od[i].toString(), SolrQuery.ORDER.asc);
                }
                i++;
            }
        }
        return queryWord;
    }
    //判断字符串是否为纯数字
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static void page(String page,SolrQuery params,Integer pageNo,Integer pageSize){

        if(page!=""){
            if(page.contains("pageNo")){
                int index=page.lastIndexOf("pageNo:")+"pageNo:".length();
                String no=page.substring(index,index+1);
                if(SearchHighlight.isNumeric(no)){
                    if(Integer.valueOf(no)>0){
                        pageNo=Integer.valueOf(no);
                    }
                }
            }
            if(page.contains("pageSize")){
                int index=page.lastIndexOf("pageSize:")+"pageSize:".length();
                String no=page.substring(index,index+1);
                if(SearchHighlight.isNumeric(no)){
                    if(Integer.valueOf(no)>0){
                        pageSize=Integer.valueOf(no);
                    }
                }
            }
        }
        params.setStart((pageNo -1 ) * pageSize);
        params.setRows(pageSize);
    }
}
