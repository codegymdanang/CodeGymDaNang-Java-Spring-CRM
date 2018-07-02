package com.smartdev.controller.seller;

import com.smartdev.crm.service.CustomerService;
import com.smartdev.crm.service.user.UserService;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/seller")
public class HomePageSellerController {
	@Autowired
	private UserService userService;
	@Autowired
	private CustomerService customerService;
	@RequestMapping(value = "/list-custom-seller", method = RequestMethod.GET)
	public String listCustomSeller(Principal principal, Model model){
		String username = principal.getName();
		User user =userService.getUserByUserName(username);
		List<Customer> customers = customerService.findByUserBySellerAndIsDelete(user,0);
		model.addAttribute("customers",customers);
		return "list-custom-seller";


	}

}

