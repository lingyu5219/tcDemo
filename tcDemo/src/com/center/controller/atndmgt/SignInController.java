
/**
* Project Name:trainingCenter
* File Name:SignInController.java
* Package Name:com.center.controller.atndmgt
* Date:2016年12月26日下午1:35:29
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.controller.atndmgt;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.center.po.atndmgt.SignIn;
import com.center.po.system.User;
import com.center.service.atndmgt.SignInService;

import net.sf.json.JSONObject;

/**
* ClassName:SignInController <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月26日 下午1:35:29 <br/>
* @author donghao
* @version
* @see
*/
@Controller
@RequestMapping("/atndmgt")
public class SignInController {
	@Autowired
	private SignInService signInService;
	
	@ResponseBody
	@RequestMapping(value="/signIn",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String signIn(HttpServletRequest request) throws Exception {
		HashMap<String, String> rsMap = new HashMap<String, String>();
		//获取当前登录的用户
		User loginUser = (User)request.getSession().getAttribute("user");
		//获取用户客户端IP
		String clientIp = getip(request);
		System.out.println("当前用户的IP:" + clientIp);
		if(null == loginUser){
			rsMap.put("status", "2");
			rsMap.put("info", "您还没有登录，请先登录");
			String data = JSONObject.fromObject(rsMap).toString();
			return data;
		} else if(null != clientIp && clientIp.startsWith("219.146.242")){
			SignIn signIn = new SignIn();
			signIn.setUserId(loginUser.getUserId());
			signIn.setSignInIp(clientIp);
			signIn.setSignInHostName(request.getRemoteHost());
			signInService.addSignIn(signIn);
			
			if (signIn.getSignInId() > 0) {
				rsMap.put("status", "1");
				rsMap.put("info", "签到成功");
			} else {
				rsMap.put("status", "0");
				rsMap.put("info", "签到失败,请重新签到");
			}
			String data = JSONObject.fromObject(rsMap).toString();
			return data;
		} else {
			rsMap.put("status", "3");
			rsMap.put("info", "请前往指定地点打卡");
			String data = JSONObject.fromObject(rsMap).toString();
			return data;
		}
		
	}
	
	private String getip(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		System.out.println("当前x-forwarded-for IP：" + ip);
		String ip2 = request.getRemoteAddr();
		System.out.println("当前RemoteAddr IP：" + ip2);
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	        System.out.println("当前Proxy-Client-IP IP：" + ip);
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	        System.out.println("当前WL-Proxy-Client-IP：" + ip);
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	        System.out.println("当前RemoteAddr IP：" + ip);
	    }
	    return ip;
	} 
		
}

