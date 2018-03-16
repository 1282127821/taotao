package com.taotao.admin.service;

import java.util.List;
import java.util.Map;

import com.taotao.admin.pojo.ItemCat.ItemCat;

import tk.mybatis.mapper.common.Mapper;


/**
 * 商品类目的服务接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2018年3月11日 下午6:54:36
 * @version 1.0
 */
public interface ItemCatService{
	
	/** 分页查询商品类目 */
	List<ItemCat> findItemCatByPage(Integer page, Integer rows);

	List<Map<String, Object>> findItemCatByParentId(Long parentId);

}
