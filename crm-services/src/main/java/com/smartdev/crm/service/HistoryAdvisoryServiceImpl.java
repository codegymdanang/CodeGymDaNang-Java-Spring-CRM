package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.HistoryAdvisoryRepository;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryAdvisoryServiceImpl implements HistoryAdvisoryService {
    @Autowired
    HistoryAdvisoryRepository historyAdvisoryRepository;

    @Override
    public List<HistoryAdvisory> getHistoryAdvisoriesByCustomer(Customer customer) {
        return historyAdvisoryRepository.findByCustomerByCustomerId(customer);
    }
//    public static final String PROSPECT = "prospect";
//    public static final String LEAD = "lead";
//    public static final String POTENTIAL_LEAD = "potential lead";
//    public static final String ACTIVE_LEAD = "active lead";
//
//    @Autowired
//    private HistoryAdvisoryRepository historyAdvisoryRepository;
//
//    @Override
//    public List<HistoryAdvisory> findAll() {
//        return historyAdvisoryRepository.findAll();
//    }
//
//    @Override
//    public StatusCount getNumberOfEachStatus() {
//        List<HistoryAdvisory> historyAdvisories = findAll();
//        if(historyAdvisories.isEmpty())
//            return new StatusCount(0,0,0,0);
//        StatusCount statusCount = new StatusCount();
//        for (HistoryAdvisory h : historyAdvisories) {
//            switch (h.getStatusByStatusId().getName()) {
//                case PROSPECT:
//                    statusCount.setProspect(statusCount.getProspect() + 1);
//                    break;
//                case LEAD:
//                    statusCount.setLead(statusCount.getLead() + 1);
//                    break;
//                case POTENTIAL_LEAD:
//                    statusCount.setPotentialLead(statusCount.getPotentialLead() + 1);
//                    break;
//                case ACTIVE_LEAD:
//                    statusCount.setActiveLead(statusCount.getActiveLead() + 1);
//                    break;
//            }
//        }
//        return statusCount;
//    }

}
