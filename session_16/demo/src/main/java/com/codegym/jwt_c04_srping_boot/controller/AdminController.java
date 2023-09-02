package com.codegym.jwt_c04_srping_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AccountController {
    @GetMapping
    public String admin(){
        return "Admin";
    }

}
