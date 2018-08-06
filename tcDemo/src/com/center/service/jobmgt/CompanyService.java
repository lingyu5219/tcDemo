
/**
* Project Name:trainingCenter
* File Name:ResumeService.java
* Package Name:com.center.service.jobmgt
* Date:2016年12月23日下午3:19:22
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.jobmgt;


import java.util.List;

import com.center.po.jobmgt.Company;



public interface CompanyService {
	
	// 查询全部职位信息
		public List<Company> queryCompanyList() throws Exception;

		// 添加职位信息
		public boolean addCompany(Company company) throws Exception;

		// 查询某个ID或职位名
		public List<Company> queryCompanyBycoName(String coName) throws Exception;
		
		// 存储职位更新信息
		public Boolean updateCompany(Company company)throws Exception;
		// 删除教职工信息
		public Boolean deleteCompany(int coId) throws Exception;
	
}
