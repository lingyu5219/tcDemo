package com.center.controller.stumgt;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.query.DatatablesView;
import com.center.po.stumgt.Student;
import com.center.po.stumgt.StudentQuery;
import com.center.service.stumgt.StudentService;

import net.sf.json.JSONObject;

/**
 * 
 * ClassName: StudentController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年12月26日 下午1:36:53 <br/>
 *
 * @author ChenZhenqiu
 * @version
 */

@Controller
// 为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
// 比如：查询用户：/user/queryUserById
@RequestMapping("/stumgt")
public class StudentController {
	@Autowired
	private StudentService studentService;

	// 跳转到studentList页面
	@RequestMapping(value = "/stuList", method = RequestMethod.GET)
	public ModelAndView stuList(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("stumgt/stuList");
		return modelAndView;
	}

	// 跳转到学生注册页面
	@RequestMapping(value = "/regStu", method = RequestMethod.GET)
	public ModelAndView regStu(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("stumgt/stuReg");
		return modelAndView;
	}
	
	// （添加）注册学生信息
	@ResponseBody
	@RequestMapping(value = {"/addStu","/regStu"}, method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String addStu(@ModelAttribute("student") Student student, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		studentService.addStu(student,request);

		HashMap<String, String> rsMap = new HashMap<String, String>();
		if (student.getStuId() > 0) {
			rsMap.put("status", "1");
			rsMap.put("info", "增加成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "增加失败");
		}
		String data = JSONObject.fromObject(rsMap).toString();
		return data;

	}

	// 修改学生信息
	@ResponseBody
	@RequestMapping(value = "/updateStu", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String updateStu(@ModelAttribute("student") Student student, HttpServletRequest request)
			throws Exception {
		HashMap<String, String> rsMap = new HashMap<String, String>();
		boolean result = studentService.updateStu(student);
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

	// 删除学生信息
	@ResponseBody
	@RequestMapping(value = "/delStu", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String delStu(@ModelAttribute("stuId") int stuId,@ModelAttribute("userId") int userId, HttpServletRequest request) throws Exception {
		HashMap<String, String> rsMap = new HashMap<String, String>();
		boolean result = studentService.deleteStu(stuId,userId);
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

	// 根据条件查询学生信息
	@ResponseBody
	@RequestMapping(value = "/queryStuList", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String queryStuList(@ModelAttribute("studentQuery") StudentQuery studentQuery, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DatatablesView<Student> dataTable = studentService.queryStuList(studentQuery);
		dataTable.setDraw(studentQuery.getDraw());
		
		String data = JSONObject.fromObject(dataTable).toString();
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkStu", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String checkStu(@ModelAttribute("studentQuery") StudentQuery studentQuery, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap<String, String> rsMap = new HashMap<String, String>();
		boolean result = studentService.CheckStu(studentQuery);
		if (result) {
			rsMap.put("status", "true");
		} else {
			rsMap.put("status", "false");
		}
		String data = JSONObject.fromObject(rsMap).toString();
		return data;
	}

}
