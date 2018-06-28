package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.HistoryAdvisoryRepository;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryAdvisoryServiceImpl implements HistoryAdvisoryService {
    @Autowired
    HistoryAdvisoryRepository historyAdvisoryRepository;

    @Override
    public List<HistoryAdvisory> findByCustomerByCustomerId(Customer customer) {
        return historyAdvisoryRepository.findByCustomerByCustomerId(customer);
    }

    @Override
    public HistoryAdvisory saveHistoryAdvisory(HistoryAdvisory theHistoryAdvisory) {
        return historyAdvisoryRepository.save(theHistoryAdvisory);
    }
}
