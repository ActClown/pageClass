package com.syp.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by syp on 2017-11-21.
 * 使用c3p0连接池的工具类
 */
public class DbUtils {

        private static DataSource dataSource=null;
        static{
            dataSource=new ComboPooledDataSource();
        }

        public static Connection getConnection(){
            try{
                return dataSource.getConnection();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

        //释放对象的连接
        public static void close(Connection conn, Statement stmt, ResultSet rs){
            if(rs !=null){
                try{
                    rs.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(stmt !=null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(conn !=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

        /* 使用C3P0连接*/
//        public static void main(String[] args) throws Exception{
//            String sql="select id,username,gender from myuser limit 3,10";
//            Connection conn =DbUtil.getConnection();
//            PreparedStatement ps =conn.prepareStatement(sql);
//            ResultSet rs =ps.executeQuery();
//            while(rs.next()){
//                String id =rs.getString("id");
//                String username =rs.getString("username");
//                String gender =rs.getString("gender");
//                System.out.println(id+","+username+","+gender);
//            }
//            DbUtil.close(conn,ps,rs);
//        }
//    }
}
