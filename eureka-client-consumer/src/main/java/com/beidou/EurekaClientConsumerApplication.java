package com.beidou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Eureka Client Consumer启动类
 *
 * @author wangjinjie
 * @create 2019-04-08 21:59
 */
@EnableFeignClients
@SpringBootApplication
public class EurekaClientConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaClientConsumerApplication.class, args);
  }
}
