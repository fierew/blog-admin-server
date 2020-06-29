package com.blog.admin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * redis 工具
 * 
 * @author xuyang
 */
@Component
public class RedisUtils {
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Serializable> redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    @SuppressWarnings("all")
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Serializable value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    public boolean set(String key, Serializable value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            this.set(key, value);
        }
        return true;
    }

    public boolean set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    public boolean set(String key, String value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            this.set(key, value);
        }
        return true;
    }

    @SuppressWarnings("all")
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @SuppressWarnings("all")
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }


}
