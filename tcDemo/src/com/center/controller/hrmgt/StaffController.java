
/**
* Project Name:trainingCenter
* File Name:StaffController.java
* Package Name:com.center.controller.personnel
* Date:2016年12月22日下午3:17:40
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.controller.hrmgt;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.hrmgt.Position;
import com.center.po.hrmgt.Staff;
import com.center.po.hrmgt.StaffQuery;
import com.center.po.org.Department;
import com.center.po.query.DatatablesView;
import com.center.service.hrmgt.StaffService;

import net.sf.json.JSONObject;

/**
 * ClassName:StaffController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月22日 下午3:17:40 <br/>
 * 
 * @author 李逢杰
 * @version
 * @see
 */
@Controller
// 为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
// 比如：查询用户：/staff/queryStaffById
@RequestMapping("/hrmgt")
public class StaffController {

	@Autowired
	private StaffService staffService;

	// 进入教职工管理功能
	@RequestMapping(value = "/staffList", method = RequestMethod.GET)
	public ModelAndView staffList(HttpServletRequest request) throws Exception {
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("hrmgt/staffList");

		return modelAndView;

	}

	// 新增教职工
	@ResponseBody
	@RequestMapping(value = "/addStaff", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String addStaff(@ModelAttribute("staff") Staff staff, HttpServletRequest request) throws Exception {

		staff.setCreateBy(1);

		Boolean b = staffService.addStaff(staff, request);
		
		HashMap<String, String> rsMap = new HashMap<String, String>();
		if (b) {
			rsMap.put("status", "1");
			rsMap.put("info", "增加成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "增加失败");
		}
		String data = JSONObject.fromObject(rsMap).toString();
		return data;
	}

	// 删除教职工
	@ResponseBody
	@RequestMapping(value = "/delStaff", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String delStaff(@ModelAttribute("staffId") int staffId, HttpServletRequest request)
			throws Exception {
		HashMap<String, String> rsMap = new HashMap<String, String>();
		Boolean b = staffService.deleteStaff(staffId);
		if (b) {
			rsMap.put("status", "1");
			rsMap.put("info", "删除成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "删除失败");
		}
		String data = JSONObject.fromObject(rsMap).toString();
		return data;
	}

	// 修改教职工
	@ResponseBody
	@RequestMapping(value = "/updateStaff", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String updateStaff(@ModelAttribute("staff") Staff staff, HttpServletRequest request) throws Exception {
		HashMap<String, String> rsMap = new HashMap<String, String>();
		Boolean b = staffService.updateStaff(staff, request);

		if (b) {
			rsMap.put("status", "1");
			rsMap.put("info", "更新成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "更新失败");
		}
		String data = JSONObject.fromObject(rsMap).toString();
		return data;
	}

	// 查询教职工列表
	@ResponseBody
	@RequestMapping(value = "/queryStaffList", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String queryStaffList(@ModelAttribute("StaffQuery") StaffQuery staffQuery, HttpServletRequest request)
			throws Exception {
		// 调用service查找 数据库，查询用户
		DatatablesView<Staff> dataTable = staffService.queryStaff(staffQuery);

		dataTable.setDraw(staffQuery.getDraw());

		String data = JSONObject.fromObject(dataTable).toString();

		return data;
	}

	//打开新增教职工页面
	@ResponseBody
	@RequestMapping("/staffAdd")
	public ModelAndView staffAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		// 添加positionId,deptId
		List<Position> data = staffService.queryPositionIdList();
		modelAndView.addObject("Position", data);
		
		List<Department> deptData = staffService.queryDeptIdList();
		modelAndView.addObject("Dept", deptData);
		
		modelAndView.setViewName("hrmgt/staffAdd");
		return modelAndView;
	}

	// 打开修改教职工页面
	@ResponseBody
	@RequestMapping("/staffModify")
	public ModelAndView staffModify() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<Position> data = staffService.queryPositionIdList();
		modelAndView.addObject("Position", data);
		List<Department> deptData = staffService.queryDeptIdList();
		modelAndView.addObject("Dept", deptData);
		modelAndView.setViewName("hrmgt/staffModify");
		return modelAndView;
	}

	// 打开查看教职工页面
	@ResponseBody
	@RequestMapping("/staffDetail")
	public ModelAndView staffDetail() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<Position> data = staffService.queryPositionIdList();
		modelAndView.addObject("Position", data);
		List<Department> deptData = staffService.queryDeptIdList();
		modelAndView.addObject("Dept", deptData);
		modelAndView.setViewName("hrmgt/staffDetail");
		return modelAndView;
	}
}
