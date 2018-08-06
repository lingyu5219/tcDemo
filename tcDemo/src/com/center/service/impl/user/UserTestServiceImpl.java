package com.center.service.impl.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.user.UserTestMapper;
import com.center.po.query.DatatablesView;
import com.center.po.user.UserTest;
import com.center.po.user.UserQueryTest;
import com.center.service.user.UserTestService;

@Service
public class UserTestServiceImpl implements UserTestService {
	@Autowired
	private UserTestMapper userMapper;
	
	public UserTest queryUserById(int userId) throws Exception {
		UserTest user = userMapper.queryUserById(userId);
		return user;
	}

	@Override
	public List<UserTest> queryUser(UserQueryTest userQuery) throws Exception {
		
		List<UserTest> userList = userMapper.queryUser(userQuery);
		
		return userList;
		
	}
	
	@Override
	public DatatablesView<UserTest> queryUserList(UserQueryTest userQuery) throws Exception {
		DatatablesView<UserTest> dataView = new DatatablesView<UserTest>();
		
		Long count = userMapper.queryUserCount(userQuery);
		List<UserTest> userList = userMapper.queryUserList(userQuery);
		
		dataView.setRecordsTotal(count);
	    dataView.setData(userList);
		return dataView ;
	}

	@Override
	public boolean deleteUserById(int userId) throws Exception {
		
		int affectedRecords = userMapper.deleteUserById(userId);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public void addUser(UserTest user,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		UserTest loginUser = (UserTest)	session.getAttribute("user");
		user.setCreateBy(loginUser.getUserId());
		
		userMapper.addUser(user);
		
	}

	@Override
	public boolean updateUserById(UserTest user, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		UserTest loginUser = (UserTest)	session.getAttribute("user");
		user.setCreateBy(1);
		
		int affectedRecords = userMapper.updateUserById(user);
		
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}

	
}
