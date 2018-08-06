package com.center.mapper.system;

import java.util.List;

import com.center.po.system.User;
import com.center.po.system.UserQuery;

public interface UserMapper {
	public List<User> queryUserList(UserQuery userQuery) throws Exception;
	public long queryUserCount(UserQuery userQuery) throws Exception;
	public User checkUser(UserQuery userQuery) throws Exception;
	public int addUser(User user) throws Exception;
	public int delUser(int userId) throws Exception;
	public int updateUser(User user) throws Exception;

}
