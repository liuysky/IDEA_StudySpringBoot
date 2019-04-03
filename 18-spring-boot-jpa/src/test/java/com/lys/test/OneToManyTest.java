package com.lys.test;

import com.lys.JpaStart;
import com.lys.dao.UsersRepository;
import com.lys.pojo.Roles;
import com.lys.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 一对多关联关系测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaStart.class)
public class OneToManyTest {
    @Resource
    private UsersRepository usersRepository;
    /**
     * 一多关联关系的添加
     */
    @Test
    public void testSave(){

        //创建一个用户
        Users users =new Users();
        users.setName("林德政");
        users.setAddress("山水人家");
        users.setAge(25);


        //创建一个角色
        Roles roles=new Roles();
        roles.setRolename("管理员");

        //关联
        roles.getUsers().add(users);
        users.setRoles(roles);

        //保存
        this.usersRepository.save(users);
    }

    /**
     * 一多关联关系的查询
     */
    @Test
    public void testFind(){
        Users users = this.usersRepository.findOne(8);
        System.out.println(users);
        Roles roles=users.getRoles();
        System.out.println(roles.getRolename());
    }
}
