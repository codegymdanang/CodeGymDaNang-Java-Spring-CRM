package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.HistoryAdvisoryRepository;
import com.smartdev.user.entity.HistoryAdvisory;
import com.smartdev.user.model.StatusCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class HistoryAdvisoryServiceImpl implements HistoryAdvisoryService {

    public static final String PROSPECT = "prospect";
    public static final String LEAD = "lead";
    public static final String POTENTIAL_LEAD = "potential lead";
    public static final String ACTIVE_LEAD = "active lead";

    @Autowired
    private HistoryAdvisoryRepository historyAdvisoryRepository;

    @Override
    public List<HistoryAdvisory> findAll() {
        return historyAdvisoryRepository.findAll();
    }

    @Override
    public StatusCount getNumberOfEachStatus() {
        List<HistoryAdvisory> historyAdvisories = findAll();
        if(historyAdvisories.isEmpty())
            return new StatusCount(0,0,0,0);
        StatusCount statusCount = new StatusCount();
        for (HistoryAdvisory h : historyAdvisories) {
            switch (h.getStatusByStatusId().getName()) {
                case PROSPECT:
                    statusCount.setProspect(statusCount.getProspect() + 1);
                    break;
                case LEAD:
                    statusCount.setLead(statusCount.getLead() + 1);
                    break;
                case POTENTIAL_LEAD:
                    statusCount.setPotentialLead(statusCount.getPotentialLead() + 1);
                    break;
                case ACTIVE_LEAD:
                    statusCount.setActiveLead(statusCount.getActiveLead() + 1);
                    break;
            }
        }
        return statusCount;
    }

    @Override
    public List<Integer> getYearOfHistoryAdvisory() {
        List<Integer> years = new ArrayList<>();
        List<HistoryAdvisory> historyAdvisories = findAll();
        for(HistoryAdvisory ha : historyAdvisories) {
            years.add(getYearFromDate(ha.getDate()));
        }
        return years;
    }

    private int getYearFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date == null)
            return 0;
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }


}
