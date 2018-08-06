
/**
* Project Name:trainingCenter
* File Name:StaffServiceImpl.java
* Package Name:com.center.service.impl.personnel
* Date:2016年12月22日下午3:13:23
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.impl.hrmgt;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.hrmgt.StaffMapper;
import com.center.po.hrmgt.Position;
import com.center.po.hrmgt.Staff;
import com.center.po.hrmgt.StaffQuery;
import com.center.po.org.Department;
import com.center.po.query.DatatablesView;
import com.center.service.hrmgt.StaffService;

/**
 * ClassName:StaffServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月22日 下午3:13:23 <br/>
 * 
 * @author 李逢杰
 * @version
 * @see
 */
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffMapper staffMapper;
	// 查看全部或个人
	public DatatablesView<Staff> queryStaff(StaffQuery staffQuery) throws Exception {
		Long count = staffMapper.queryStaffCount(staffQuery);
		List<Staff> stafflist = staffMapper.queryStaffList(staffQuery);		
		
		// 调用changeBirthday方法把日期转换成年龄  并且 计数
		for (Staff staff : stafflist) {
			staff = changeBirthday(staff);	
		}
		
		DatatablesView<Staff> dataView =new DatatablesView<Staff>();
		
		dataView.setData(stafflist);
		dataView.setRecordsTotal(count);
		return dataView;
	}

	// 计算年龄
	public Staff changeBirthday(Staff staff) {
		String bir = staff.getStaffBirthday();// 获取生日
		System.out.println(bir);
		bir = bir.substring(0, 4);// 获取前4位字符串--生日年份
		int b2 = Integer.parseInt(bir);// 讲生日转换成int类型

		Calendar c = Calendar.getInstance();// 创建时间格式化 方法
		c.setTime(new Date()); // 设置当前时间
		int b1 = c.get(Calendar.YEAR); // 取年份

		int b = b1 - b2;// 计算年龄

		String newbir = String.valueOf(b);// int转String

		staff.setStaffBirthday(newbir);
		return staff;
	}

	// 教职工信息更新
	@Override
	public boolean updateStaff(Staff staff, HttpServletRequest request) throws Exception {
		
		int affectedRecords=staffMapper.updateStaff(staff);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}

	}
	// 添加教职工信息
	@Override
	public boolean addStaff(Staff staff, HttpServletRequest request) throws Exception {
		
		boolean b = false;
		try {
			staffMapper.addStaff(staff);
			int userId = staffMapper.addStaffSelect(staff);
			staff.setUserId(userId);
			staffMapper.addStaffInsert(staff);
			b = true;
		} catch (Exception e) {
			b = false;
		}

		return b;

	}
	// 删除教职工信息
	@Override
	public boolean deleteStaff(int staffId) throws Exception {
		boolean b = false;
		try {
			staffMapper.deleteuser(staffId);
			
			staffMapper.deleteStaff(staffId);
			b = true;
		} catch (Exception e) {
			b = false;
		}

		return b;
		
	}
	// add查询positionId
	@Override
	public List<Position> queryPositionIdList() throws Exception {
		
		List<Position> positionlist = staffMapper.queryPositionIdList();
		
		return positionlist;		
	}
	// add查询deptId      
		@Override
		public List<Department> queryDeptIdList() throws Exception {
			
			List<Department> departmentlist = staffMapper.queryDeptIdList();
			
			return departmentlist;		
		}

}
