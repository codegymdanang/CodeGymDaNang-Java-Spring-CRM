package org.crm.services.service;

import com.smartdev.user.dao.repository.CustomerRepository;
import com.smartdev.user.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customer.setIsDelete(0);
        saveCustomer(customer);
    }
}
