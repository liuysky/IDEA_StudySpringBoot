package com.lys.dao;


import com.lys.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaSpecificationExecutor ：单独存在的接口.完全独立
 */
public interface UsersJpaSpecificationExecutor extends JpaRepository<Users,Integer>,JpaSpecificationExecutor<Users> {


}
