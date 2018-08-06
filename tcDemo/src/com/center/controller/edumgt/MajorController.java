
/**
* Project Name:trainingCenter
* File Name:majorController.java
* Package Name:com.center.controller.edumgt
* Date:2016年12月26日下午2:19:22
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

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

import com.center.po.edumgt.Major;
import com.center.po.edumgt.MajorQuery;
import com.center.po.query.DatatablesView;
import com.center.service.edumgt.MajorService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:majorController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月26日 下午2:19:22 <br/>
 * 
 * @author ChenZhenQiu
 * @version
 * @see
 */
@Controller
@RequestMapping("/edumgt")
public class MajorController {
	@Autowired
	private MajorService majorService;

	// 跳转到majorList页面
	@RequestMapping(value = "/majorList", method = RequestMethod.GET)
	public ModelAndView studentList(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edumgt/majorList");

		return modelAndView;

	}
	
	@ResponseBody
	@RequestMapping(value = "/queryMajor", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String queryMajor(@ModelAttribute("majorQuery") MajorQuery majorQuery, HttpServletRequest request) throws Exception {
		
		List<Major> majorList = majorService.queryMajor(majorQuery);
		String data = JSONArray.fromObject(majorList).toString();
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryMajorList", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String queryMajorList(@ModelAttribute("majorQuery") MajorQuery majorQuery, HttpServletRequest request) throws Exception {
		
		DatatablesView<Major> dataview = majorService.queryMajorList(majorQuery);
		dataview.setDraw(majorQuery.getDraw());

		String data = JSONObject.fromObject(dataview).toString();

		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addMajor", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String addMajor(@ModelAttribute("major") Major major, HttpServletRequest request) throws Exception {
		majorService.addMajor(major,request);
		
		HashMap<String, String> rsMap = new HashMap<String, String>();
		if (major.getMajorId() > 0) {
			rsMap.put("status", "1");
			rsMap.put("info", "增加成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "增加失败");
		}
		String data = JSONObject.fromObject(rsMap).toString();
		return data;
	}

	@ResponseBody
	@RequestMapping(value = "/delMajor", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String delMajor(@ModelAttribute("majorId") int majorId,HttpServletRequest request) throws Exception {
		HashMap<String, String> rsMap = new HashMap<String, String>();
		boolean result = majorService.deleteMajorByID(majorId);
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

	@ResponseBody
	@RequestMapping(value = "/updateMajor", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String updateMajor(@ModelAttribute("major") Major major, HttpServletRequest request) throws Exception {

		HashMap<String, String> rsMap = new HashMap<String, String>();
		boolean result = majorService.updateMajor(major);
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
