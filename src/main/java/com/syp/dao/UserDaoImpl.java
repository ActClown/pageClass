package com.syp.dao;

import com.syp.entity.User;
import com.syp.util.DbUtils;
import com.syp.util.PageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syp on 2017-11-21.
 */
public class UserDaoImpl implements IUserDao{

    //从数据库查询记录的总条数
    public Integer getAllRowsAmount() throws Exception{
        String sql="select count(*) from myuser";
        Connection conn = DbUtils.getConnection();
        PreparedStatement pstmt =conn.prepareStatement(sql);
        ResultSet rs =pstmt.executeQuery();
        Integer allRowsAmount=0;
        if(rs.next()){
            allRowsAmount =rs.getInt("count(*)");
        }
        DbUtils.close(conn, pstmt, rs);
        return allRowsAmount;
    }

    //通过当前页号查询条件记录
    public List<User> getUserByCurrentPage(Integer currentPageStartRow, Integer pageSize) throws Exception{
        String sql="select id,username,gender from myuser limit "+(currentPageStartRow-1)+","+pageSize;
        Connection conn =DbUtils.getConnection();
        PreparedStatement pstmt =conn.prepareStatement(sql);
        ResultSet rs =pstmt.executeQuery();
        List<User> list =new ArrayList<User>();
        while(rs.next()){
            User user =new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setGender(rs.getString("gender"));
            list.add(user);
        }
        DbUtils.close(conn, pstmt, rs);
        return list;
    }
//    public static void main(String[] args) throws Exception {
//        UserDaoImpl userDaoImpl =new UserDaoImpl();
//        PageUtil pageUtil =new PageUtil();
//        pageUtil.setAllRowsAmount(userDaoImpl.getAllRowsAmount());
//        pageUtil.calculatePage();
//        for(User user :userDaoImpl.getUserByCurrentPage(pageUtil.getStartPageNum(), pageUtil.getPageSize())){
//            System.out.println(user.getId()+","+user.getUsername()+","+user.getGender());
//        }
//        System.out.println(userDaoImpl.getAllRowsAmount());
//    }
}
