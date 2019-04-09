package com.beidou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello控制器
 *
 * @author wangjinjie
 * @create 2019-04-09 11:13
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @Value("${message}")
    private String message;

    @GetMapping("/info")
    public String info() {
        return message;
    }
}
