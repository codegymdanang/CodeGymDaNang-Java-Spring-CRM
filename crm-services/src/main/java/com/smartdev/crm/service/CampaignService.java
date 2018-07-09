package com.smartdev.crm.service;

import com.smartdev.user.entity.Campaign;

import java.util.List;

public interface CampaignService {
    List<Campaign> getAll();
    List<Campaign> findByNameContaining(String key);
   List<Campaign> findByDateEnd_MonthOrAndDateStart_Month(int x, int y);
    List<Campaign> findByDateMonAndName(int month , int month1 , String key);
}
