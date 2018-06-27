package com.smartdev.crm.service.user;

import com.smartdev.user.dao.repository.UserRepository;
import com.smartdev.user.entity.Role;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findOne(userName);
        if(user.getIsDelete() == 0) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
            for (Role role : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), grantedAuthorities);
        }else {
            return null;
        }
    }
}
