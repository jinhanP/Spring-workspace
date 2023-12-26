package com.mire.biz.user;

public interface UserService {

	UserVO getUser(UserVO vo);

	void getJoin(UserVO vo);
	
	void getUpdateUser(UserVO vo);
	
	void getDeleteUser(UserVO vo);
}