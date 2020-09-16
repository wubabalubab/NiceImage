package com.example.bean;

import java.util.List;

public class ImageClassify {
    private List<ImageBean> data;

    private int page;

    private int page_count;

    private int status;

    private int total_counts;

    public List<ImageBean> getData() {
        return data;
    }

    public void setData(List<ImageBean> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal_counts() {
        return total_counts;
    }

    public void setTotal_counts(int total_counts) {
        this.total_counts = total_counts;
    }
}
