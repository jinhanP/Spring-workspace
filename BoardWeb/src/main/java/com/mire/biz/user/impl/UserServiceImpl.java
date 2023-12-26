package com.mire.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mire.biz.user.UserService;
import com.mire.biz.user.UserVO;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    
    @Override
    public UserVO getUser(UserVO vo) {
    	return userDAO.getUser(vo);
    }
    @Override
    public void getJoin(UserVO vo) {
    	return;
    }
    public void getUpdateUser(UserVO vo) {
    	 userDAO.getUpdateUser(vo);
    }
    public void getDeleteUser(UserVO vo) {
    		userDAO.getDeleteUser(vo);
    }


//    public void setUserDAO(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }


}

