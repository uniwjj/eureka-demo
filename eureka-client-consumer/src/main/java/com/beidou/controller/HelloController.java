package com.beidou.controller;

import com.beidou.fegin.HelloFeign;
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

    @Autowired
    private HelloFeign helloFeign;

    @GetMapping("/info")
    public String hello(@RequestParam String name) {
        return helloFeign.hello(name) + " Invoked by feign.";
    }
}
