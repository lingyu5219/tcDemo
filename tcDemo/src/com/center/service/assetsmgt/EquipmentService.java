package com.center.service.assetsmgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.center.po.assetsmgt.Equipment;
import com.center.po.assetsmgt.EquipmentQuery;
import com.center.po.query.DatatablesView;


public interface EquipmentService {
	public List<EquipmentQuery> queryEquipment(EquipmentQuery equipmentQuery) throws Exception;
	public DatatablesView<EquipmentQuery> queryEquipmentList(EquipmentQuery equipmentQuery) throws Exception;
	public boolean deleteEquipmentById(int equipmentId) throws Exception;
	public void addEquipment( Equipment equipment,HttpServletRequest request) throws Exception;	
	public boolean updateEquipmentById(Equipment equipment,HttpServletRequest request) throws Exception;
}
