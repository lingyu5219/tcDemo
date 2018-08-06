package com.center.controller.user;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.query.DatatablesView;
import com.center.po.user.UserQueryTest;
import com.center.po.user.UserTest;
import com.center.service.user.UserTestService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 
* ClassName: UserController <br/>
* Function: dasdf. <br/>
* Reason: TODO ADD REASON(可选). <br/>
* date: 2016年12月22日 下午1:25:19 <br/>
*
* @author 陈涛
* @version
 */
@Controller
//为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：查询用户：/user/queryUserById
@RequestMapping("/userTest")
public class UserTestController {
	@Autowired
	private UserTestService userService;

	@RequestMapping(value = "/userListJson", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> userListJson(HttpServletRequest request) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		List<UserTest> userList = new ArrayList<UserTest>();
		UserTest user1 = new UserTest();
		user1.setUserAccount("test");
		UserTest user2 = new UserTest();
		user2.setUserAccount("admin");
		userList.add(user1);
		userList.add(user2);
		map.put("userList", userList);
		return map;
	}
	
	/**
	 * 
	* userList:(通过此方法转发到用户管理页面，作为进入用户管理功能的入口). <br/>
	* TODO(这里描述这个方法适用条件 – 可选).<br/>
	* TODO(这里描述这个方法的执行流程 – 可选).<br/>
	* TODO(这里描述这个方法的使用方法 – 可选).<br/>
	* TODO(这里描述这个方法的注意事项 – 可选).<br/>
	*
	* @author Tony
	* @param request
	* @return
	* @throws Exception
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView userList(HttpServletRequest request) throws Exception {
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
		// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("user/userList");

		return modelAndView;

	}
	
	/**
	 * 
	* queryUser:下拉框查询用户. <br/>
	* TODO(这里描述这个方法适用条件 – 可选).<br/>
	* TODO(这里描述这个方法的执行流程 – 可选).<br/>
	* TODO(这里描述这个方法的使用方法 – 可选).<br/>
	* TODO(这里描述这个方法的注意事项 – 可选).<br/>
	*
	* @author Tony
	* @param userQuery
	* @param request
	* @return
	* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/queryUser",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryUser(@ModelAttribute("UserQuery") UserQueryTest userQuery,HttpServletRequest request) throws Exception {

		// 调用service查找 数据库，查询用户
		List<UserTest> userList = userService.queryUser(userQuery);
		
		String data = JSONArray.fromObject(userList).toString();
		return data;
	}
	
	/**
	 * 
	* queryUserList:(根据条件查询用户列表). <br/>
	* TODO(这里描述这个方法适用条件 – 可选).<br/>
	* TODO(这里描述这个方法的执行流程 – 可选).<br/>
	* TODO(这里描述这个方法的使用方法 – 可选).<br/>
	* TODO(这里描述这个方法的注意事项 – 可选).<br/>
	*
	* @author Tony
	* @param userQuery
	* @param request
	* @return
	* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/queryUserList",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryUserList(@ModelAttribute("UserQuery") UserQueryTest userQuery,HttpServletRequest request) throws Exception {

		// 调用service查找 数据库，查询用户
		DatatablesView<UserTest> dataTable = userService.queryUserList(userQuery);
		dataTable.setDraw(userQuery.getDraw());
		
		String data = JSONObject.fromObject(dataTable).toString();
		return data;
	}
	
	/**
	 * 
	* deleteUser:(根据ID删除用户). <br/>
	* TODO(这里描述这个方法适用条件 – 可选).<br/>
	* TODO(这里描述这个方法的执行流程 – 可选).<br/>
	* TODO(这里描述这个方法的使用方法 – 可选).<br/>
	* TODO(这里描述这个方法的注意事项 – 可选).<br/>
	*
	* @author Tony
	* @param userId
	* @param request
	* @return
	* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/delUser",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String deleteUser(@ModelAttribute("userId") int userId,HttpServletRequest request) throws Exception {
		HashMap<String,String> rsMap = new HashMap<String,String>();
		boolean result = userService.deleteUserById(userId);
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
	
	/**
	 * 
	* addUser:(增加用户). <br/>
	* TODO(这里描述这个方法适用条件 – 可选).<br/>
	* TODO(这里描述这个方法的执行流程 – 可选).<br/>
	* TODO(这里描述这个方法的使用方法 – 可选).<br/>
	* TODO(这里描述这个方法的注意事项 – 可选).<br/>
	*
	* @author Tony
	* @param user
	* @param request
	* @return
	* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/addUser",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String addUser(@ModelAttribute("user") UserTest user,HttpServletRequest request) throws Exception {
		userService.addUser(user,request);
		
		HashMap<String,String> rsMap = new HashMap<String,String>();
		if (user.getUserId() > 0) {
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
	@RequestMapping(value="/updateUser",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String updateUser(@ModelAttribute("user") UserTest user,HttpServletRequest request) throws Exception {
		boolean result = userService.updateUserById(user,request);
		
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
	
	
	public static void main(String args[]) throws Exception{
		Field fields[] = UserTest.class.getDeclaredFields();
		System.out.println(fields.length);
	}
}
