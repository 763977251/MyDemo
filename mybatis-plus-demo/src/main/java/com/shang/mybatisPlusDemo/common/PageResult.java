package com.shang.mybatisPlusDemo.common;

import java.util.List;

public class PageResult<T> {
    private Integer total;
    private List<T> list;

    public PageResult() {
    }

    public PageResult(Integer total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
