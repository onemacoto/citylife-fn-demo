package com.citylife.function.api.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.action.GetProductListAction;
import com.citylife.function.api.demo.client.IProductClient;
import com.citylife.function.api.demo.client.entity.Product;
import com.citylife.function.api.demo.client.entity.GetProductListRequest;
import com.citylife.function.api.demo.service.ProductService;
import com.citylife.function.core.boot.template.AbstractTemplateController;

@RestController
public class ProductController extends AbstractTemplateController<ProductService> implements IProductClient {

  @Autowired
  private GetProductListAction getProductListAction;

  @Override
  public ResultEntity<List<Product>> getProductList(final GetProductListRequest request, final String token) {
    return doAction(getProductListAction, request, token);
  }

}
