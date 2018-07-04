package com.smartdev.controller.manager;

import com.smartdev.crm.service.HistoryAdvisoryService;
import com.smartdev.crm.service.helper.PasswordChecker;
import com.smartdev.crm.service.user.UserService;
import com.smartdev.user.entity.User;
import com.smartdev.user.model.StatusCount;
import com.smartdev.user.model.UserSellerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manager_crm")
public class HomePageManagerController {

	@Autowired
	UserService userService;

	@Autowired
	HistoryAdvisoryService historyAdvisoryService;

	@RequestMapping(value = "/home")
	public ModelAndView homeManager() {
		ModelAndView modelAndView = new ModelAndView("home-manager");
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

	@RequestMapping(value="/update-account",method = RequestMethod.GET)
	public String updateAccount(Principal principal,Model model){
		String username = principal.getName();
		UserSellerDetails userSellerDetails = new UserSellerDetails();
		userSellerDetails.setUsername(username);
		model.addAttribute("user",userSellerDetails);
		return "update-manager-account";
	}
	@RequestMapping(value = "/update-account",method = RequestMethod.POST)
	public String updateAccount(@ModelAttribute("user") UserSellerDetails userSellerDetails, Model model){
		String password = userSellerDetails.getPassword();
		String confirmPassword = userSellerDetails.getConfirmPassword();

		if(PasswordChecker.isBlank(password,confirmPassword)==false){
			if(PasswordChecker.isGreaterThan6Chars(password,confirmPassword)){
				if(PasswordChecker.isMatch(password,confirmPassword)){
					User user = userService.getUserByUserName(userSellerDetails.getUsername());
					user.setPassWord(password);
					userService.update(user);
					return "redirect:/manager_crm/home";
				}else {
					model.addAttribute("passwordErrors","Password does not match");
					return "update-manager-account";
				}
			}else {
				model.addAttribute("passwordErrors","Password must greater than 6 chars");
				return "update-manager-account";
			}
		}

		model.addAttribute("passwordErrors","Password is require");
		return "update-manager-account";

	}
}

