package com.taotao.admin.service;

import com.taotao.admin.pojo.Item;
import com.taotao.common.pojo.DataGridResult;

public interface ItemService {

	void saveItem(Item item, String desc);

	DataGridResult findItemByWhere(Item item, Integer page, Integer rows);
	
}
