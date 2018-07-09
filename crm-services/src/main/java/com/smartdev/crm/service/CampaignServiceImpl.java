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
}
