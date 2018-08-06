package com.center.controller.studymgt;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.hrmgt.Staff;
import com.center.po.query.DatatablesView;
import com.center.po.studymgt.Project;
import com.center.po.studymgt.ProjectQuery;
import com.center.po.stumgt.Student;
import com.center.po.system.User;
import com.center.service.studymgt.ProjectService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
* ClassName: ProjectController <br/>
* Function: TODO ADD FUNCTION. <br/>
* date: 2017年5月9日 下午2:34:04 <br/>
*
* @author Tony
* @version
 */
@Controller
@RequestMapping("/studymgt")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/projectList", method = RequestMethod.GET)
	public ModelAndView userList(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studymgt/projectList");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/queryProject",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryProject(@ModelAttribute("projectQuery") ProjectQuery projectQuery,HttpServletRequest request) throws Exception {

		// 调用service查找 数据库，查询用户
		List<Project> projectList = projectService.queryProject(projectQuery);
		
		String data = JSONArray.fromObject(projectList).toString();
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="/queryProjectList",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryProjectList(@ModelAttribute("projectQuery") ProjectQuery projectQuery,HttpServletRequest request) throws Exception {
		User loginUser = (User)request.getSession().getAttribute("user");
		projectQuery.setCreateBy(loginUser.getUserId());
		// 调用service查找 数据库，查询用户
		DatatablesView<Project> dataTable = projectService.queryProjectList(projectQuery);
		dataTable.setDraw(projectQuery.getDraw());
		
		String data = JSONObject.fromObject(dataTable).toString();
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="/delProject",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String delProject(@ModelAttribute("projectId") int projectId,HttpServletRequest request) throws Exception {
		HashMap<String,String> rsMap = new HashMap<String,String>();
		boolean result = projectService.delProject(projectId);
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
	@RequestMapping(value="/addProject",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String addProject(@ModelAttribute("project") Project project,HttpServletRequest request) throws Exception {
		
		projectService.addProject(project, request);
		
		HashMap<String,String> rsMap = new HashMap<String,String>();
		if (project.getProjectId() > 0) {
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
	@RequestMapping(value="/updateProject",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String updateProject(@ModelAttribute("project") Project project,HttpServletRequest request) throws Exception {
		boolean result = projectService.updateProject(project, request);
		
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
