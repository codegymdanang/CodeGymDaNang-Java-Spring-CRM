package com.smartdev.controller;

import com.smartdev.crm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.Set;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        boolean isSeller = false;
        boolean isManager = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_SELLER")) {
                isSeller = true;
            } else if (grantedAuthority.getAuthority().equals("ROLE_MANAGER")) {
                isManager = true;
            }
        }
        if (isManager == true) {
            return "redirect:/manager_crm/home";
        } else if (isSeller) {
            return "redirect:/seller/list-custom-seller";
        } else {
            return "login";
        }

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
}
