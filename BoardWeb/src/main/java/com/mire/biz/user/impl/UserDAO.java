package com.mire.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.mire.biz.common.JDBCUtil;
import com.mire.biz.user.UserVO;

@Repository
public class UserDAO  {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private final String USER_GET = "select  * from users where id = ? and password = ?";


    public UserVO getUser(UserVO vo) {
        System.out.println("===> JDBC getUser() ");
        UserVO user = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));

            }
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }
    
    private final String JOIN_GET = "INSERT INTO USERs VALUES(?, ?, ?, ?)";

    public void getJoin(UserVO vo) {
    	System.out.println("===> JDBC getJoin()");
    	try {
    		  conn = JDBCUtil.getConnection();
              stmt = conn.prepareStatement(JOIN_GET);
              stmt.setString(1, vo.getId());
              stmt.setString(2, vo.getPassword());
              stmt.setString(3, vo.getName());
              stmt.setString(4, vo.getRole());
              stmt.executeUpdate();            
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              JDBCUtil.close( stmt, conn);
          }
    }
    
   
	private final String UPDATE_GET = "UPDATE USERS SET PASSWORD = ?, NAME = ?, ROLE = ? WHERE ID = ?";
    
    public void getUpdateUser(UserVO vo) {
		System.out.println("===> JDBC getUpdate()");
		try {
			 conn = JDBCUtil.getConnection();
	            stmt = conn.prepareStatement(UPDATE_GET);
	            stmt.setString(1, vo.getPassword());
	            stmt.setString(2, vo.getName());
	            stmt.setString(3, vo.getRole());
	            stmt.setString(4, vo.getId());
	            stmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            JDBCUtil.close( stmt, conn);
	        }
	    }
    
    private final String DELETE_GET = "DELETE FROM users WHERE id = ? AND password = ?";
    
    public void getDeleteUser(UserVO vo) {
    	System.out.println("===> JDBC getDelete()");
		try {
			 conn = JDBCUtil.getConnection();
	            stmt = conn.prepareStatement(DELETE_GET);
	            stmt.setString(1, vo.getId());
	            stmt.setString(2, vo.getPassword());
	            stmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            JDBCUtil.close( stmt, conn);
	        }
	    }
    	
    }

