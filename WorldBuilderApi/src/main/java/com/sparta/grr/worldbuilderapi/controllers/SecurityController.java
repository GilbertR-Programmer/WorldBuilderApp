package com.sparta.grr.worldbuilderapi.controllers;

import com.sparta.grr.worldbuilderapi.dtos.LoginDto;
import com.sparta.grr.worldbuilderapi.dtos.RegisterDto;
import com.sparta.grr.worldbuilderapi.entities.MyUser;
import com.sparta.grr.worldbuilderapi.services.JwtService;
import com.sparta.grr.worldbuilderapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityController(AuthenticationManager authenticationManager, JwtService jwtService, UserService userService, PasswordEncoder passwordEncoder){
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public MyUser createUser(@RequestBody RegisterDto requestedUser){
        return makeUser(requestedUser, "USER");
    }

    @PostMapping("/admin/register")
    public MyUser createUserWithPrivileges(@RequestBody RegisterDto requestedUser){
        return makeUser(requestedUser, requestedUser.roles());
    }

    private MyUser makeUser(RegisterDto requestedUser, String roles) {
        if(userService.existsByUsername(requestedUser.username())) {
            return null;
        }
        MyUser user = new MyUser();
        user.setUsername(requestedUser.username());
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(requestedUser.password()));
        return userService.addUser(user);
    }


    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginDto request){
        Authentication result = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.username(),request.password()
        ));
        if(result.isAuthenticated()){
            UserDetails user = userService.loadUserByUsername(request.username());
            return jwtService.generateToken(user);

        } else {
            throw new UsernameNotFoundException("No user with name " + request.username());
        }
    }
}
