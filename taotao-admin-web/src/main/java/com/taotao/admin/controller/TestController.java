package com.taotao.admin.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.admin.service.TestService;
@RestController
public class TestController {
	
	/** 注入服务接口代理对象 */
	//@Autowired
	@Resource(name="testService1")
	private TestService testService;
	
	@GetMapping("/date")
	public String queryCurrentDate(){
		System.out.println("testService:" + testService);
		return testService.queryCurrentTime();
	}
}
