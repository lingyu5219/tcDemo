package com.center.service.impl.system;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.hrmgt.StaffMapper;
import com.center.mapper.stumgt.StudentMapper;
import com.center.mapper.system.UserMapper;
import com.center.po.hrmgt.Staff;
import com.center.po.query.DatatablesView;
import com.center.po.stumgt.Student;
import com.center.po.system.User;
import com.center.po.system.UserQuery;
import com.center.service.system.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	 
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Override
	public HashMap<String, Object> getPersonalInfo(int userId) throws Exception {
		HashMap<String, Object> rsMap = new HashMap<String,Object>();
		
		Student student = studentMapper.queryStu(userId);
		Staff staff = staffMapper.queryStaff(userId);
		if(null != student){
			//flag 1 表示学生
			rsMap.put("flag", "1");
			rsMap.put("personal", student);
		}
		if(null != staff){
			//flag 1 表示教职工
			rsMap.put("flag", "2");
			rsMap.put("personal", staff);
		}
		return rsMap;
	} 
	
	@Override
	public DatatablesView<User> queryUserList(UserQuery userQuery) throws Exception {
		DatatablesView<User> dataView = new DatatablesView<User>();
		List<User> list = userMapper.queryUserList(userQuery);
        long Count = userMapper.queryUserCount(userQuery);
        dataView.setData(list);
        dataView.setRecordsTotal(Count);
		return dataView;
	}

	@Override
	public User checkUser(UserQuery userQuery) throws Exception {
		User user = userMapper.checkUser(userQuery);
		return user;
	}

	 private boolean Judge(int num){
		 if(num>0)
			 return true;
		 else
			 return false;
	 }
	
	
	@Override
	public boolean  addUser(User user) throws Exception {
		return Judge(userMapper.addUser(user));
	}

	@Override
	public boolean  delUser(int userId) throws Exception {
		return Judge(userMapper.delUser(userId));
	}

	@Override
	public boolean  updateUser(User user) throws Exception {
		return Judge(userMapper.updateUser(user));
	}

}
