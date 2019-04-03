package com.lys.dao;

import com.lys.pojo.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *PagingAndSortingRepository接口继承了CrudRepository接口
 */
public interface UsersPagingAndSortingRepository extends PagingAndSortingRepository<Users,Integer> {


}
