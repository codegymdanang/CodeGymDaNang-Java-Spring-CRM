package com.smartdev.controller;

import com.smartdev.crm.service.user.UserService;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.sql.SQLException;
import java.util.Collection;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
//        User user = new User("seller1", "seller1", 0);
//        userService.save(user, "SELLER");
//        System.out.printf("save successfully" + user.getUserName().toString());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "login";
    }

    @RequestMapping(value = " /edit-user", method = RequestMethod.GET)
    public String editUser() {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().
                getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if(authority.getAuthority().equals("ROLE_MANAGER")){
                return "redirect:/manager_crm/update-account";
            }else if(authority.getAuthority().equals("ROLE_SELLER")){
                return "redirect:/seller/update-seller-detail";
            }
        }
        return "#";
    }
}
