package com.itheima.pojo;

import java.util.List;

public class PageBean {
    private Long total;
    private List<User1> rows;

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<User1> getRows() {
        return rows;
    }

    public void setRows(List<User1> rows) {
        this.rows = rows;
    }

    public PageBean(long total, List<User1> rows) {

        this.total = total;
        this.rows = rows;
    }

    public PageBean() {

    }
}
