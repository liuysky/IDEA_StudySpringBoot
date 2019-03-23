package com.lys.service;

import com.lys.dao.UserDaoImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl {
    @Resource
    private UserDaoImpl userDaoImpl;
    public void addUser(){
        this.userDaoImpl.saveUser();
    }
}
