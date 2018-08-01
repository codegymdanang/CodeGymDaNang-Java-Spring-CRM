package com.smartdev.controller;

import com.smartdev.crm.service.SearchApiService;
import com.smartdev.user.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchControllerAPI {
    @Autowired
    private SearchApiService searchApiService;

    @RequestMapping(value = "search-customer-api", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> searchCustomerApi(@RequestParam String name,
                                            @RequestParam(defaultValue = "1") Integer page){
        return searchApiService.searchCustomerAPI(name, page).getContent();
    }
}
