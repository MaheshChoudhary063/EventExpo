package com.eventexpo.EventExpo.config;

import com.eventexpo.EventExpo.model.UserInfo;
import com.eventexpo.EventExpo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    private static final Logger logger = Logger.getLogger(UserInfoUserDetailsService.class.getName());
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = repository.findByUsername(username); // Ensure you are using the username field
        if (userInfo == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserInfoUserDetails(userInfo);
    }

}
