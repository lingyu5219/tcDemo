
/**
* Project Name:trainingCenter
* File Name:StaffMapper.java
* Package Name:com.center.mapper.personnel
* Date:2016年12月22日下午3:04:17
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.mapper.hrmgt;

import java.util.List;

import com.center.po.hrmgt.Position;
import com.center.po.hrmgt.Staff;
import com.center.po.hrmgt.StaffQuery;
import com.center.po.org.Department;

/**
 * ClassName:StaffMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月22日 下午3:04:17 <br/>
 * 
 * @author 李逢杰
 * @version
 * @see
 */
public interface StaffMapper {
	// 查询全部或个人
	public Staff queryStaff(int userId) throws Exception;
	
	public List<Staff> queryStaffList(StaffQuery staffQuery) throws Exception;

	public Long queryStaffCount(StaffQuery staffQuery) throws Exception;
	
	// add查询positionId
	public List<Position> queryPositionIdList() throws Exception;
	
	// add查询deptId
	public List<Department> queryDeptIdList() throws Exception;
		
	// 存储教职工更新信息
	public int updateStaff(Staff staff) throws Exception;

	// 添加教职工信息
	public void addStaff(Staff staff) throws Exception;
	public int addStaffSelect(Staff staff) throws Exception;
	public void addStaffInsert(Staff staff) throws Exception;
	
	// 删除教职工信息
	public void deleteStaff(int staffId) throws Exception;
	public void deleteuser(int staffId) throws Exception;

}
