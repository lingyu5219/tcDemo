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

import com.center.po.edumgt.Batch;
import com.center.po.edumgt.BatchQuery;
import com.center.po.query.DatatablesView;
import com.center.service.edumgt.BatchService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/edumgt")
public class BatchController {

	@Autowired
	private BatchService batchService;
	
	@RequestMapping(value = "/batchList", method = RequestMethod.GET)
	public ModelAndView batchList(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("edumgt/batchList");
		return modelAndView;
	}
	
	//根据条件查询信息
	@ResponseBody
	@RequestMapping(value="/queryBatchList", method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryBatchList(@ModelAttribute("batchQuery")BatchQuery batchQuery,HttpServletRequest request) throws Exception {
		
		DatatablesView<Batch> dataTable= batchService.queryBatchList(batchQuery);
		dataTable.setDraw(batchQuery.getDraw());
		
		String data = JSONObject.fromObject(dataTable).toString();
		return data;
	}

	@ResponseBody
	@RequestMapping(value="/queryBatch", method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryBatch(@ModelAttribute("batchQuery")BatchQuery batchQuery,HttpServletRequest request) throws Exception {
		List<Batch> batchList = batchService.queryBatch(batchQuery);
		
		String data = JSONArray.fromObject(batchList).toString();
		return data;
	}
	
	//添加信息
	@ResponseBody
	@RequestMapping(value="/addBatch",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String addBatch(@ModelAttribute("batch")Batch batch,HttpServletRequest request) throws Exception {
		batchService.addBatch(batch, request);
		
		HashMap<String,String> rsMap = new HashMap<String,String>();
		if (batch.getBatchId() > 0) {
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
	@RequestMapping(value="/delBatch",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String delBatch(@ModelAttribute("batchId") int batchId,HttpServletRequest request) throws Exception {
		
		boolean result = batchService.delBatch(batchId);
		
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
	@RequestMapping(value="/updateBatch",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String updateBatch(@ModelAttribute("batch")Batch batch,HttpServletRequest request) throws Exception {

		boolean result = batchService.updateBatch(batch);
		
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

