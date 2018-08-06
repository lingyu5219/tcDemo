
/**
* Project Name:trainingCenter
* File Name:PositionController.java
* Package Name:com.center.controller.hrmgt
* Date:2016年12月26日下午3:20:40
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.controller.jobmgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.center.po.jobmgt.Company;
import com.center.service.jobmgt.CompanyService;

/**
* ClassName:PositionController <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月26日 下午3:20:40 <br/>
* @author 
* @version
* @see
*/
@Controller
//为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	// 添加公司信息
		@RequestMapping("/queryCompanyAdd")
		public ModelAndView queryCompanyAdd(Company company) throws Exception {

			company.setCreateBy(1);

			Boolean b = companyService.addCompany(company);

			// 返回ModelAndView
			ModelAndView modelAndView = new ModelAndView();

			// 指定视图
			if (b == true) {
				modelAndView.setViewName("jobmgt/CompanySuccess");
			} else {
				modelAndView.setViewName("jobmgt/CompanyFault");
			}

			return modelAndView;

		}
		
		// 删除教职工信息
		@RequestMapping("/queryCompanyDelete")
		public ModelAndView queryCompanyDelete(HttpServletRequest request) throws Exception {
			
			int coId=Integer.parseInt(request.getParameter("coId"));
			Boolean b = companyService.deleteCompany(coId);
			// 返回ModelAndView
			ModelAndView modelAndView = new ModelAndView();

			// 指定视图
			if (b == true) {
				modelAndView.setViewName("jobmgt/CompanySuccess");
			} else {
				modelAndView.setViewName("jobmgt/CompanyFault");
			}

			return modelAndView;
		}
	
	// 查询全部公司列表
		@RequestMapping("/queryCompanyList")
		public ModelAndView queryCompanyList(HttpServletRequest request) throws Exception {

			// 调用service查找 数据库，查询用户
			List<Company> companyList = companyService.queryCompanyList();

			// 返回ModelAndView
			ModelAndView modelAndView = new ModelAndView();
			// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
			modelAndView.addObject("companyList", companyList);

			// 指定视图
			modelAndView.setViewName("hrmgt/Position");

			return modelAndView;

		}
		
		// 查询某个公司id或职位名
		@RequestMapping("/queryCompanyBycoName")
		public ModelAndView queryCompanyBycoName(HttpServletRequest request) throws Exception {
			// 获取request的coname 并转成utf-8
			String coname = new String(request.getParameter("coname").getBytes("iso-8859-1"), "utf-8");

			// 调用service查找 数据库，查询用户
			List<Company> companyList = companyService.queryCompanyBycoName(coname);

			// 返回ModelAndView
			ModelAndView modelAndView = new ModelAndView();
			// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
			modelAndView.addObject("companyList", companyList);

			// 指定视图
			// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
			// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
			modelAndView.setViewName("hrmgt/Position");

			return modelAndView;

		}

		// 获取单选框选中的id
		@RequestMapping("/queryCompanyById")
		public ModelAndView queryCompanyById(HttpServletRequest request) throws Exception {
			// 获取request的coname 并转成utf-8
			String coname = new String(request.getParameter("coname").getBytes("iso-8859-1"), "utf-8");

			// 调用service查找 数据库，查询coname
			List<Company> companyList = companyService.queryCompanyBycoName(coname);
			// 返回ModelAndView
			ModelAndView modelAndView = new ModelAndView();
			// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
			modelAndView.addObject("company",companyList);

			// 指定视图
			// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
			// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
			modelAndView.setViewName("jobmgt/companyUpdate");

			return modelAndView;

		}
		
		// 存储公司更新信息
		@RequestMapping("/queryCompanyUpdate")
		public ModelAndView queryCompanyUpdate(Company company) throws Exception {

			Boolean b = companyService.updateCompany(company);

			// 返回ModelAndView
			ModelAndView modelAndView = new ModelAndView();

			// 指定视图
			if (b == true) {
				modelAndView.setViewName("jobmgt/CompanySuccess");
			} else {
				modelAndView.setViewName("jobmgt/CompanyFault");
			}

			return modelAndView;

		}

}
