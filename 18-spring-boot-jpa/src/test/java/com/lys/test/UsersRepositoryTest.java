package com.lys.test;

import com.lys.JpaStart;
import com.lys.dao.UsersCrudRepository;
import com.lys.dao.UsersRepository;
import com.lys.dao.UsersRepositoryByName;
import com.lys.dao.UsersRepositoryQueryAnnotation;
import com.lys.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaStart.class)
public class UsersRepositoryTest {
    @Resource
    private UsersRepository usersRepository;

    @Resource
    private UsersRepositoryByName usersRepositoryByName;

    @Resource
    private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

    @Test
    public void testSave(){
        Users users=new Users();
        users.setAddress("武平县平川镇");
        users.setName("张三");
        users.setAge(30);
        this.usersRepository.save(users);
    }

    /**
     * Repository--方法名称命名测试
     */
    @Test
    public void testFindByName(){
        List<Users> list=usersRepositoryByName.findByNameEquals("张三");
        for (Users users: list){
            System.out.println(users);
        }
    }

    @Test
    public void testFindByNameAndAge(){
        List<Users> list=usersRepositoryByName.findByNameAndAge("张三",30);
        for (Users users: list){
            System.out.println(users);
        }
    }

    @Test
    public void testFindByNameLike(){
        List<Users> list=usersRepositoryByName.findByNameLike("%张%");
        for (Users users: list){
            System.out.println(users);
        }
    }

    /**
     * Repository--@Query测试
     */
    @Test
    public void testQueryByNameUseHQL(){
        List<Users> list = usersRepositoryQueryAnnotation.queryByNameUseHQL("王五");
        for (Users users: list){
            System.out.println(users);
        }
    }

    @Test
    public void testQueryByNameUseSQL(){
        List<Users> list = usersRepositoryQueryAnnotation.queryByNameUseSQL("王五");
        for (Users users: list){
            System.out.println(users);
        }
    }

    @Test
    @Transactional//当@Transactional与@Test注解一起使用时事务是自动回滚的
    @Rollback(false)//取消自动回滚
    public void testUpdateUsersNameById(){
        this.usersRepositoryQueryAnnotation.updateUsersNameById("赵六",2);

    }
}
