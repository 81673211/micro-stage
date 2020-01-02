package com.fred.microstage.service.user.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;

    private String name;

    private Integer age;

    private Date createdTime;

    private boolean deleted;
}
