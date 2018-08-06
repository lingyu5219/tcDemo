package com.center.mapper.user;

import java.util.List;

import com.center.po.user.UserTest;
import com.center.po.user.UserQueryTest;

public interface UserTestMapper {
	
	public void addUser(UserTest user) throws Exception;
	
	public UserTest queryUserById(int userId) throws Exception;
	
	public List<UserTest> queryUser(UserQueryTest userQuery) throws Exception;

	public List<UserTest> queryUserList(UserQueryTest userQuery) throws Exception;
	
	public Long queryUserCount(UserQueryTest userQuery) throws Exception;
	
	public int deleteUserById(int userId) throws Exception;
	
	public int updateUserById(UserTest user) throws Exception;
}
