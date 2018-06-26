package com.smartdev.controller.manager;

import com.smartdev.crm.service.HistoryAdvisoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manager_crm")
public class HomePageManagerController {

	@Autowired
	HistoryAdvisoryService historyAdvisoryService;

	@RequestMapping(value = "/home")
	public ModelAndView homeManager() {
		ModelAndView modelAndView = new ModelAndView("home-manager");
		modelAndView.addObject("years", historyAdvisoryService.getYearOfHistoryAdvisory());
		return modelAndView;
	}




}

