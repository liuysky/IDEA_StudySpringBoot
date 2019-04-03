package com.lys.test;

import com.lys.EhcacheStart;
import com.lys.pojo.Users;
import com.lys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EhcacheStart.class)
public class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    public void testFindById(){


        System.out.println(this.userService.findById(1));

        System.out.println(this.userService.findById(1));
    }
    @Test
    public void testFindUserByPage(){

        Pageable pageable=new PageRequest(0,4);

        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());

        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());

        pageable=new PageRequest(1,4);
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());
    }

    @Test
    public void testFindAll(){
        System.out.println(this.userService.findUserAll().size());
        Users users=new Users();
        users.setAge(18);
        users.setName("林春");
        users.setAddress("林春");
        userService.saveUser(users);
        System.out.println(this.userService.findUserAll().size());
    }
}
