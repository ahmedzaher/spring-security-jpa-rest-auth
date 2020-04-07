package com.example.jpa.auth.service;

import com.example.jpa.auth.core.SystemUserDetails;
import com.example.jpa.auth.model.SystemUser;
import com.example.jpa.auth.repository.SystemUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemUserDetailsService implements UserDetailsService {

    private SystemUserRepository systemUserRepository;

    public SystemUserDetailsService(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SystemUser> user = systemUserRepository.findByUsername(username);

        user.orElseThrow( ()-> new UsernameNotFoundException("User not found"));

        return user.map(SystemUserDetails::new).get();
    }
}
