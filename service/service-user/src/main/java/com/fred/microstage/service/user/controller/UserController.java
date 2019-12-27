package com.fred.microstage.service.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/user/profile")
    public String getProfile(@RequestParam("name") String name) {
        return String.format("user name : %s, welcome to micro-stage made by fred, port : %s", name, port);
    }
}
