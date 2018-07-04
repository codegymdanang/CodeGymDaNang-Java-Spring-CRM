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

    @Override
    public SellerDetail findByUsername(String username) {
        List<SellerDetail> sellerDetails = getAllSellerDetail();
        for(SellerDetail sellerDetail : sellerDetails) {
            if(sellerDetail.getUserName().equals(username)) {
                return sellerDetail;
            }
        }
        return null;
    }

    @Override
    public void update(SellerDetail sellerDetail) {
        sellerDetailRepository.save(sellerDetail);
    }
}
