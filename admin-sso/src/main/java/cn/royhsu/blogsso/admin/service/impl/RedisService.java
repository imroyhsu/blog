package cn.royhsu.blogsso.admin.service.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class RedisService {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    void setObj(String key, Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    Object getObj(String key){
        return redisTemplate.opsForValue().get(key);
    }


}
