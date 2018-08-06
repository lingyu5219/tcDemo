package com.center.service.system;

import java.util.HashMap;
import java.util.List;

import com.center.po.query.DatatablesView;
import com.center.po.system.User;
import com.center.po.system.UserQuery;

public interface UserService {
	public DatatablesView<User> queryUserList(UserQuery userQuery) throws Exception;
	public User checkUser(UserQuery userQuery) throws Exception;
	public boolean addUser(User user) throws Exception;
	public boolean delUser(int userId) throws Exception;
	public boolean updateUser(User user) throws Exception;
	public HashMap<String, Object> getPersonalInfo(int userId) throws Exception;
}
