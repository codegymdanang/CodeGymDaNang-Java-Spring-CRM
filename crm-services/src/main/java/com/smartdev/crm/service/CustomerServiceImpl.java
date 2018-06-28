package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.CustomerRepository;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SellerDetailService sellerDetailService;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customer.setIsDelete(0);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = sellerDetailService.findByUsername(username).getUserByUserName();
        customer.setUserBySeller(user);
        saveCustomer(customer);
    }
    @Override
    public Customer afindOneid(Integer id){
        return customerRepository.findOne(id);
    }
}
