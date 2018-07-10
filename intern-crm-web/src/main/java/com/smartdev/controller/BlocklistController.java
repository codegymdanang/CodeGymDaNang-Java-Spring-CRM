package com.smartdev.controller;

import com.smartdev.crm.service.CustomerService;
import com.smartdev.crm.service.StatusService;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class BlocklistController {
    @Autowired
    CustomerService customerService;
    @Autowired
    StatusService statusService;
    @RequestMapping(value = "/blocklist",method = RequestMethod.GET)
    public ModelAndView blockList(ModelAndView modelAndView,@RequestParam(defaultValue = "1") Integer pageNum, Authentication authentication){
        Pageable pageable = new PageRequest(pageNum-1, 1);
        Status status = statusService.findById(5);
        Page<Customer> customerListblock = customerService.findCustomersByStatusId(status,pageable);
//        ModelAndView modelAndView = new ModelAndView("blocklist");
        modelAndView.addObject("itemsBlock",customerListblock);
        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_SELLER")) {
                modelAndView.setViewName("block-list-for-seller");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_MANAGER")) {
                modelAndView.setViewName("block-list-for-manager");
                break;
            }

        }
        return modelAndView;
    }
}
