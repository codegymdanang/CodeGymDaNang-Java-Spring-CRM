package com.smartdev.crm.service;

import com.smartdev.user.entity.Customer;
import org.springframework.data.domain.Page;

public interface SearchApiService {
    public Page<Customer> searchCustomerAPI(String name, Integer page);
}
