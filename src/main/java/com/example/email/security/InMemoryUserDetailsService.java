package com.example.email.security;

import com.example.email.data.User;
import com.example.email.data.enums.UserRight;
import com.example.email.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InMemoryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUser(username);
        if(user == null) {
            throw new UsernameNotFoundException("User cannot be found");
        }
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRights());
        return new org.springframework.security.core.userdetails.User(user.getFirstName(), user.getPassword(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRight> userRights) {
        HashSet<GrantedAuthority> authorities = new HashSet<>();
        userRights.forEach(it -> authorities.add(new SimpleGrantedAuthority(it.toString())));
        return new ArrayList(authorities);
    }

    private User findUser(String searchParameter) {
        return userService.findUserByEmail(searchParameter);
    }
}
