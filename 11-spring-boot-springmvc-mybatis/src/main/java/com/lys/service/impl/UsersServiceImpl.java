package com.lys.service.impl;

import com.lys.mapper.UsersMapper;
import com.lys.pojo.Users;
import com.lys.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insertUser(users);
    }

    @Override
    public List<Users> findUserAll() {
        return this.usersMapper.selectUserAll();
    }

    @Override
    public Users findUserById(Integer id) {
        return this.usersMapper.selectUserById(id);
    }

    @Override
    public void updateUser(Users user) {
        this.usersMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.usersMapper.deleteUserById(id);
    }


}
