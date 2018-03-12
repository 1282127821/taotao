package com.taotao.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.admin.mapper.TestMapper;
import com.taotao.admin.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private TestServiceImpl t;
	
	@Override
	public String queryCurrentTime() {
		System.out.println(t+"----------------------->执行了吗");
		return testMapper.queryCurrentTime();
	}

}
