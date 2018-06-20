package com.smartdev.controller.manager;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manager_crm")
public class HomePageManagerController {


	@RequestMapping(value = "/list-custom-manage", method = RequestMethod.GET)
	public String listCustomManage(){
		return "list-custom-manage";
	}

	@RequestMapping(value = "/home")
	public String homeManager() {
		return "home-manager";
	}




}

