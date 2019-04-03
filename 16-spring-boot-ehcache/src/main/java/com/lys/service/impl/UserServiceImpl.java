package com.lys.service.impl;

import com.lys.dao.UsersRepository;
import com.lys.pojo.Users;
import com.lys.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UsersRepository usersRepository;

    @Override
    @Cacheable(value = "cache")
    public List<Users> findUserAll() {
        return this.usersRepository.findAll();
    }

    @Override
    //@Cacheable：对当前查询的对象做缓存处理
    @Cacheable(value = "cache")
    public Users findById(Integer id) {
        return this.usersRepository.findOne(id);
    }

    @Override
    @Cacheable(value = "cache" ,key = "#pageable.pageSize")
    public Page<Users> findUserByPage(Pageable pageable) {
        return this.usersRepository.findAll(pageable);
    }

    @Override
    //CacheEvict(value = "cache",allEntries = true)清除缓存中以cache为策略的缓存
    @CacheEvict(value = "cache",allEntries = true)
    public void saveUser(Users users) {
        this.usersRepository.save(users);
    }
}
