package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.CampaignRepository;
import com.smartdev.user.entity.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    CampaignRepository campaignRepository;
    @Override
    public List<Campaign> getAll() {
        return campaignRepository.findAll();
    }

    @Override
    public List<Campaign> findByNameContaining(String key) {
        return campaignRepository.findByNameContaining(key);
    }

   @Override
    public List<Campaign> findByDateEnd_MonthOrAndDateStart_Month(int x,int y) {
        return campaignRepository.findByDateMonth(x,y);
   }

    @Override
    public List<Campaign> findByDateMonAndName(int month, int month1, String key) {
        return campaignRepository.findByDateMonAndName(month,month1,key);
    }

    @Override
    public Campaign save(Campaign campaign) {
        return campaignRepository.save(campaign);
    }
}
