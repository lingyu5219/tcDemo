
/**
* Project Name:trainingCenter
* File Name:AttendContoller.java
* Package Name:com.center.controller.perfmgt
* Date:2016年12月23日下午8:44:29
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.controller.perfmgt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.perfmgt.Attend;
import com.center.po.query.DatatablesView;
import com.center.service.perfmgt.AttendService;

import net.sf.json.JSONObject;


/**
* ClassName:AttendContoller <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午8:44:29 <br/>
* @author 钱兆瑞
* @version
* @see
*/
@Controller
@RequestMapping("/perfmgt")
public class AttendContoller {
	@Autowired
	private AttendService attendService;
//	进入考勤查询教师界面
	@RequestMapping("/attendTchList")
	public ModelAndView attendTchList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();		

		String jsonDate=attendService.queryAttendJsonData();
		
		modelAndView.addObject("jsonDate", jsonDate);
		
		modelAndView.setViewName("perfmgt/attendTchList");	
		
		return modelAndView;

	}
	
//	进入考勤查询学生界面
	@RequestMapping("/attendStuList")
	public ModelAndView attendStuList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();		

		String jsonDate=attendService.queryAttendJsonData();
		
		modelAndView.addObject("jsonDate", jsonDate);
		
		modelAndView.setViewName("perfmgt/attendStuList");	
		
		return modelAndView;

	}
//	老师查询考勤
	@ResponseBody
	@RequestMapping(value="/queryTchAttend",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryAttendForTeacher(@ModelAttribute("Attend") Attend attend,HttpServletRequest request) throws Exception {

		DatatablesView<Attend> dataTable=attendService.queryAttend(attend);
		dataTable.setDraw(attend.getDraw());		
		String data = JSONObject.fromObject(dataTable).toString();
		System.out.println(data);
		return data;

	}
//	学生查询考勤
	@ResponseBody
	@RequestMapping(value="/queryStuAttend",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryAttendForStu(@ModelAttribute("Attend") Attend attend,HttpServletRequest request) throws Exception {
		
		attend.setUserId(1);
		
		DatatablesView<Attend> dataTable=attendService.queryAttend(attend);
		dataTable.setDraw(attend.getDraw());		
		String data = JSONObject.fromObject(dataTable).toString();
		System.out.println(data);
		return data;

	}
	

}

