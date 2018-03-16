package com.taotao.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.taotao.admin.mapper.ItemCatMapper;
import com.taotao.admin.pojo.ItemCat.ItemCat;
import com.taotao.admin.service.ItemCatService;

/**
 *  商品类目的服务接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2018年3月11日 下午6:55:26
 * @version 1.0
 */
@Service
@Transactional
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private ItemCatMapper itemCatMapper;
	
	/** 分页查询商品类目 */
	public List<ItemCat> findItemCatByPage(Integer page, Integer rows){
		/** 开启分页 */
		PageHelper.startPage(page, rows);
		return itemCatMapper.selectAll();
	}

	/**
	 * 根据父级id查询所有的物品类目
	 * @param parentId 父级id
	 * @return 集合
	 */
	public List<Map<String, Object>> findItemCatByParentId(Long parentId){
		// [{id : 1, text : '节点文本', state:'closed|open'}]
		List<Map<String,Object>> itemCats =  
	                    itemCatMapper.getItemCatByParentId(parentId);
		for (Map<String,Object> map : itemCats){
			//这里由于数据库里面的state是1，0所以要转换
			boolean state = (boolean)map.get("state");
			map.put("state", state ? "closed" : "open");
		}
		return itemCats;
	}
}
