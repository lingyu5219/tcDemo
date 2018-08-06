package com.center.service.impl.stumgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.center.mapper.stumgt.StudentMapper;
import com.center.mapper.system.RoleMapper;
import com.center.mapper.system.UserMapper;
import com.center.po.query.DatatablesView;
import com.center.po.stumgt.Student;
import com.center.po.stumgt.StudentQuery;
import com.center.po.system.Role;
import com.center.po.system.RoleQuery;
import com.center.po.system.User;
import com.center.po.system.UserQuery;
import com.center.service.stumgt.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	// (添加)注册学生信息
	@Override
	@Transactional
	public void addStu(Student student, HttpServletRequest request) throws Exception {
		//默认将学生的学号作为登录的账号和密码，添加到用户表中
		User user = new User();
		user.setUserName(student.getStuNo());
		user.setUserPassword(student.getStuNo());
		//将系统默认角色设置给该账号
		RoleQuery roleQuery = new RoleQuery();
		roleQuery.setIsDefault(2);
		List<Role> roleList = roleMapper.queryRole(roleQuery);
		if (roleList.size() > 0) {
			user.setRoleId(roleList.get(0).getRoleId());
		}
		//如果当前是管理员增加学生，则需要设置学生和账号的创建人是当前登录的管理员账户
		HttpSession session = request.getSession();
		User loginUser = (User)	session.getAttribute("user");
		if (null != loginUser) {
			student.setCreateBy(loginUser.getUserId());
			user.setCreateBy(loginUser.getUserId());
		}
		userMapper.addUser(user);
		
		//然后再将账号的ID保存到学生表中
		student.setUserId(user.getUserId());
		studentMapper.addStu(student);
	}

	// 删除学生信息
	@Override
	@Transactional
	public boolean deleteStu(int stuId, int userId) throws Exception {
		//删除学生信息同时 将关联的账号删除
		int affectedRecords1 = studentMapper.deleteStu(stuId);
		UserQuery userQuery = new UserQuery();
		userQuery.setUserId(userId);
		long userCount = userMapper.queryUserCount(userQuery);
		int affectedRecords2 = userMapper.delUser(userId);
		if (affectedRecords1 > 0 && affectedRecords2 == userCount) {
			return true;
		} else {
			return false;
		}

	}

	// 修改学生信息
	@Override
	public boolean updateStu(Student student) throws Exception {
		
		int affectedRecords = studentMapper.updateStu(student);

		if (affectedRecords > 0) {
			return true;
		} else {
			return false;
		}

	}

	// 查询学生信息
	@Override
	public DatatablesView<Student> queryStuList(StudentQuery studentQuery) throws Exception {

		DatatablesView<Student> dataview = new DatatablesView<Student>();

		List<Student> studentList = studentMapper.queryStuList(studentQuery);
		Long count = studentMapper.queryStuCount(studentQuery);

		dataview.setRecordsTotal(count);
		dataview.setData(studentList);

		return dataview;

	}

	@Override
	public boolean CheckStu(StudentQuery studentQuery) throws Exception {
		
		Long count = studentMapper.queryStuCount(studentQuery);
		
		return count > 0 ? false : true;
		
	}

}
