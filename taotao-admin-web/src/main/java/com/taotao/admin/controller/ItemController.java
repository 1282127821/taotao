package com.taotao.admin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.admin.pojo.Item;
import com.taotao.admin.service.ItemService;
import com.taotao.common.pojo.DataGridResult;



@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService; 
	@PostMapping("/save")
	@ResponseBody
	public void saveItem(Item item,@RequestParam("desc") String desc) {
		itemService.saveItem(item,desc);
		System.out.println("--xy-----------------------");
	}
	@GetMapping
	@ResponseBody
	public DataGridResult selectItem(Item item, 
			@RequestParam("page")Integer page,
			@RequestParam("rows")Integer rows){
		if (item!=null&&StringUtils.isNoneBlank(item.getTitle())) {
			//这里之所以要url解码就是因为前台做了url编码，所以必须，否则你懂得（）
			try {
				item.setTitle(URLDecoder.decode(item.getTitle(), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return itemService.findItemByWhere(item,page,rows);
	}
}
