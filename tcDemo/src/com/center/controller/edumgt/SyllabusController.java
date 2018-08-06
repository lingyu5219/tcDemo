package com.center.controller.edumgt;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.center.controller.common.BaseController;
import com.center.po.edumgt.Sybitem;
import com.center.po.edumgt.Syllabus;
import com.center.po.edumgt.SyllabusQuery;
import com.center.po.query.DatatablesView;
import com.center.service.edumgt.SyllabusService;
import com.center.vo.common.JsonVo;
import com.center.vo.edumgt.Section;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/syllabus")
public class SyllabusController extends BaseController{
	@Autowired
	private SyllabusService syllabusService;

	
	private Logger log = Logger.getLogger(SyllabusController.class);

	@RequestMapping("/getThisSyllabus")
	private String getThisWeekSyllabus(HttpServletRequest request){
		request.setAttribute("year", "2013");
		request.setAttribute("sylQuarter", "第八学期");
		request.setAttribute("batchName", "java1");
		return "/edumgt/syllabusList";
	}
	
	
	@RequestMapping(value="/getThisSyllabusWithJson",produces="text/json;charset=UTF-8")
	@ResponseBody
	private String getThisWeekSyllabus(SyllabusQuery syllabusQuery,HttpServletRequest request) {
		DatatablesView<Section> dataTable = syllabusService.getThisWeekSyllabus(syllabusQuery);
		if(dataTable==null){
			return "error";
		}
		return JSONObject.fromObject(dataTable).toString();
	}
	
	@RequestMapping(value="/addSyllabus",produces="text/json;charset=UTF-8")
	@ResponseBody
	private String addSyllabus(Syllabus syllabus,Model model,HttpServletRequest request){
		JsonVo jsonVo = syllabusService.addSyllabus(syllabus);
		return JSONObject.fromObject(jsonVo).toString();
	}
	
	@RequestMapping(value="updateSyllabus",produces="text/json;charset=UTF-8")
	@ResponseBody
	private String updateSyllabus(Syllabus syllabus,HttpServletRequest request){
		JsonVo jsonVo = syllabusService.updateSyllabus(syllabus);
		return JSONObject.fromObject(jsonVo).toString();
	}
	
	@RequestMapping(value="/loadSyllabus",produces="text/json;charset=UTF-8")
	@ResponseBody
	private String loadSyllabus(SyllabusQuery syllabusQuery,HttpServletRequest request){
		DatatablesView<Syllabus> dataTable = syllabusService.loadSyllabus(syllabusQuery);
		if(dataTable==null){
			return "error";
		}
		return JSONObject.fromObject(dataTable).toString();
	}
	
	@RequestMapping("/mgtSyllabusList")
	private String mgtSyllabusList(HttpServletRequest request){
		return "/edumgt/mgtSyllabusList";
	}
	
	@RequestMapping(value="/deleteSyllabus",produces="text/json;charset=UTF-8")
	@ResponseBody
	private String deleteSyllabus(String id,HttpServletRequest request){
		Map<String,String> rsMap = new HashMap<String,String>();
		boolean result = syllabusService.deleteSyllabus(Integer.valueOf(id));
		if (result) {
			rsMap.put("status", "1");
			rsMap.put("info", "删除成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "删除失败");
		}
		return JSONObject.fromObject(rsMap).toString();
	}
	
	@RequestMapping(value="/loadSybitem",produces="text/json;charset=UTF-8")
	@ResponseBody
	private String loadSybitem(String syllabusId,String sybitemCondition,String start,String length,HttpServletRequest request){
		DatatablesView<Sybitem> dataTable = new DatatablesView<Sybitem>();
		if(!StringUtils.isEmpty(syllabusId)){
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher check = pattern.matcher(syllabusId);
			if(check.matches()){
				dataTable = syllabusService.loadSybitem(syllabusId,sybitemCondition,start,length);
			}			
		}else{
			
		}
		return JSONObject.fromObject(dataTable).toString();
	}
	
	@RequestMapping("/mgtSybitemList")
	private String mgtSybitemList(String syllabusId,HttpServletRequest request){
		request.setAttribute("syllabusId", syllabusId);
		return "/edumgt/mgtSybitemList";
	}
	
	@RequestMapping(value="/addSybitem",produces="text/json;charset=UTF-8")
	@ResponseBody
	private String addSybitem(String begin,String end,Sybitem sybitem,HttpServletRequest request){
		log.info(sybitem.toString());
		JsonVo  jsonVo = syllabusService.addSybitem(sybitem,begin,end);
		request.setAttribute("syllabusId", sybitem.getSyllabusId());
		return JSONObject.fromObject(jsonVo).toString();
	}
	
	@RequestMapping(value="updateSybitem",produces="text/json;charset=UTF-8")
	@ResponseBody
	private String updateSybitem(Sybitem sybitem,String begin,String end,HttpServletRequest request){
		JsonVo jsonVo = syllabusService.updateSybitem(sybitem, begin, end);
		return JSONObject.fromObject(jsonVo).toString();
	}
	
	@RequestMapping(value="/delSybitem",produces="text/json;charset=UTF-8")
	@ResponseBody
	private String delSybitem(String syllabusId,String id,HttpServletRequest request){
		Map<String,String> rsMap = new HashMap<String,String>();
		boolean result =syllabusService.deleteSybitem(Integer.valueOf(id));
		if (result) {
			rsMap.put("status", "1");
			rsMap.put("info", "删除成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "删除失败");
		}
		request.setAttribute("syllabusId,", syllabusId);
		return JSONObject.fromObject(rsMap).toString();
	}
}
