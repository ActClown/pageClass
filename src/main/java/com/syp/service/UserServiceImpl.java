package com.syp.service;

import com.syp.dao.IUserDao;
import com.syp.dao.UserDaoImpl;
import com.syp.entity.Page;
import com.syp.entity.User;
import com.syp.util.PageUtil;

import java.util.List;

/**
 * Created by syp on 2017-11-21.
 */
public class UserServiceImpl implements IUserService{

    private IUserDao userDao =new UserDaoImpl();

    public Page pageUsers(String currentPage) throws Exception{
        int allRowsAmount =userDao.getAllRowsAmount();
        PageUtil pageUtil =new PageUtil();
        pageUtil.setAllRowsAmount(allRowsAmount);
        if(currentPage !=null){
            pageUtil.setCurrentPage(Integer.parseInt(currentPage));
        }
        pageUtil.calculatePage();
        List<User> list =userDao.getUserByCurrentPage(pageUtil.getCurrentPageStartRow(), pageUtil.getPageSize());
        Page page =new Page();
        page.setPrevPage(pageUtil.getPrevPage());
        page.setNextPage(pageUtil.getNextPage());
        page.setShowUsers(list);
        page.setShowPageNums(pageUtil.getShowPageNums());
        page.setCurrentPage(pageUtil.getCurrentPage());
        return page;
    }
}
