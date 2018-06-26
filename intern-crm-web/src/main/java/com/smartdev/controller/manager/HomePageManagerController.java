package com.smartdev.controller.manager;

import org.crm.services.service.ListCustomManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manager_crm")
public class HomePageManagerController {
	@RequestMapping(value = "/home")
	public String homeManager() {
		return "home-manager";
	}




}

