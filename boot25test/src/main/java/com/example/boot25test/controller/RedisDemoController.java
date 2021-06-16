package com.example.boot25test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("redis")
public class RedisDemoController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @GetMapping("/add")
    public String redis() {
        redisTemplate.opsForValue().set("k1", "v1");
        return "ok";
    }
}
