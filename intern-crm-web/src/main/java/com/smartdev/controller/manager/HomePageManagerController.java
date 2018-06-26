package com.smartdev.controller.manager;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager_crm")
public class HomePageManagerController {
	@RequestMapping(value = "/home")
	public String homeManager() {
		return "home-manager";
	}




}

