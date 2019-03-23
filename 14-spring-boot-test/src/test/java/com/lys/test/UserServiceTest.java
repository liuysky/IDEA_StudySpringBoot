package com.lys.test;

import com.lys.TestStart;
import com.lys.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestStart.class})
public class UserServiceTest {
    @Resource
    private UserServiceImpl userServiceImpl;

    @Test
    public void testAddUser(){
        this.userServiceImpl.addUser();
    }
}
