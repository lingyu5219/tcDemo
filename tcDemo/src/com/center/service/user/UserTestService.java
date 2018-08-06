package com.center.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.center.po.query.DatatablesView;
import com.center.po.user.UserQueryTest;
import com.center.po.user.UserTest;

public interface UserTestService {
	
	public UserTest queryUserById(int userId) throws Exception;
	
	public List<UserTest> queryUser(UserQueryTest userQuery) throws Exception;

	public DatatablesView<UserTest> queryUserList(UserQueryTest userQuery) throws Exception;

	public void addUser(UserTest user,HttpServletRequest request) throws Exception;
	
	public boolean deleteUserById(int userId) throws Exception;
	
	public boolean updateUserById(UserTest user,HttpServletRequest request) throws Exception;
}
