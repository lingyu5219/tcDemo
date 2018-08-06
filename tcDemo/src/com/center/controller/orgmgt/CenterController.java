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

import com.center.po.org.Center;
import com.center.po.org.CenterQuery;
import com.center.po.query.DatatablesView;
import com.center.service.org.CenterService;

import net.sf.json.JSONObject;

//createBy:ly
// query:center/centerList
// update:center/modifyCenter
// delete:center/deleteCenter
// add:center/addCenter
@Controller
@RequestMapping("/center")
public class CenterController {

	@Autowired
	private CenterService centerService;
	
	//返回全部中心信息
	@RequestMapping(value = "/centerList", method = RequestMethod.GET)
	public ModelAndView centerList(HttpServletRequest request) throws Exception {
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("org/centerList");

		return modelAndView;

	}
		
	//根据条件查询信息
	@ResponseBody
	@RequestMapping(value="/queryCenterList", method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryCenterList(@ModelAttribute("Center")CenterQuery centerQuery,HttpServletRequest request) throws Exception {
		DatatablesView<Center> dataTable= centerService.queryCenterList(centerQuery);
		String data = JSONObject.fromObject(dataTable).toString();
	 
		return data;
	}
	
	//添加信息
	@ResponseBody
	@RequestMapping(value="/addCenter",method=RequestMethod.POST)
	public String addCenter(@ModelAttribute("CenterQuery")CenterQuery centerQuery,HttpServletRequest request) throws Exception {
		
		centerService.addCenter(centerQuery, request);;
		String data = JSONObject.fromObject(centerQuery).toString();
		return data;
	 
		  
	}
	 
	//删除信息
	@ResponseBody
	@RequestMapping(value="/deleteCenter",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String deleteCenterById(@ModelAttribute("centerId") int centerId,HttpServletRequest request) throws Exception {
		HashMap<String,String> rsMap = new HashMap<String,String>();
		boolean result = centerService.deleteCenterById(centerId);
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
	@RequestMapping(value="/modifyCenter",method=RequestMethod.POST)
	public String modifyCenter(@ModelAttribute("CenterQuery")CenterQuery centerQuery,HttpServletRequest request) throws Exception {
		
		centerService.modifyCenterById(centerQuery);;
		String data = JSONObject.fromObject(centerQuery).toString();
		return data;
	 
		  
	}	 
	
//	@RequestMapping("/queryCenter")
//	public ModelAndView queryCenterByName(HttpServletRequest request) throws Exception {
//		// 返回ModelAndView
//		ModelAndView modelAndView = new ModelAndView();
//		// 指定视图
//		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
//		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
//		modelAndView.setViewName("center/centerList");
//		return modelAndView;
//
//	}
//	
//	@RequestMapping("/queryCenterResult")
//	public ModelAndView queryCenterResult(HttpServletRequest request) throws Exception {
//		// 返回ModelAndView
//		ModelAndView modelAndView = new ModelAndView();
//		
//		String centerName =request.getParameter("centerName");
//				
//		// 调用service查找 数据库，查询用户
//		List<Center> center = centerService.queryCenterByName(centerName);
//		if(center!=null){
//			// 相当 于request的setAttribute
//			//将center对象返回给页面
//			modelAndView.addObject("center", center);
//		}else{
//			modelAndView.addObject("info","没有区域中心！");
//		}
//		
//		// 指定视图
//		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
//		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
//		modelAndView.setViewName("center/centerList");
//		return modelAndView;
//
//	}
	
}

