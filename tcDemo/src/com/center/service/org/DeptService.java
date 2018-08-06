package com.center.service.org;

import javax.servlet.http.HttpServletRequest;

import com.center.po.org.CenterQuery;
import com.center.po.org.Department;
import com.center.po.org.DeptQuery;
import com.center.po.query.DatatablesView;

public interface DeptService {
	
	public Department queryDeptById(int deptId) throws Exception;
	
	public DatatablesView<Department> queryDeptList(DeptQuery deptQuery) throws Exception;
	
	public void addDept(Department department,HttpServletRequest request) throws Exception;

    public boolean deleteDeptById(int deptId) throws Exception;
	
	public void modifyDeptById(DeptQuery deptQuery) throws Exception;
}

