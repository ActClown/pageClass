package com.syp.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syp on 2017-11-21.
 * 页面显示的模型：
 */
public class Page {
    private Integer currentPage;
    private Integer prevPage;
    private Integer nextPage;
    private List<User> showUsers =new ArrayList<User>();
    private List<Integer> showPageNums =new ArrayList<Integer>();
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }
    public Integer getNextPage() {
        return nextPage;
    }
    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
    public List<User> getShowUsers() {
        return showUsers;
    }
    public void setShowUsers(List<User> showUsers) {
        this.showUsers = showUsers;
    }
    public List<Integer> getShowPageNums() {
        return showPageNums;
    }
    public void setShowPageNums(List<Integer> showPageNums) {
        this.showPageNums = showPageNums;
    }
}
