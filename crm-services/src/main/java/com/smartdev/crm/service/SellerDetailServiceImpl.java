package com.smartdev.crm.service;

import com.smartdev.crm.service.SellerDetailService;
import com.smartdev.user.dao.repository.SellerDetailRepository;
import com.smartdev.user.entity.SellerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerDetailServiceImpl implements SellerDetailService {
    @Autowired
    SellerDetailRepository sellerDetailRepository;

    @Override
    public List<SellerDetail> getAllSellerDetail() {
        return sellerDetailRepository.findAll();
    }
}
