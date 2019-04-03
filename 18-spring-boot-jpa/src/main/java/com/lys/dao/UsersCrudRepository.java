package com.lys.dao;

import com.lys.pojo.Users;
import org.springframework.data.repository.CrudRepository;

/**
 *CrudRepository继承了Repository接口
 */
public interface UsersCrudRepository extends CrudRepository<Users, Integer> {

}
