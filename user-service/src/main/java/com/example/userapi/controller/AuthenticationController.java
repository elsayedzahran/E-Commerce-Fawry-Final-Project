package com.example.userapi.controller;

import com.example.userapi.entity.User;
import com.example.userapi.exception.CustomException;
import com.example.userapi.exception.ExceptionMessage;
import com.example.userapi.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired private AuthenticationService authenticationService;
    @Autowired private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public String getToken(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if (authentication.isAuthenticated()){
            return authenticationService.generateToken(user.getUsername());
        }else {
            throw new CustomException(ExceptionMessage.Login_Faild);
        }

    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        authenticationService.validateToken(token);
        return "Token is Valid";
    }

}
