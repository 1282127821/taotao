package com.taotao.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.taotao.admin.pojo.ItemCat.ItemCat;

import tk.mybatis.mapper.common.Mapper;

/**
 * 商品类目数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2018年3月11日 下午6:52:55
 * @version 1.0
 */
public interface ItemCatMapper extends Mapper<ItemCat> {
	/**
	 * 根据父级id查询所有的物品类目
	 * @param parentId 父级id
	 * @return 集合
	 * 这里不要纠结为嘛使用map接收，因为一般只要是多表查询都是使用map接收，当然单表也可以
	 * 然后由于形参parentId和 sql中一致，所以可以省略@param
	 */
	@Select("select id, name as text, is_parent as state from tb_item_cat where parent_id = #{parentId} order by id asc")
	List<Map<String, Object>> getItemCatByParentId(Long parentId);
}