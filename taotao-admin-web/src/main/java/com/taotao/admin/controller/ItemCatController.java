package com.taotao.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.admin.pojo.ItemCat.ItemCat;
import com.taotao.admin.service.ItemCatService;

/**
 * 商品类目控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2018年3月11日 下午6:57:07
 * @version 1.0
 */
@Controller
@RequestMapping("/itemcat")
public class ItemCatController {
	
	/** 注入服务接口代理对象 */
	@Autowired
	private ItemCatService itemCatService;
	
	/** 
	 * 分页查询商品类目 
	 * http://localhost:9091/itemcat/1?rows=5
	 * */
	@GetMapping("/{page}")
	@ResponseBody
	public List<ItemCat> selectItemCatByPage(@PathVariable("page")Integer page,
				@RequestParam(value="rows", defaultValue="20")Integer rows){
		return itemCatService.findItemCatByPage(page, rows);
	}
	
	/**
	 * 根据父级id查询物品类目
	 * @param parentId 父级编号
	 */
	@GetMapping
	@ResponseBody
	public List<Map<String,Object>> selectItemCatByParentId(
			@RequestParam(value="id", defaultValue="0")Long parentId){
			try{
				List<Map<String, Object>> findItemCatByParentId = itemCatService.findItemCatByParentId(parentId);
				System.out.println(findItemCatByParentId);
				return findItemCatByParentId;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return null;
	}
}