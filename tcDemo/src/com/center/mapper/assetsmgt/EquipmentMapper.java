package com.center.mapper.assetsmgt;

import java.util.List;
import com.center.po.assetsmgt.Equipment;
import com.center.po.assetsmgt.EquipmentQuery;

/**
 * 
* ClassName: EquipmentMapper <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON(可选). <br/>
* date: 2016年12月30日 下午2:40:46 <br/>
*
* @author SunChaoLun
* @version
 */
public interface EquipmentMapper {
	public List<EquipmentQuery> queryEquipmentList(EquipmentQuery equipmentQuery) throws Exception;
	public Long queryEquipmentCount(EquipmentQuery equipmentQuery) throws Exception;
	public int deleteEquipmentById(int EquipmentId) throws Exception;
	public void addEquipment(Equipment equipment) throws Exception;
	public int updateEquipmentById(Equipment equipment) throws Exception;

}
