package com.syp.service;

import com.syp.entity.Page;

/**
 * Created by syp on 2017-11-21.
 */
public interface IUserService {
    public Page pageUsers(String currentPage) throws Exception;
}
