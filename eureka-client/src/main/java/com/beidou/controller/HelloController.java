package com.beidou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello控制器
 *
 * @author ginger
 * @create 2019-04-08 17:06
 */
@RestController
public class HelloController {

  @Value("${message:local message}")
  private String message;

  @GetMapping("/hello/info")
  public String hello() {
    return message;
  }
}
