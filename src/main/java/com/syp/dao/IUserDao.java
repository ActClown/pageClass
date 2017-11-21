package com.syp.dao;

import com.syp.entity.User;

import java.util.List;

/**
 * Created by syp on 2017-11-21.
 * dao层接口
 */
public interface IUserDao {
    public Integer getAllRowsAmount() throws Exception;

    public List<User> getUserByCurrentPage(Integer currentPageStartRow, Integer pageSize) throws Exception;
}
