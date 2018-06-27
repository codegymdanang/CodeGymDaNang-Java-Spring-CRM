package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;


    @Override
    public Integer getRoleIdByName(String name) {
        return roleRepository.findByName(name).getId();
    }
}
