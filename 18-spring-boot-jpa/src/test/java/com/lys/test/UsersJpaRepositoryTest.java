package com.lys.test;

import com.lys.JpaStart;
import com.lys.dao.UsersJpaRepository;
import com.lys.dao.UsersJpaSpecificationExecutor;
import com.lys.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaStart.class)
public class UsersJpaRepositoryTest {

    @Resource
    private UsersJpaRepository usersJpaRepository;

    @Resource
    private UsersJpaSpecificationExecutor usersJpaSpecificationExecutor;

    /**
     * UsersJpaRepository--排序测试
     */
    @Test
    public void testJpaRepositorySort() {
        //Order 定义排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        //Sort对象封装了排序规则
        Sort sort = new Sort(order);
        List<Users> list = this.usersJpaRepository.findAll(sort);
        for (Users user : list) {
            System.out.println(user);
        }
    }

    /**
     * JpaSpecificationExecutor---单条件测试
     */

    @Test
    public void testJpaSpecificationExecutor1() {

        /**
         * Specification<Users> :用于封装查询条件的
         */
        Specification<Users> spec = new Specification<Users>() {

            //Predicate:封装了单个的查询条件

            /**
             *
             * Root<Users> root:查询对象的属性的封装
             * CriteriaQuery<?> criteriaQuery: 封装了我们要执行的各个部分的信息,select from
             * CriteriaBuilder criteriaBuilder：查询条件的构造器,定义不同查询条件
             *
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                //where name='石福平'
                /**
                 * 参数一：当前要查询的属性
                 * 参数二：查询条件的值
                 */
                Predicate pre = cb.equal(root.get("name"),"石福平");

                return pre;
            }
        };

        List<Users> list = this.usersJpaSpecificationExecutor.findAll(spec);
        for (Users user : list) {
            System.out.println(user);
        }
    }


    /**
     * JpaSpecificationExecutor---多条件测试
     */

    @Test
    public void testJpaSpecificationExecutor2() {

        /**
         * Specification<Users> :用于封装查询条件的
         */
        Specification<Users> spec = new Specification<Users>() {

            //Predicate:封装了单个的查询条件

            /**
             *
             * Root<Users> root:查询对象的属性的封装
             * CriteriaQuery<?> criteriaQuery: 封装了我们要执行的各个部分的信息,select from
             * CriteriaBuilder criteriaBuilder：查询条件的构造器,定义不同查询条件
             *
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                //where name ="张三" and age =30
                List<Predicate> list=new ArrayList<>();
                list.add(cb.equal(root.get("name"),"张三"));
                list.add(cb.equal(root.get("age"),30));
                Predicate[]arr=new Predicate[list.size()];
                return cb.and(list.toArray(arr));
            }
        };

        List<Users> list = this.usersJpaSpecificationExecutor.findAll(spec);
        for (Users user : list) {
            System.out.println(user);
        }
    }

    /**
     * JpaSpecificationExecutor---多条件测试第二种写法
     */

    @Test
    public void testJpaSpecificationExecutor3() {

        /**
         * Specification<Users> :用于封装查询条件的
         */
        Specification<Users> spec = new Specification<Users>() {

            //Predicate:封装了单个的查询条件

            /**
             *
             * Root<Users> root:查询对象的属性的封装
             * CriteriaQuery<?> criteriaQuery: 封装了我们要执行的各个部分的信息,select from
             * CriteriaBuilder criteriaBuilder：查询条件的构造器,定义不同查询条件
             *
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                //where name ="张三" and age =30

                //(name="张三" and age=30) or name="刘文峰"
                return cb.or(cb.and(cb.equal(root.get("name"),"张三"),cb.equal(root.get("age"),30)),cb.equal(root.get("name"),"刘文峰"));
            }
        };

        Sort sort=new Sort(new Sort.Order(Sort.Direction.DESC,"id"));

        List<Users> list = this.usersJpaSpecificationExecutor.findAll(spec,sort);
        for (Users user : list) {
            System.out.println(user);
        }
    }
}
