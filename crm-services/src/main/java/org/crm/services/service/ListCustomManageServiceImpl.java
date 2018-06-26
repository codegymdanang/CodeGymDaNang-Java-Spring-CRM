package org.crm.services.service;

import com.smartdev.user.dao.repository.ListCustomManageRepository;
import com.smartdev.user.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCustomManageServiceImpl implements ListCustomManageService {


    @Autowired
    ListCustomManageRepository listCustomManageRepository;


    @Override
    public List<Customer> listAllCustomer() {
        return listCustomManageRepository.listAllCustomer();
    }
}
