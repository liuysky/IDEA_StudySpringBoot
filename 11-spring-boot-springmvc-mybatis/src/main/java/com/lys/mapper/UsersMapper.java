package com.lys.mapper;

import com.lys.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    void insertUser(Users users);
    List<Users> selectUserAll();
    Users selectUserById(Integer id);
    void updateUser(Users users);
    void deleteUserById(Integer id);
}
