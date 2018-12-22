package com.citylife.function.api.demo.client.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.citylife.function.api.demo.client")
@ConditionalOnExpression("#{!environment['spring.application.name'].equals('"+ StarterApiAutoConfig.SERVICE_NAME +"')}")
public class StarterApiAutoConfig {
 
  public static final String SERVICE_NAME = "fn-demo";


}
