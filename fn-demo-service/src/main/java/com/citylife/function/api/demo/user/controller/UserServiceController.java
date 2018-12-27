package com.citylife.function.api.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.action.CreateUserAction;
import com.citylife.function.api.demo.action.DeleteUserAction;
import com.citylife.function.api.demo.action.GetUserAction;
import com.citylife.function.api.demo.action.UpdateUserAction;
import com.citylife.function.api.demo.client.IUserClient;
import com.citylife.function.api.demo.client.entity.User;
import com.citylife.function.core.boot.template.AbstractTemplateController;
import com.citylife.function.core.boot.template.TemplateService;

@RestController
public class UserServiceController extends AbstractTemplateController<TemplateService> implements IUserClient {

  @Autowired
  private GetUserAction getUserAction;

  @Autowired
  private CreateUserAction createUserAction;

  @Autowired
  private UpdateUserAction updateUserAction;
  
  @Autowired
  private DeleteUserAction deleteUserAction;

  @Override
  public ResultEntity<User> getUser(Long userId, String version, String token) {
    return doAction(version, getUserAction, userId, token);
  }

  @Override
  public ResultEntity<Long> createUser(User user, String version, String token) {
    return doAction(version, createUserAction, user, token);
  }

  @Override
  public ResultEntity<Integer> updateUser(User user, String version, String token) {
    return doAction(version, updateUserAction, user, token);
  }

  @Override
  public ResultEntity<Integer> deleteUser(Long userId, String version, String token) {
    return doAction(version, deleteUserAction, userId, token);
  }

}
