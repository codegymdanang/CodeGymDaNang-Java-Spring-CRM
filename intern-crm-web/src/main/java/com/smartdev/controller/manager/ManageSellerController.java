package com.smartdev.controller.manager;

import com.smartdev.crm.service.UserService;
import com.smartdev.user.entity.SellerDetail;
import com.smartdev.crm.service.SellerDetailService;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/manager_crm")
public class ManageSellerController {

    @Autowired
    private SellerDetailService sellerDetailService;
    @Autowired
    private UserService userService;

    @RequestMapping(value="/list-seller")
    public String listSeller(Model model) {
        List<SellerDetail> sellerDetails = sellerDetailService.getAllSellerDetail();

        model.addAttribute("sellerDetails",sellerDetails);

        return "list-seller";
    }
    @RequestMapping(value = "/create-seller-form")
    public  String createSeller(Model model){
        model.addAttribute("user", new User());
        return "create-seller";
    }

    @RequestMapping(value = "/create-seller")
    public String createSeller(Model model,@Valid  @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("bingding result:" + bindingResult);
            return "create-seller";
        }
        if(userService.isUserExist(user.getUserName())){
//            System.out.println("Username is not available");
            model.addAttribute("existuser","Username was used, choose another one");
            return "create-seller";
        }
//            System.out.println(user.getUserName()+user.getPassWord());
        userService.save(user);
        return "redirect:/manager_crm/list-seller";
    }

}
