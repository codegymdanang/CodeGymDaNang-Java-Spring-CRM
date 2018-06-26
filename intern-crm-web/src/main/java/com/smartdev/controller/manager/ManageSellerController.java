package com.smartdev.controller.manager;

import com.smartdev.user.entity.SellerDetail;
import com.smartdev.crm.service.SellerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manager_crm")
public class ManageSellerController {

    @Autowired
    private SellerDetailService sellerDetailService;

    @RequestMapping(value="/list-seller")
    public String listSeller(Model model) {
        List<SellerDetail> sellerDetails = sellerDetailService.getAllSellerDetail();
        for (SellerDetail sellerDetail :sellerDetails) {
            System.out.println(sellerDetail.toString());
        }

        model.addAttribute("sellerDetails",sellerDetails);

        return "list-seller";
    }



}
