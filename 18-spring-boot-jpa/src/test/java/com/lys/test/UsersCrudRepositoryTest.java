package com.lys.test;


import com.lys.JpaStart;
import com.lys.dao.UsersCrudRepository;
import com.lys.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaStart.class)
public class UsersCrudRepositoryTest {
    @Resource
    private  UsersCrudRepository usersCrudRepository;

    /**
     *CrudRepository--测试
     */
    @Test
    public void testCrudRepositorySave(){
        Users users=new Users();
        users.setName("刘岩松");
        users.setAge(18);
        users.setAddress("武平");
        this.usersCrudRepository.save(users);
    }

    @Test
    public void testCrudRepositoryUpdate(){
        Users users=new Users();
        users.setId(4);
        users.setName("刘岩松");
        users.setAge(20);
        users.setAddress("福建省");
        this.usersCrudRepository.save(users);
    }

    @Test
    public void testCrudRepositoryFindOne(){
        Users users = this.usersCrudRepository.findOne(4);
        System.out.println(users);
    }
    @Test
    public void testCrudRepositoryFindAll(){
        List<Users> list= (List<Users>) this.usersCrudRepository.findAll();
        for(Users user:list){
            System.out.println(user);
        }
    }

    @Test
    public void testCrudRepositoryDeleteById(){
        this.usersCrudRepository.delete(4);
    }
}
