package com.taotao.admin.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.admin.mapper.ItemCatMapper;
import com.taotao.admin.mapper.ItemDescMapper;
import com.taotao.admin.mapper.ItemMapper;
import com.taotao.admin.pojo.Item;
import com.taotao.admin.pojo.ItemDesc;
import com.taotao.admin.service.ItemService;
import com.taotao.common.pojo.DataGridResult;
@Service
@Transactional(readOnly=false,rollbackFor=RuntimeException.class)
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;
	@Override
	public void saveItem(Item item, String desc) {
		try {
			//保存商品信息
			item.setCreated(new Date());
			item.setUpdated(item.getCreated());
			item.setStatus(1);
			itemMapper.insertSelective(item);
			ItemDesc itemDesc=new ItemDesc();
			itemDesc.setCreated(new Date());
			itemDesc.setUpdated(itemDesc.getCreated());
			itemDesc.setItemId(item.getId());
			itemDesc.setItemDesc(desc);
			//保存商品描叙
			itemDescMapper.insertSelective(itemDesc);
			System.out.println( desc+"desc");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	/** 带条件分页查询商品 */
	public DataGridResult findItemByWhere(final Item item, 
					Integer page, Integer rows){
		try{
			/** 开启分页 */
			PageInfo<Map<String,Object>> pageInfo = PageHelper
					.startPage(page, rows).doSelectPageInfo(new ISelect() {
				@Override
				public void doSelect() {
					itemMapper.findItemByWhere(item);
				}
			});
			return new DataGridResult(pageInfo.getTotal(), pageInfo.getList());
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

}
