
/**
* Project Name:trainingCenter
* File Name:StaffService.java
* Package Name:com.center.service.personnel
* Date:2016年12月22日下午3:11:28
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.hrmgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.center.po.hrmgt.Position;
import com.center.po.hrmgt.Staff;
import com.center.po.hrmgt.StaffQuery;
import com.center.po.org.Department;
import com.center.po.query.DatatablesView;

/**
* ClassName:StaffService <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月22日 下午3:11:28 <br/>
* @author 李逢杰
* @version
* @see
*/
public interface StaffService {
	// 查看全部或个人
	public DatatablesView<Staff> queryStaff(StaffQuery staffQuery) throws Exception;
	
	// add查询positionId
    public List<Position> queryPositionIdList() throws Exception;
    
    // add查询deptId
    public List<Department> queryDeptIdList() throws Exception;
	
	// 存储教职工更新信息
	public boolean updateStaff(Staff staff,HttpServletRequest request) throws Exception;
	// 添加教职工信息
	public boolean addStaff(Staff staff,HttpServletRequest request) throws Exception;
	
	// 删除教职工信息
	public boolean deleteStaff(int staffId) throws Exception;
	

	

}

