package com.citylife.function.api.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.citylife.function.api.demo.domain.dao") 
public class FunctionApplication {
  public static void main(String[] args) {
    SpringApplication.run(FunctionApplication.class, args);
  }

}
