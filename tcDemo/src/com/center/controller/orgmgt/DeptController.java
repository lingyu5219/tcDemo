
/**
* Project Name:trainingCenter
* File Name:CenterController.java
* Package Name:com.center.controller.org
* Date:2016年12月22日下午2:22:59
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.controller.orgmgt;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.org.CenterQuery;
import com.center.po.org.Department;
import com.center.po.org.DeptQuery;
import com.center.po.query.DatatablesView;
import com.center.service.org.DeptService;

import net.sf.json.JSONObject;

//createBy:ly
//query:dept/deptList
//update:dept/modifyDept
//delete:dept/deleteDept
//add:dept/addDept
@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping("deptList")
	public ModelAndView deptList(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView =new ModelAndView();
		
		modelAndView.setViewName("org/deptList");
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/queryDeptList",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryDeptList(@ModelAttribute("DeptQuery") DeptQuery deptQuery,HttpServletRequest request) throws Exception {
		DatatablesView<Department> dataTable = deptService.queryDeptList(deptQuery);
		
		dataTable.setDraw(deptQuery.getDraw());
		
		String data = JSONObject.fromObject(dataTable).toString();
		
		return data;
	}

	//添加信息
		@ResponseBody
		@RequestMapping(value="/addDept",method=RequestMethod.POST)
		public String addCenter(@ModelAttribute("DeptQuery")DeptQuery deptQuery,HttpServletRequest request) throws Exception {
			
			deptService.addDept(deptQuery, request);;
			String data = JSONObject.fromObject(deptQuery).toString();
			return data;
		 
			  
		}
		 
		//删除信息
		@ResponseBody
		@RequestMapping(value="/deleteDept",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
		public String deleteCenterById(@ModelAttribute("deptId") int deptId,HttpServletRequest request) throws Exception {
			HashMap<String,String> rsMap = new HashMap<String,String>();
			boolean result = deptService.deleteDeptById(deptId);
			if (result) {
				rsMap.put("status", "1");
				rsMap.put("info", "删除成功");
			} else {
				rsMap.put("status", "0");
				rsMap.put("info", "删除失败");
			}
			String data = JSONObject.fromObject(rsMap).toString();
			return data;
		}

		//更改信息
		@ResponseBody
		@RequestMapping(value="/modifyDept",method=RequestMethod.POST)
		public String modifyCenter(@ModelAttribute("DeptQuery")DeptQuery deptQuery,HttpServletRequest request) throws Exception {
			
			deptService.modifyDeptById(deptQuery);;
			String data = JSONObject.fromObject(deptQuery).toString();
			return data;
		 
			  
		}
//	
//	@RequestMapping("/queryDeptAll")
//	public ModelAndView queryDeptAll(HttpServletRequest request) throws Exception {
//		// 先写静态值
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("dept/deptList");
//		return modelAndView;
//	}
//	//显示全部部门
//	@RequestMapping("/queryDeptAllByEL")
//	public ModelAndView queryDeptAllByEl(HttpServletRequest request) throws Exception {
//		
//		ArrayList<Department> list=deptService.queryDeptAll();
//		
//		ModelAndView modelAndView=new ModelAndView();
//		if(list!=null){
//			modelAndView.addObject("list", list);		
//				}
//		modelAndView.setViewName("dept/deptList");
//		return modelAndView;
//	}
//	//按名查找部门
//	@RequestMapping("/queryDeptByName")
//	public ModelAndView queryDeptAllByName1(HttpServletRequest request) throws Exception {
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("dept/deptByName");
//		return modelAndView;
//	}
//	@RequestMapping("/queryDeptAllByName")
//	public ModelAndView queryDeptAllByName(HttpServletRequest request) throws Exception {
//		String deptName=request.getParameter("deptName");
//		ArrayList<Department> list=deptService.queryDeptByName(deptName);
//		ModelAndView modelAndView=new ModelAndView();
//		if(list!=null){
//			modelAndView.addObject("list", list);		
//				}
//		modelAndView.setViewName("dept/deptList");
//		return modelAndView;
//	}
//	
//	
//	@RequestMapping("/queryDept")
//	public ModelAndView queryDeptById(HttpServletRequest request) throws Exception {
//		// 先写静态值
//		Department department =deptService.queryDeptById(11);
//		
//		// 返回ModelAndView
//		ModelAndView modelAndView = new ModelAndView();
//		// 相当 于request的setAttribute
//		modelAndView.addObject("department", department);
//		
//		// 指定视图
//		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
//		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
//		modelAndView.setViewName("dept/deptList");
//
//		return modelAndView;
//
//	}
//	//修改信息
//	@RequestMapping("/updateDept")
//	public ModelAndView updateDept(HttpServletRequest request, Department department) throws Exception {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("dept", department);
//		modelAndView.addObject("deptName", department.getDeptName());
//		modelAndView.addObject("deptId", request.getParameter("deptId"));
//		modelAndView.setViewName("dept/deptUpdate");
//		return modelAndView;
//		// 先写静态值
//	}
//	//修改删除信息结果(执行)
//	@RequestMapping("/updateDeptResult")
//	public ModelAndView updateDeptResult(HttpServletRequest request) throws Exception {
//		// 先写静态值
//		String submit=request.getParameter("submit");
//		
//		Department department=new Department();
//		department.setDeptAddress(request.getParameter("deptAddress"));
//		department.setDeptId(Integer.parseInt(request.getParameter("deptId")));
//		department.setDeptName(request.getParameter("deptName"));
//		department.setParentId(Integer.parseInt(request.getParameter("parentId")));
//		department.setRemark(request.getParameter("remark"));
//		ModelAndView modelAndView = new ModelAndView();
//		if(submit.equals("修改")){
//		int department2 =deptService.updateDeptById(department);
//		
//		// 返回ModelAndView
//		
//		if(department2==1){
//			modelAndView.addObject("info", "修改成功");
//		}
//		// 相当 于request的setAttribute
//		modelAndView.addObject("department", department);
//		}
//		else if(submit.equals("删除")){
//			int result=deptService.deleteDeptById(Integer.parseInt(request.getParameter("deptId")));
//			if(result==1){
//				modelAndView.addObject("info", "删除成功");
//			}
//		}
//		else {
//			modelAndView.addObject("info", "报错了");
//		}
//
//		
//		// 指定视图
//		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
//		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
//		modelAndView.setViewName("dept/deptByName");
//
//		return modelAndView;
//
//	}
//	//跳去增加
//	@RequestMapping("/deptAddbefo")
//	public ModelAndView addDept1(HttpServletRequest request) throws Exception{
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("dept/deptAdd");
//		return modelAndView;
//	
//	}
//	//增加执行
//	@RequestMapping("/deptAdd")
//	public ModelAndView addDept(HttpServletRequest request,Department department) throws Exception{
//		// 先写静态值
//		int result=deptService.addDept(department);
//		
//		// 返回ModelAndView
//		ModelAndView modelAndView = new ModelAndView();
//		// 相当 于request的setAttribute
//		if(result==1){
//			modelAndView.addObject("info", "添加成功");
//		}
//
//		
//		// 指定视图
//		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
//		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
//		modelAndView.setViewName("dept/deptByName");
//
//		return modelAndView;
//
//	}
	
}

