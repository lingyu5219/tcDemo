package com.center.service.org;

import javax.servlet.http.HttpServletRequest;

import com.center.po.org.Center;
import com.center.po.org.CenterQuery;
import com.center.po.query.DatatablesView;
import com.center.po.stumgt.Student;

/**
* ClassName:CenterService <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月22日 下午2:16:07 <br/>
* @author niit
* @version
* @see
*/
public interface CenterService {

    public void addCenter(Center center,HttpServletRequest request) throws Exception;
	
	public DatatablesView<Center> queryCenterList(CenterQuery centerQuery) throws Exception;
	
	public boolean deleteCenterById(int centerId) throws Exception;
	
	public void modifyCenterById(CenterQuery centerQuery) throws Exception;
	
}

