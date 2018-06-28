package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.StatusRepository;
import com.smartdev.user.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Integer id) {
        return statusRepository.findOne(id);
    }
}
