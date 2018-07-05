package com.smartdev.crm.service;

import com.smartdev.user.entity.Campaign;

import java.util.List;

public interface CampaignService {
    List<Campaign> getAll();
    List<Campaign> findByNameContaining(String name);

}
