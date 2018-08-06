package com.center.controller.edumgt;

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

import com.center.po.edumgt.Year;
import com.center.po.edumgt.YearQuery;
import com.center.po.query.DatatablesView;
import com.center.service.edumgt.YearService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//createBy:ly
//query : edumgt/yearList
//update: edumgt/modifyYear
//delete: edumgt/deleteYear
//add: edumgt/addYear
@Controller
@RequestMapping("/edumgt")
public class YearController {

	@Autowired
	private YearService yearService;
	
	@RequestMapping(value = "/yearList", method = RequestMethod.GET)
	public ModelAndView yearList(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("edumgt/yearList");
		return modelAndView;
	}
	
	//根据条件查询信息
	@ResponseBody
	@RequestMapping(value="/queryYearList", method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryYearList(@ModelAttribute("yearQuery")YearQuery yearQuery,HttpServletRequest request) throws Exception {
		
		DatatablesView<Year> dataTable= yearService.queryYearList(yearQuery);
		dataTable.setDraw(yearQuery.getDraw());
		
		String data = JSONObject.fromObject(dataTable).toString();
		return data;
	}

	@ResponseBody
	@RequestMapping(value="/queryYear", method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryYear(@ModelAttribute("yearQuery")YearQuery yearQuery,HttpServletRequest request) throws Exception {
		List<Year> yearList = yearService.queryYear(yearQuery);
		
		String data = JSONArray.fromObject(yearList).toString();
		return data;
	}
	
	//添加信息
	@ResponseBody
	@RequestMapping(value="/addYear",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String addYear(@ModelAttribute("year")Year year,HttpServletRequest request) throws Exception {
		yearService.addYear(year, request);
		
		HashMap<String,String> rsMap = new HashMap<String,String>();
		if (year.getYearId() > 0) {
			rsMap.put("status", "1");
			rsMap.put("info", "增加成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "增加失败");
		}
		String data = JSONObject.fromObject(rsMap).toString();
		return data;
	}
	 
	//删除信息
	@ResponseBody
	@RequestMapping(value="/delYear",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String delYear(@ModelAttribute("yearId") int yearId,HttpServletRequest request) throws Exception {
		
		boolean result = yearService.deleteYearById(yearId);
		
		HashMap<String,String> rsMap = new HashMap<String,String>();
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
	@RequestMapping(value="/updateYear",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String updateYear(@ModelAttribute("year")Year year,HttpServletRequest request) throws Exception {

		boolean result = yearService.modifyYearById(year);
		
		HashMap<String,String> rsMap = new HashMap<String,String>();
		if (result) {
			rsMap.put("status", "1");
			rsMap.put("info", "更新成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "更新失败");
		}
		String data = JSONObject.fromObject(rsMap).toString();
		return data;
		  
	}
	
}

