package com.smartdev.controller.manager;

import com.smartdev.crm.service.HistoryAdvisoryService;
import com.smartdev.user.model.StatusCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manager_crm")
public class HomePageManagerController {

	@Autowired
	HistoryAdvisoryService historyAdvisoryService;

	@RequestMapping(value = "/home")
	public ModelAndView homeManager() {
		ModelAndView modelAndView = new ModelAndView("manager-home");
		modelAndView.addObject("years", historyAdvisoryService.getYearOfHistoryAdvisory());
		return modelAndView;
	}

	@RequestMapping(value = "/home-info")
	@ResponseBody
	public ResponseEntity<StatusCount> home(@RequestParam int year, @RequestParam int month) {
		System.out.println(year + " " + month);
		StatusCount statusCount = historyAdvisoryService.getNumberOfEachStatusByYearAndMonth(year, month);
		return new ResponseEntity<>(statusCount, HttpStatus.OK);
	}
}

