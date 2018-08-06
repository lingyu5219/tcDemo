
/**
* Project Name:trainingCenter
* File Name:PositionServiceImpl.java
* Package Name:com.center.service.impl.hrmgt
* Date:2016年12月26日下午3:15:31
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.impl.jobmgt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.jobmgt.CompanyMapper;
import com.center.po.jobmgt.Company;
import com.center.service.jobmgt.CompanyService;

/**
 * ClassName:PositionServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月26日 下午3:15:31 <br/>
 * 
 * @author 
 * @version
 * @see
 */
@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	private CompanyMapper companyMapper;

	// 查询全部职位列表
	public List<Company> queryCompanyList() throws Exception {

		List<Company> positionList = companyMapper.queryCompanyList();

		return positionList;

	}
	// 添加职位信息
	@Override
	public boolean addCompany(Company company) throws Exception {
		boolean b = false;
		try {
			companyMapper.addCompany(company);
			b = true;
		} catch (Exception e) {
			b = false;
		}

		return b;
		
	}
	// 查询某个ID或职位名
	@Override
	public List<Company> queryCompanyBycoName(String coName) throws Exception {
		List<Company> companylist = companyMapper.queryCompanyBycoName(coName);

		return companylist;
		
	}
	// 职位信息更新
	@Override
	public Boolean updateCompany(Company company) throws Exception {
		boolean b = false;
		try {
			companyMapper.updateCompany(company);
			b = true;
		} catch (Exception e) {
			b = false;
		}

		return b;
		
	}
	// 删除教职工信息
	@Override
	public Boolean deleteCompany(int coId) throws Exception {
		boolean b = false;
		try {
			companyMapper.deleteCompany(coId);
			b = true;
		} catch (Exception e) {
			b = false;
		}

		return b;
		
	}

}
