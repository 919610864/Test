package com.basic.tms;

import mockit.Injectable;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.StringRedisTemplate;

@RunWith(JMockit.class)
public class RedisTest {

    @Mocked
    @Injectable
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void testAdd(){
        //Long add = stringRedisTemplate.opsForSet().add();
        //System.out.println(add);
    }
}
