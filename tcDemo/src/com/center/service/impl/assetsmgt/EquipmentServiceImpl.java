package com.center.service.impl.assetsmgt;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.center.mapper.assetsmgt.EquipmentMapper;
import com.center.po.assetsmgt.Equipment;
import com.center.po.assetsmgt.EquipmentQuery;
import com.center.po.query.DatatablesView;
import com.center.service.assetsmgt.EquipmentService;


@Service
public class EquipmentServiceImpl implements EquipmentService{
	

	@Autowired
	private EquipmentMapper equipmentMapper;
	
	@Override
	public List<EquipmentQuery> queryEquipment(EquipmentQuery equipmentQuery) throws Exception {
		List<EquipmentQuery> equipmentList = equipmentMapper.queryEquipmentList(equipmentQuery);
		return equipmentList;
	}
	
	public DatatablesView<EquipmentQuery> queryEquipmentList(EquipmentQuery equipmentQuery) throws Exception {
		DatatablesView<EquipmentQuery> dataView = new DatatablesView<EquipmentQuery>();
		Long count = equipmentMapper.queryEquipmentCount(equipmentQuery);
		List<EquipmentQuery> equipmentList = equipmentMapper.queryEquipmentList(equipmentQuery);
		
		dataView.setRecordsTotal(count);
	    dataView.setData(equipmentList);
		return dataView ;
	}
	

	public boolean deleteEquipmentById(int equipmentId) throws Exception {
		
		int affectedRecords = equipmentMapper.deleteEquipmentById(equipmentId);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}

}
	
	public void addEquipment(Equipment equipment,HttpServletRequest request) throws Exception {
		//HttpSession session = request.getSession();	
		equipmentMapper.addEquipment(equipment);
		
	}
	
	
	public boolean updateEquipmentById(Equipment equipment, HttpServletRequest request) throws Exception {
		//HttpSession session = request.getSession();
		//UserTest loginUser = (UserTest)	session.getAttribute("user");
		//user.setCreateBy(1);
		
		int affectedRecords = equipmentMapper.updateEquipmentById(equipment);
		
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}

}
