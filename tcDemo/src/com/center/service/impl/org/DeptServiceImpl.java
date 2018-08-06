package com.center.service.impl.org;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.org.DeptMapper;
import com.center.po.org.Department;
import com.center.po.org.DeptQuery;
import com.center.po.query.DatatablesView;
import com.center.po.system.User;
import com.center.service.org.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public Department queryDeptById(int deptId) throws Exception {
		Department dept =deptMapper.queryDeptById(deptId);
		return dept;
	}

	@Override
	public DatatablesView<Department> queryDeptList(DeptQuery deptQuery) throws Exception {
		DatatablesView<Department> dtb =new DatatablesView<Department>();
		
		Long count =deptMapper.queryDeptCount(deptQuery);
		dtb.setRecordsTotal(count);
		
		List<Department> deptList =deptMapper.queryDeptList(deptQuery);
		dtb.setData(deptList);
		
		return dtb;
	}

	@Override
	public void addDept(Department department, HttpServletRequest request) throws Exception {
		HttpSession session =request.getSession();
		User loginUser =(User) session.getAttribute("user");
		
//		int createBy =loginUser.getUserId();
//		department.setCreateBy(createBy);
		department.setCreateBy(1);//测试时候使用
		deptMapper.addDept(department);
		
		
	}

	@Override
	public boolean deleteDeptById(int deptId) throws Exception {
		int affectedRecords = deptMapper.deleteDeptById(deptId);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void modifyDeptById(DeptQuery deptQuery) throws Exception {
		deptMapper.modifyDeptById(deptQuery);
		
	}
	
}

