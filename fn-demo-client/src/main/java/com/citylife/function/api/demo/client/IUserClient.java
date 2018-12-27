package com.citylife.function.api.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.client.config.StarterApiAutoConfig;
import com.citylife.function.api.demo.client.entity.User;
import com.citylife.function.api.demo.client.fallback.UserClientFallbackFactory;
import com.citylife.function.core.api.feign.IApiClient;

@FeignClient(name = StarterApiAutoConfig.SERVICE_NAME, fallbackFactory = UserClientFallbackFactory.class)
public interface IUserClient extends IApiClient {

  @GetMapping("/{" + VERSION_KEY + "}/user/get")
  ResultEntity<User> getUser(@RequestParam("userId") Long userId,
      @PathVariable(VERSION_KEY) String version, @RequestHeader(name = HEADER_TOKEN_KEY) String token);

  @PostMapping("/{" + VERSION_KEY + "}/user/create")
  ResultEntity<Long> createUser(@RequestBody User user, @PathVariable(VERSION_KEY) String version,
      @RequestHeader(name = HEADER_TOKEN_KEY) String token);

  @PostMapping("/{" + VERSION_KEY + "}/user/update")
  ResultEntity<Integer> updateUser(@RequestBody User user, @PathVariable(VERSION_KEY) String version,
      @RequestHeader(name = HEADER_TOKEN_KEY) String token);

  @PostMapping("/{" + VERSION_KEY + "}/user/delete")
  ResultEntity<Integer> deleteUser(@RequestParam("userId") Long userId,
      @PathVariable(VERSION_KEY) String version, @RequestHeader(name = HEADER_TOKEN_KEY) String token);
}
