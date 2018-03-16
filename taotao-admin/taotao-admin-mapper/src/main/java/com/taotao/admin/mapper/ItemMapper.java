package com.taotao.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.taotao.admin.pojo.Item;

import tk.mybatis.mapper.common.Mapper;

public interface ItemMapper extends Mapper<Item>{

	/** 多条件查询商品 */
	List<Map<String, Object>> findAll(@Param("item")Item item);

	List<Map<String, Object>> findItemByWhere(@Param("item") Item item);
	

}
