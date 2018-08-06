
/**
* Project Name:trainingCenter
* File Name:CenterMapper.java
* Package Name:com.center.mapper.org
* Date:2016骞�12鏈�22鏃ヤ笅鍗�1:54:04
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.mapper.org;

import java.util.List;

import com.center.po.org.Department;
import com.center.po.org.DeptQuery;

public interface DeptMapper {
	
	public Department queryDeptById(int deptId) throws Exception;
	
	public List<Department> queryDeptList(DeptQuery deptQuery) throws Exception;
	
	public Long queryDeptCount(DeptQuery deptQuery) throws Exception;
	
	public void addDept(Department department) throws Exception;
	
	public int deleteDeptById(int deptId) throws Exception;
	
	public void modifyDeptById(Department department) throws Exception;
	
}

