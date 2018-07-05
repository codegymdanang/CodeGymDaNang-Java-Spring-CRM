package com.smartdev.crm.service;

import com.smartdev.crm.service.user.UserService;
import com.smartdev.user.dao.repository.CustomerRepository;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;
import com.smartdev.user.entity.Status;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String PROSPECT = "Prospect";

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SellerDetailService sellerDetailService;

    @Autowired
    StatusService statusService;

    @Autowired
    HistoryAdvisoryService historyAdvisoryService;

    @Autowired
    UserService userService;

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
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = sellerDetailService.findByUsername(username).getUserByUserName();
        Status status = statusService.findByName(PROSPECT);
        customer.setStatusByStatusId(status);
        customer.setUserBySeller(user);
        saveCustomer(customer);
        HistoryAdvisory historyAdvisory = new HistoryAdvisory();
        historyAdvisory.setStatusByStatusId(status);
        historyAdvisory.setCustomerByCustomerId(customer);
        historyAdvisory.setComment("New Customer");
        Timestamp createdDate = new Timestamp(new Date().getTime());
        historyAdvisory.setDate(createdDate);
        historyAdvisoryService.save(historyAdvisory);
    }

    @Override
    public Customer findOneid(Integer id) {
        return customerRepository.findOne(id);
    }

    @Override
    public List<Customer> findByUserBySellerAndIsDelete(User user, Integer isDelete) {
        return customerRepository.findByUserBySellerAndIsDelete(user, isDelete);
    }

    @Override
    public Page<Customer> findCustomersByStatusId(Status status, Pageable pageable) {
        return customerRepository.findByStatusByStatusIdAndIsDelete(status, 0, pageable);
    }

    @Override
    public Page<Customer> findCustomersByProductType(Integer productType, Pageable pageable) {
        return customerRepository.findAllByProductTypeAndIsDelete(productType, 0, pageable);
    }

    @Override
    public Page<Customer> findByProductTypeAndStatusByStatusId(Integer productType, Status
            statusId, Pageable pageable) {
        return customerRepository.findByProductTypeAndStatusByStatusId(productType, statusId, pageable);
    }


    @Override
    public List<Customer> findByNameContaining(String name, Integer isDelete) {
        return customerRepository.findByNameContainingAndIsDelete(name, isDelete);
    }

    @Override
    public List<Customer> findByCompanyContaining(String company, Integer isDelete) {
        return customerRepository.findByCompanyContainingAndIsDelete(company, isDelete);
    }

    @Override
    public List<Customer> findByMailContaining(String mail, Integer isDelete) {
        return customerRepository.findByMailContainingAndIsDelete(mail, isDelete);
    }

    @Override
    public List<Customer> findByUserBySeller(User user, Integer isDelete) {

        return customerRepository.findByUserBySellerAndIsDelete(user, isDelete);
    }

    @Override
    public List<Customer> checkOption(String option, String search) {
        List<Customer> customers = null;
        switch (option) {
            case "Name":
                customers = findByNameContaining(search, 0);
                break;

            case "Company":
                customers = findByCompanyContaining(search, 0);
                break;
            case "Mail":
                customers = findByMailContaining(search, 0);
                break;
            case "SellerName":
                User user = userService.getUserByUserName(search);
                customers = findByUserBySeller(user, 0);
                break;

        }
        return customers;

    }

    @Override
    public Page<Customer> listAllCustomer(Pageable pageable) {
        return customerRepository.findByIsDelete(0, pageable);
    }

    @Override
    public Page<Customer> listCustomerWithFilter(Integer statusId, Integer productType, Integer
            pageNum) {
        Pageable pageable = new PageRequest(pageNum-1, 10);
        statusId = statusId == null ? 0 : statusId;
        productType = productType == null ? 0 : productType;
        if (statusId == 0 && productType == 0) {
            return listAllCustomer(pageable);
        } else {
            if (statusId == 0) {
                return findCustomersByProductType(productType, pageable);
            } else {
                Status status = statusService.findById(statusId);
                if (productType == 0) {
                    return findCustomersByStatusId(status, pageable);
                } else {
                    return findByProductTypeAndStatusByStatusId(productType, status, pageable);
                }
            }
        }
    }
}
