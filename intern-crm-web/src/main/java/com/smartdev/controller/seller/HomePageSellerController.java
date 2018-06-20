package com.smartdev.controller.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/seller")
public class HomePageSellerController {
	@RequestMapping(value = "/list-custom-seller", method = RequestMethod.GET)
	public String listCustomSeller(){
		return "list-custom-seller";
	}

}

