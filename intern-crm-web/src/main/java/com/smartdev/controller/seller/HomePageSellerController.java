package com.smartdev.controller.seller;

import com.smartdev.crm.service.CustomerService;
import com.smartdev.crm.service.HistoryAdvisoryService;
import com.smartdev.crm.service.SellerDetailService;
import com.smartdev.crm.service.helper.PasswordChecker;
import com.smartdev.crm.service.helper.SellerDetailToUserSellerDetail;
import com.smartdev.crm.service.user.UserService;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;
import com.smartdev.user.entity.SellerDetail;
import com.smartdev.user.entity.User;
import com.smartdev.user.model.UserSellerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/seller")
public class HomePageSellerController {

    @Autowired
    private UserService userService;

    @Autowired
    private SellerDetailService sellerDetailService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    HistoryAdvisoryService historyAdvisoryService;

  	@RequestMapping(value = "/list-custom-seller", method = RequestMethod.GET)
public String listCustomSeller(Principal principal, Model model,@RequestParam(defaultValue = "1") Integer pageNum){
		String username = principal.getName();
		User user =userService.getUserByUserName(username);
		Page<Customer> customers = customerService.listCustomerForSeller(user,pageNum);
        HashMap<Customer,HistoryAdvisory> map = new HashMap<>();
        for (Customer c:customers) {
            List<HistoryAdvisory> historyAdvisoryList = historyAdvisoryService.getHistoryAdvisoriesByCustomer(c);
            HistoryAdvisory historyAdvisory = historyAdvisoryList.get(0);
            map.put(c,historyAdvisory);
        }
	model.addAttribute("customers",customers);
	model.addAttribute("map",map);
	return "list-custom-seller";
}

    @RequestMapping(value = "/update-seller-detail", method = RequestMethod.GET)
    public String updateSellerDetail(Principal principal, Model model) {
        String username = principal.getName();
        SellerDetail sellerDetail = sellerDetailService.findByUsername(username);
        UserSellerDetails userSellerDetails = SellerDetailToUserSellerDetail.convertToUserSellerDetail(sellerDetail);
        model.addAttribute("userSellerDetails", userSellerDetails);
        return "update-seller-detail";
    }

    @RequestMapping(value = "/update-seller-detail", method = RequestMethod.POST)
    public String updateSellerDetail(@Valid @ModelAttribute("userSellerDetails") UserSellerDetails userSellerDetails,
                                     BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return "update-seller-detail";
        }
        String password = userSellerDetails.getPassword();
        String confirmPassword = userSellerDetails.getConfirmPassword();

        if(PasswordChecker.isBlank(password,confirmPassword)==false){
            if(PasswordChecker.isGreaterThan6Chars(password,confirmPassword)){
                if(PasswordChecker.isMatch(password,confirmPassword)){
                    User user = userService.getUserByUserName(userSellerDetails.getUsername());
                    user.setPassWord(password);
                    userService.update(user);

                }else {
                    model.addAttribute("passwordErrors","Password does not match");
                    return "update-seller-detail";
                }
            }else {
                model.addAttribute("passwordErrors","Password must greater than 6 chars");
                return "update-seller-detail";
            }
        }

        SellerDetail sellerDetail = sellerDetailService.findByUsername(userSellerDetails.getUsername());

        sellerDetail.setName(userSellerDetails.getName());
        sellerDetail.setAge(userSellerDetails.getAge());
        sellerDetail.setPhone(userSellerDetails.getPhone());
        sellerDetail.setMail(userSellerDetails.getMail());

        sellerDetailService.update(sellerDetail);

        return "redirect:/seller/list-custom-seller";
    }

}

