package com.apicafe.api.controller;

import com.apicafe.api.models.Login;
import com.apicafe.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public Login save(@RequestBody Login user){
        return loginService.save(user);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> sesion(@RequestBody Login user){
        String message = loginService.sessionLogin(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(message);
    }
}
