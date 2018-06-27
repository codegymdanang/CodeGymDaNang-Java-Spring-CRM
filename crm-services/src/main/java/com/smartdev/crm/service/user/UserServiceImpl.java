package com.smartdev.crm.service.user;

import com.smartdev.user.dao.repository.RoleRepository;
import com.smartdev.user.dao.repository.UserRepository;
import com.smartdev.user.entity.Role;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user, String roleName) {
        user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        HashSet<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(roleName);
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }
}
