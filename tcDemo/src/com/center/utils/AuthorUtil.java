
/**
* Project Name:trainingCenter
* File Name:AuthorUtil.java
* Package Name:com.center.utils
* Date:2017年3月2日上午10:07:34
* Copyright (c) 2017, Tony All Rights Reserved.
*
*/

package com.center.utils;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.po.system.Menu;
import com.center.service.system.MenuService;

/**
* ClassName:AuthorUtil <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2017年3月2日 上午10:07:34 <br/>
* @author Tony
* @version
* @see
*/
@Service
public class AuthorUtil {
	@Autowired
	private MenuService menuService;
	
	private HashMap<String,Menu> menuMap = null;
	
	
	public HashMap<String,Menu> getMenuMap(){
		if (null == menuMap) {
			menuMap = new HashMap<String,Menu>();
			refreshMenuMap();
		}
		return menuMap;
	}
	
	public void refreshMenuMap(){
		try {
			menuMap.clear();
			List<Menu> menuList = menuService.queryMenu(null);
			for(Menu menu : menuList){
				menuMap.put(menu.getLocation(), menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

