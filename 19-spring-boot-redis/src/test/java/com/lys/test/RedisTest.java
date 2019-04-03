package com.lys.test;

import com.lys.RedisStart;
import com.lys.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisStart.class)
public class RedisTest {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 添加一个字符串
     */
    @Test
    public void testSet(){
        this.redisTemplate.opsForValue().set("林春","你好漂亮");
    }

    /**
     * 取出一个字符串
     */
    @Test public void testGet(){
        Object value = this.redisTemplate.opsForValue().get("林春");
        System.out.println(value);
    }


    /**
     * 添加一个Users对象(基于Json格式)
     */
    @Test
    public void testSetUsers(){
        Users users=new Users();
        users.setName("张三丰");
        users.setId(1);
        users.setAge(60);

        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        this.redisTemplate.opsForValue().set("users",users);
    }

    @Test
    public void testGetUsers(){
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        Object users = this.redisTemplate.opsForValue().get("users");
        System.out.println(users);
    }

}
