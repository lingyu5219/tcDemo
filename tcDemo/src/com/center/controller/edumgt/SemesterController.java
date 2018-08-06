
/**
* Project Name:trainingCenter
* File Name:CenterController.java
* Package Name:com.center.controller.org
* Date:2016年12月22日下午2:22:59
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.controller.edumgt;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.edumgt.Semester;
import com.center.po.edumgt.SemesterQuery;
import com.center.po.query.DatatablesView;
import com.center.service.edumgt.SemesterService;

import net.sf.json.JSONObject;

//createBy:ly
//query:semester/semesterList
//update:semester/modifySemester
//delete:semester/deleteSemester
//add:semester/addSemester
@Controller
@RequestMapping("/semester")
public class SemesterController {

	@Autowired
	private SemesterService semesterService;
	
	@RequestMapping(value="/semesterList",method=RequestMethod.GET)
	public ModelAndView semesterList(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView =new ModelAndView();
		
		modelAndView.setViewName("edumgt/semesterList");
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/querySemesterList",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String querySemesterList(@ModelAttribute("SemesterQuery") SemesterQuery semesterQuery,HttpServletRequest request) throws Exception {
		DatatablesView<Semester> dataTable = semesterService.querySemesterList(semesterQuery);
		
		dataTable.setDraw(semesterQuery.getDraw());
		
		String data = JSONObject.fromObject(dataTable).toString();
		
		return data;
	}

	//添加信息
		@ResponseBody
		@RequestMapping(value="/addSemester",method=RequestMethod.POST)
		public String addCenter(@ModelAttribute("SemesterQuery")SemesterQuery semesterQuery,HttpServletRequest request) throws Exception {
			
			semesterService.addSemester(semesterQuery, request);;
			String data = JSONObject.fromObject(semesterQuery).toString();
			return data;
		 
			  
		}
		 
		//删除信息
		@ResponseBody
		@RequestMapping(value="/deleteSemester",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
		public String deleteCenterById(@ModelAttribute("semesterId") int semesterId,HttpServletRequest request) throws Exception {
			HashMap<String,String> rsMap = new HashMap<String,String>();
			boolean result = semesterService.deleteSemesterById(semesterId);
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
		@RequestMapping(value="/modifySemester",method=RequestMethod.POST)
		public String modifyCenter(@ModelAttribute("Semester")Semester semester,HttpServletRequest request) throws Exception {
			
			semesterService.modifySemesterById(semester);;
			String data = JSONObject.fromObject(semester).toString();
			return data;
		 
			  
		}
//	
//	}
	
}

