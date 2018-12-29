package com.citylife.function.api.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.citylife.common.model.RequestVO;
import com.citylife.common.model.ResponseVO;
import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.client.config.StarterApiAutoConfig;
import com.citylife.function.api.demo.client.entity.User;
import com.citylife.function.api.demo.client.fallback.UserClientFallbackFactory;
import com.citylife.function.core.api.feign.IApiClient;

@FeignClient(name = StarterApiAutoConfig.SERVICE_NAME, fallbackFactory = UserClientFallbackFactory.class)
public interface IUserClient extends IApiClient {

	@PostMapping("/{" + VERSION_KEY + "}/user/get")
	ResultEntity<ResponseVO<User>> getUser(@RequestBody RequestVO<Long> query,
			@PathVariable(VERSION_KEY) String version, @RequestHeader(name = HEADER_TOKEN_KEY) String token);

	@PostMapping("/{" + VERSION_KEY + "}/user/create")
	ResultEntity<ResponseVO<Long>> createUser(@RequestBody RequestVO<User> user,
			@PathVariable(VERSION_KEY) String version, @RequestHeader(name = HEADER_TOKEN_KEY) String token);

	@PostMapping("/{" + VERSION_KEY + "}/user/update")
	ResultEntity<ResponseVO<Integer>> updateUser(@RequestBody RequestVO<User> user,
			@PathVariable(VERSION_KEY) String version, @RequestHeader(name = HEADER_TOKEN_KEY) String token);

	@PostMapping("/{" + VERSION_KEY + "}/user/delete")
	ResultEntity<ResponseVO<Integer>> deleteUser(@RequestBody RequestVO<Long> query,
			@PathVariable(VERSION_KEY) String version, @RequestHeader(name = HEADER_TOKEN_KEY) String token);
}
