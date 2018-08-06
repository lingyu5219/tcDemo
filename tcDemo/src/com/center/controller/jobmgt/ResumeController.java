
/**
* Project Name:trainingCenter
* File Name:ResumeController.java
* Package Name:com.center.controller.jobmgt
* Date:2016年12月23日下午3:27:22
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.controller.jobmgt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.jobmgt.Resume;
import com.center.po.jobmgt.ResumeQuery;
import com.center.po.query.DatatablesView;

import com.center.service.jobmgt.ResumeService;

import net.sf.json.JSONObject;

/**
* ClassName:ResumeController <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午3:27:22 <br/>
* @author niit
* @version
* @see
*/

@Controller
@RequestMapping("/resume")
public class ResumeController {

	@Autowired
	private ResumeService resumeService;
	
	@RequestMapping("/queryResume")
	public ModelAndView queryResumeById(HttpServletRequest request) throws Exception {
		// 调用service查找 数据库，查询用户
		Resume resume = resumeService.queryResumeById(1);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribute
		modelAndView.addObject("resume", resume);

		
		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("jobmgt/resumeList");

		return modelAndView;

	}	
	
	
	
	@ResponseBody
	@RequestMapping(value="/queryResumeList",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryResumeList(@ModelAttribute("ResumeQuery") ResumeQuery resumeQuery,HttpServletRequest request) throws Exception {

		// 调用service查找 数据库，查询用户
		DatatablesView<Resume> dataTable = resumeService.queryResumeList(resumeQuery);
		dataTable.setDraw(resumeQuery.getDraw());
		
		String data = JSONObject.fromObject(dataTable).toString();
		return data;
	}	
}
