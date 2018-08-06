
/**
* Project Name:trainingCenter
* File Name:PositionController.java
* Package Name:com.center.controller.hrmgt
* Date:2016年12月26日下午3:20:40
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.controller.hrmgt;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.hrmgt.Position;
import com.center.po.hrmgt.PositionQuery;
import com.center.po.query.DatatablesView;
import com.center.service.hrmgt.PositionService;

import net.sf.json.JSONObject;

/**
 * ClassName:PositionController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月26日 下午3:20:40 <br/>
 * 
 * @author 李逢杰
 * @version
 * @see
 */
@Controller
// 为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
@RequestMapping("/hrmgt")
public class PositionController {

	@Autowired
	private PositionService positionService;
	
	//进入职位管理功能
		@RequestMapping(value = "/positionList", method = RequestMethod.GET)
		public ModelAndView positionList(HttpServletRequest request) throws Exception {
			// 返回ModelAndView
			ModelAndView modelAndView = new ModelAndView();

			// 指定视图
			// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
			// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
			modelAndView.setViewName("hrmgt/positionList");

			return modelAndView;

		}

	// 新增职位
	@ResponseBody
	@RequestMapping(value="/addPosition",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String addPosition(@ModelAttribute("position") Position position,HttpServletRequest request) throws Exception {

		position.setCreateBy(1);

		Boolean b = positionService.addPosition(position,request);
		HashMap<String,String> rsMap = new HashMap<String,String>();
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

	// 删除职位
	@ResponseBody
	@RequestMapping(value="/delPosition",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String delPosition(@ModelAttribute("positionId") int positionId,HttpServletRequest request) throws Exception {
		HashMap<String,String> rsMap = new HashMap<String,String>();
		Boolean b = positionService.deletePosition(positionId);
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

	// 查询职位列表
	@ResponseBody
	@RequestMapping(value = "/queryPositionList", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String queryPositionList(@ModelAttribute("PositionQuery") PositionQuery positionQuery,HttpServletRequest request) throws Exception {
		// 调用service查找 数据库，查询用户
		DatatablesView<Position> dataTable = positionService.queryPosition(positionQuery);

		dataTable.setDraw(positionQuery.getDraw());

		String data = JSONObject.fromObject(dataTable).toString();

		return data;
	}

	// 修改职位
	@ResponseBody
	@RequestMapping(value="/updatePosition",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String updatePosition(@ModelAttribute("position") Position position,HttpServletRequest request) throws Exception {
		HashMap<String,String> rsMap = new HashMap<String,String>();
		Boolean b = positionService.updatePosition(position,request);
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

}
