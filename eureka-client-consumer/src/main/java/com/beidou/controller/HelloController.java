package com.beidou.controller;

import com.beidou.fegin.HelloFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello控制器
 *
 * @author wangjinjie
 * @create 2019-04-08 21:18
 */
@RequestMapping("/hello")
@RestController
public class HelloController {
    private Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloFeign helloFeign;

    @GetMapping("/info")
    public String hello(@RequestParam String name) {
        log.info("HelloFeign instance is {}", helloFeign.getClass().getName());
        return helloFeign.hello(name);
    }
}
