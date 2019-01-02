package com.kaituo.huntuo.utils;

import lombok.Data;

import java.util.List;

/**
 * 分页工具类
 * @author zhoulian
 * @date 2018/8/29
 * Created by idea 2018.1
 */
@Data
public class PagerUtil<T> {
    private static final int DEFAULT_PAGESIZE = 10;//默认分页的每页显示的条数
    private static final int DEFAULT_PAGENUM = 5;//默显示页码的数量

    /**
     * currentPage 当前页
     */
    private int currentPage = 1;
    /**
     * pageSize 每页大小
     */
    private int pageSize = 10;
    /**
     * pageTotal 总页数
     */
    private int pageTotal;
    /**
     * recordTotal 总条数
     */
    private int recordTotal = 0;

    /**
     * list 每页的内容
     */
    private List<T> list;

    public PagerUtil() {

    }
    /**构造函数，初始化分页的信息，自动修正
     * @param currentPage 当前的页码
     * @param recordTotal   总记录数
     * @param pageSize  分页每页显示的条数
     */
    public PagerUtil(Integer currentPage, Integer pageSize, Integer recordTotal){
        this.currentPage = currentPage;
        this.recordTotal = recordTotal;
        this.pageSize = pageSize < 1 ? PagerUtil.DEFAULT_PAGESIZE : pageSize;
        if(this.currentPage < 1) {
            this.currentPage = 1;
        }

        // 总页数
        this.pageTotal = this.recordTotal % this.pageSize > 0 ? this.recordTotal / this.pageSize + 1 : this.recordTotal / this.pageSize;

    }

    @Override
    public String toString() {
        return "PagerUtil [currentPage=" + currentPage + ", pageSize=" + pageSize
                + ", pageTotal=" + pageTotal + ", recordTotal=" + recordTotal
                + ", content=" + list + "]";
    }
}
