
/**
* Project Name:trainingCenter
* File Name:CenterController.java
* Package Name:com.center.controller.org
* Date:2016年12月22日下午2:22:59
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.controller.atndmgt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.atndmgt.Leave;
import com.center.po.org.Center;
import com.center.service.atndmgt.LeaveService;
import com.center.service.org.CenterService;

/**
* ClassName:LeaveController <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月22日 下午2:22:59 <br/>
* @author lidi
* @version
* @see
*/
@Controller
@RequestMapping("/leave")
public class LenterController {

	@Autowired
	private LeaveService leaveService;
	
	
	@RequestMapping("/queryLeave")
	public ModelAndView queryLeaveById(HttpServletRequest request) throws Exception {
		// 调用service查找 数据库，查询用户
		Leave leave = leaveService.queryLeaveById(1);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribute
		modelAndView.addObject("leave", leave);

		
		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("attndmgt/leave");

		return modelAndView;

	}
	
}

