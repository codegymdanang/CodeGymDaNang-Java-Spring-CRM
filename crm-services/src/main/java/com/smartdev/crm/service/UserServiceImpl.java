package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.RoleRepository;
import com.smartdev.user.dao.repository.SellerDetailRepository;
import com.smartdev.user.dao.repository.UserRepository;
import com.smartdev.user.entity.Role;
import com.smartdev.user.entity.SellerDetail;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SellerDetailRepository sellerDetailRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public boolean isUserExist(String userName) {

        User user = userRepository.findOne(userName);
        boolean result = user != null;
        return result;
    }

    @Override
    public void save(User user) {
//        user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        user.setIsDelete(0);

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName("SELLER");
        roles.add(role);
        user.setRoles(roles);

        SellerDetail sellerDetail = new SellerDetail();
        sellerDetail.setUserByUserName(user);
        sellerDetail.setUserName(user.getUserName());
        userRepository.save(user);
        sellerDetailRepository.save(sellerDetail);
    }

    @Override
    public User findByUsername(String username) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if(user.getUserName().equals(username))
                return user;
        }
        return null;
    }
}
