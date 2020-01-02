package com.fred.microstage.service.user.controller;

import com.fred.microstage.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserService userService;

    @RequestMapping("/profile")
    public String getProfile(@RequestParam("userId") Long userId) {
        userService.get(userId);
        return String.format("welcome to micro-stage made by fred, port : %s", port);
    }
}
