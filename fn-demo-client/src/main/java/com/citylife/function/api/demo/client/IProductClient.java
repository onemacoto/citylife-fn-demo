package com.citylife.function.api.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.client.config.StarterApiAutoConfig;
import com.citylife.function.api.demo.client.entity.GetProductListRequest;
import com.citylife.function.api.demo.client.entity.Product;
import com.citylife.function.api.demo.client.fallback.ProductClientFallbackFactory;
import com.citylife.function.core.api.feign.IApiClient;

@FeignClient(name = StarterApiAutoConfig.SERVICE_NAME, fallbackFactory = ProductClientFallbackFactory.class)
public interface IProductClient extends IApiClient {
  @PostMapping("/{"+VERSION_KEY+"}/product/findAll")
  ResultEntity<List<Product>> findAll(@RequestBody GetProductListRequest request, @PathVariable(VERSION_KEY) String version, @RequestHeader(name = HEADER_TOKEN_KEY, required = false) String token);
}
