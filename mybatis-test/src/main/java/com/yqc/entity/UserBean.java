package com.yqc.entity;

import lombok.Data;

/**
 * Created by yangqc on 2017/10/30
 */
@Data
public class UserBean {

    public UserBean(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    private int id;

    private String name;

    private String address;

    private int age;
}
