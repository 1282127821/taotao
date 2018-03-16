package com.taotao.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageForwardController {
	@GetMapping("/page/{viewName}")
	public String forward(@PathVariable("viewName") String viewName) {
		return viewName;
		
	}
}
