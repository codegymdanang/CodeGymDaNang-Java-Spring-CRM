package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.CustomerRepository;
import com.smartdev.user.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchApiServiceImpl implements SearchApiService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<Customer> searchCustomerAPI(String name, Integer page) {
        Pageable pageable = new PageRequest(page-1, 10);
        if(name.equals("") || name == ""){
            return customerRepository.findAll(pageable);
        }else{
            return customerRepository.findByNameContainingAndIsDelete(name, 0, pageable);
        }
    }
}
