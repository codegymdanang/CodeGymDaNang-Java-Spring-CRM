package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.HistoryAdvisoryRepository;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.smartdev.user.model.StatusCount;

import java.time.Year;
import java.time.YearMonth;
import java.util.*;

@Service
public class HistoryAdvisoryServiceImpl implements HistoryAdvisoryService {

    public static final String PROSPECT = "Prospect";
    public static final String LEAD = "Lead";
    public static final String POTENTIAL_LEAD = "Potential";
    public static final String ACTIVE_LEAD = "Active";

    @Autowired
    HistoryAdvisoryRepository historyAdvisoryRepository;
  
    @Override
    public List<HistoryAdvisory> getHistoryAdvisoriesByCustomer(Customer customer) {
        return historyAdvisoryRepository.findByCustomerByCustomerId(customer);
    }

    @Override
    public void save(HistoryAdvisory historyAdvisory) {
        historyAdvisoryRepository.save(historyAdvisory);
    }
    
    @Override
    public List<HistoryAdvisory> findAll() {
        return historyAdvisoryRepository.findAll();
    }

    @Override
    public List<Integer> getYearOfHistoryAdvisory() {
        List<Integer> years = new ArrayList<>();
        List<HistoryAdvisory> historyAdvisories = findAll();
        for(HistoryAdvisory ha : historyAdvisories) {
            int year = getYearFromDate(ha.getDate());
            if(checkYearUnique(years, year))
                years.add(getYearFromDate(ha.getDate()));
        }
        return years;
    }

    public boolean checkYearUnique(List<Integer> years, int year) {
        for (int y : years) {
            if(year == y)
                return false;
        }
        return true;
    }

    @Override
    public StatusCount getNumberOfEachStatusByYearAndMonth(int year, int month) {
        StatusCount statusCount = new StatusCount(0,0,0,0);
        if(month > 12 || month < 1)
            return statusCount;
        Date dateFrom = getDateFromCalendar(year, month, 1);
        Date dateTo = getDateFromCalendar(year, month, getDaysInMonth(year, month));
        List<HistoryAdvisory> historyAdvisories = historyAdvisoryRepository.findHistoryAdvisoriesByDateBetween(dateFrom, dateTo);
//        List<HistoryAdvisory> historyAdvisories = findAll();
        for(HistoryAdvisory historyAdvisory : historyAdvisories) {
            if(getYearFromDate(historyAdvisory.getDate()) == year && getMonthFormDate(historyAdvisory.getDate()) == month) {
                switch (historyAdvisory.getStatusByStatusId().getName()) {
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
        }
        return statusCount;
    }


    private int getYearFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date == null)
            return 0;
        calendar.setTime(date);
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        return calendar.get(Calendar.YEAR);
    }

    private int getMonthFormDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date == null) {
            return 0;
        }
        calendar.setTime(date);
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        return calendar.get(Calendar.MONTH) + 1;
    }

    private Date getDateFromCalendar(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date);
        return calendar.getTime();
    }

    private int getDaysInMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth.lengthOfMonth();
    }
}
