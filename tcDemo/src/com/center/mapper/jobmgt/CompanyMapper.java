package com.center.mapper.jobmgt;

import java.util.List;

import com.center.po.jobmgt.Company;



public interface CompanyMapper {
	
	// 查询全部职位信息
		public List<Company> queryCompanyList() throws Exception;

		// 添加职位信息
		public void addCompany(Company company) throws Exception;

		// 查询某个ID或信息名
		public List<Company> queryCompanyBycoName(String coName) throws Exception;

		// 存储职位更新信息
		public void updateCompany(Company company) throws Exception;

		// 删除教职工信息
		public void deleteCompany(int coId) throws Exception;
		

	
}
