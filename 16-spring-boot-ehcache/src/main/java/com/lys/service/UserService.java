package com.lys.service;

import com.lys.pojo.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<Users> findUserAll();
    Users findById(Integer id);
    Page<Users> findUserByPage(Pageable pageable);
    void saveUser(Users users);
}
