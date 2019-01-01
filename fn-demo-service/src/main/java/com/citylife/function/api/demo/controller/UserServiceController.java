package com.citylife.function.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.citylife.common.model.RequestVO;
import com.citylife.common.model.ResponseVO;
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
	public ResultEntity<ResponseVO<User>> getUser(RequestVO<Long> query, String version, String token) {
		return doAction(getUserAction, query, version, token);
	}

	@Override
	public ResultEntity<ResponseVO<Long>> createUser(RequestVO<User> user, String version, String token) {
		return doAction(createUserAction, user, version, token);
	}

	@Override
	public ResultEntity<ResponseVO<Integer>> updateUser(RequestVO<User> user, String version, String token) {
		return doAction(updateUserAction, user, version, token);
	}

	@Override
	public ResultEntity<ResponseVO<Integer>> deleteUser(RequestVO<Long> query, String version, String token) {
		return doAction(deleteUserAction, query, version, token);
	}
}
