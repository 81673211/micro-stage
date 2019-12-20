package com.fred.microstage.frontend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/profile")
    public String getProfile(@RequestParam("name") String name) {
        return String.format("user name : %s, welcome to micro-stage made by fred", name);
    }
}
