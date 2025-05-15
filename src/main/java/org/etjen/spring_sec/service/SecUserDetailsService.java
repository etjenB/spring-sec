package org.etjen.spring_sec.service;

import org.etjen.spring_sec.model.User;
import org.etjen.spring_sec.model.UserPrinciple;
import org.etjen.spring_sec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            System.out.println("User not found.");
            throw new UsernameNotFoundException("User not found.");
        }
        return new UserPrinciple(user);
    }
}
