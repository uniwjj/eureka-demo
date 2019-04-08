package com.beidou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Eureka Client启动类
 *
 * @author ginger
 * @create 2019-04-08 16:24
 */
@SpringBootApplication
public class EurekaClientApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaClientApplication.class, args);
  }
}
