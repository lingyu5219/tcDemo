
/**
* Project Name:trainingCenter
* File Name:ScoreController.java
* Package Name:com.center.controller.perfmgt
* Date:2017年1月11日下午8:21:32
* Copyright (c) 2017, Tony All Rights Reserved.
*
*/

package com.center.controller.perfmgt;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.perfmgt.Score;
import com.center.po.perfmgt.ScoreQuery;
import com.center.po.query.DatatablesView;
import com.center.service.perfmgt.ScoreService;

import net.sf.json.JSONObject;

/**
* ClassName:ScoreController <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2017年1月11日 下午8:21:32 <br/>
* @author 钱兆瑞
* @version
* @see
*/

@Controller
@RequestMapping("/perfmgt")
public class ScoreController {
	
	@Autowired
	
	private ScoreService scoreService;
	
//	进入成绩查询学生页面
	@RequestMapping("/scoreStuList")
	public ModelAndView scoreStuList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();		

		String jsonDate=scoreService.queryScoreJsonData();
		
		modelAndView.addObject("jsonDate", jsonDate);
		
		modelAndView.addObject("userId", 1);
		
		modelAndView.setViewName("perfmgt/scoreStuList");	
		
		return modelAndView;

	}
	
//	进入成绩查询教师页面
	@RequestMapping("/scoreTchList")
	public ModelAndView scoreTchList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();		

		String jsonDate=scoreService.queryScoreJsonData();
		
		modelAndView.addObject("jsonDate", jsonDate);
		
		modelAndView.setViewName("perfmgt/scoreTchList");	
		
		return modelAndView;

	}
	
//	查询学生成绩	
	@ResponseBody
	@RequestMapping(value="/queryScoreList",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryScoreForTeacher(@ModelAttribute("scoreQuery") ScoreQuery scoreQuery,HttpServletRequest request) throws Exception {

		DatatablesView<ScoreQuery> dataTable=scoreService.queryScore(scoreQuery);
		dataTable.setDraw(scoreQuery.getDraw());		
		String data = JSONObject.fromObject(dataTable).toString();
		
		return data;

	}
	
//  添加 修改成绩	
	@ResponseBody
	@RequestMapping(value="/updateScore",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String updateScore(@ModelAttribute("score") Score score,HttpServletRequest request) throws Exception {
		HashMap<String,String> rsMap = new HashMap<String,String>();
		
		score.setCreateBy(1);
		
		boolean result = scoreService.updateScore(score);
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
	
//  删除成绩	
	@ResponseBody
	@RequestMapping(value="/delScore",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String deleteScore(@ModelAttribute("score") Score score,HttpServletRequest request) throws Exception {
		HashMap<String,String> rsMap = new HashMap<String,String>();
		
		boolean result = scoreService.deleteScore(score.getScoreId());
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

