package com.lys.dao;

import com.lys.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 第一次入门：HelloWorld
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {

}
