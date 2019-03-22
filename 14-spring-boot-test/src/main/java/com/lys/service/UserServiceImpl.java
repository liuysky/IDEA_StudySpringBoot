package com.lys.service;

import com.lys.dao.UserDaoImpl;

import javax.annotation.Resource;

public class UserServiceImpl {
    @Resource
    private UserDaoImpl userDaoImpl;
    public void addUser(){
        this.userDaoImpl.saveUser();
    }
}
