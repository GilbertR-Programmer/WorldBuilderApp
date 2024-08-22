package com.sparta.grr.worldbuilderapi.services;

import com.sparta.grr.worldbuilderapi.entities.MyUser;
import com.sparta.grr.worldbuilderapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        MyUser transferUser =  user.get();
        return User.builder()
                .username(transferUser.getUsername())
                .password(transferUser.getPassword())
                .roles(getRoles(transferUser))
                .build();

    }

    private String[] getRoles(MyUser user){
        if(user.getRoles() == null || user.getRoles().isEmpty()){
            return new String[]{"USER"};
        }return user.getRoles().split(",");
    }

    public MyUser addUser(MyUser user) {
        return userRepository.save(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

}
