package com.lys.dao;

import com.lys.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 开发中最常用
 * 继承了PagingAndSortingRepository接口。对继承的父接口中的方法的返回值进行适配。
 */
public interface UsersJpaRepository extends JpaRepository<Users ,Integer> {

}
