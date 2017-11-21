package com.syp.controller;

import com.syp.entity.Page;
import com.syp.service.IUserService;
import com.syp.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by syp on 2017-11-21.
 */
public class UserController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private IUserService userService =new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String currentPage =req.getParameter("currentPage");
        Page page =null;
        try {
            page =userService.pageUsers(currentPage);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        req.setAttribute("page", page);
        req.getRequestDispatcher("/page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
