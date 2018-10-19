package com.dylan.auth.moudle.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class s {

    @RequestMapping("/token")
    public String result() {
        return "token";
    }
}
