
/**
* Project Name:eduSystem
* File Name:SessionInterceptor.java
* Package Name:com.center.interceptor
* Date:2018年5月24日下午10:23:27
* Copyright (c) 2018, Tony All Rights Reserved.
*
*/

/**
* Project Name:eduSystem
* File Name:SessionInterceptor.java
* Package Name:com.center.interceptor
* Date:2018年5月24日下午10:23:27
* Copyright (c) 2018, Tony All Rights Reserved.
*
*/

package com.center.interceptor;
/**
* ClassName:SessionInterceptor <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2018年5月24日 下午10:23:27 <br/>
* @author Tony
* @version
* @see
*/

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/**
 * ClassName: SessionInterceptor <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月24日 下午10:23:27 <br/>
 *
 * @author Tony
 * @version
 */

public class SessionInterceptor implements HandlerInterceptor {

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      java.lang.Exception)
	 */

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

		// TODO Auto-generated method stub

	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      org.springframework.web.servlet.ModelAndView)
	 */

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

		// TODO Auto-generated method stub

	}

	/**
	* TODO 简单描述该方法的实现功能（可选）.
	* @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	*/

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		//判断当前请求是否是ajax请求，如果是则不能直接跳转页面，需要返回一段js实现跳转
		String header = request.getHeader("X-Requested-With");  
	    boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;  
		
		HttpSession session=request.getSession(true); 
		//session中获取用户名信息 
		Object obj = session.getAttribute("user"); 
		if (obj == null || "".equals(obj.toString())) {
			//如果是ajax请求，session超时的情况下，需要通过js跳转到登录页面
			if (isAjax) {
				HashMap<String,String> rsMap = new HashMap<String,String>();
				rsMap.put("status", "0");
				rsMap.put("info", "会话超时，请重新登录");
				response.setCharacterEncoding("utf-8");  
		        PrintWriter out = response.getWriter();
		        out.println(JSONObject.fromObject(rsMap).toString());
		        //out.println("<script>window.location.href=\"${basePath}system/login\";</script>");  
		        out.flush();
		        out.close();
		        return false;
			}
			
			response.sendRedirect(request.getSession().getServletContext().getContextPath() + "/system/login");
			return false;
		}
		return true;
	}

}
