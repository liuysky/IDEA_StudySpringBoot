package com.lys.test;


import com.lys.JpaStart;
import com.lys.dao.UsersPagingAndSortingRepository;
import com.lys.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaStart.class)
public class UsersPagingAndSortingRepositoryTest {
    @Resource
    private UsersPagingAndSortingRepository usersPagingAndSortingRepository;

    /**
     * PagingAndSortingRepository--排序测试     */
    @Test
    public void testPagingAndSortingRepositorySort(){
        //Order 定义排序规则
        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
        //Sort对象封装了排序规则
        Sort sort=new Sort(order);
        List<Users> list= (List<Users>) this.usersPagingAndSortingRepository.findAll(sort);
        for (Users user:list){
            System.out.println(user);
        }
    }

    /**
     * PagingAndSortingRepository--分页测试
     */

    @Test
    public void testPagingAndSortingRepositoryPage(){
        //Pageable:封装了分页的参数：当前页，每页显示的条数。注意：他的当前页是从0开始的
        //PageRequest(page,size):page:当前页，size：每页显示的条数
        Pageable pageable=new PageRequest(1,2);
        Page<Users> page = this.usersPagingAndSortingRepository.findAll(pageable);
        System.out.println("总条数"+page.getTotalElements());
        System.out.println("总页数"+page.getTotalPages());
        List<Users> list=page.getContent();
        for (Users user:list){
            System.out.println(user);
        }

    }

    /**
     * 排序加分页
     */
    @Test
    public void testPagingAndSortingRepositorySortAndPage(){
        Sort sort=new Sort(new Sort.Order(Sort.Direction.DESC,"id"));

        Pageable pageable=new PageRequest(2,2,sort);

        Page<Users> page = this.usersPagingAndSortingRepository.findAll(pageable);

        System.out.println("总条数"+page.getTotalElements());
        System.out.println("总页数"+page.getTotalPages());
        List<Users> list=page.getContent();
        for (Users user:list){
            System.out.println(user);
        }
    }
}
