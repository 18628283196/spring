package com.itheima.pojo;

import java.util.List;

public class PageBean {
    private Long total;//总记录数
    private Long totalPage;//总页码数
    private Long currentPage;//当前页
    private int rows;//每页显示行数
    private List<user> list;//每页查询的数据

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                ", list=" + list +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<user> getList() {
        return list;
    }

    public void setList(List<user> list) {
        this.list = list;
    }

    public PageBean(Long total, Long totalPage, Long currentPage, int rows, List<user> list) {

        this.total = total;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.rows = rows;
        this.list = list;
    }

    public PageBean() {

    }
}
