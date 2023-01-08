package org.example.service;

import org.example.model.User;
import org.example.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserService userServ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServ.findByUserName(username);
        if (user==null) throw new UsernameNotFoundException("User 404");
        UserPrincipal principal = new UserPrincipal(user);
        System.out.println("%%%%"+principal.getAuthorities());
        return principal;
    }
}