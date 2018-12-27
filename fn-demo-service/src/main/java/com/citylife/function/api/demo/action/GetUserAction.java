package com.citylife.function.api.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.client.entity.User;
import com.citylife.function.api.demo.domain.dao.TblUserMapper;
import com.citylife.function.api.demo.domain.model.TblUser;
import com.citylife.function.core.annotations.ActionTransactional;
import com.citylife.function.core.boot.template.context.IActionContext;

@ActionTransactional
@Component
public class GetUserAction extends AbstractFunctionAction<Long, User> {

  @Autowired
  private TblUserMapper tblUserMapper;

  @Override
  public ResultEntity<User> execute(IActionContext<Long> context) {
    TblUser result = tblUserMapper.selectByPrimaryKey(context.getParameter());
    return ResultEntity.ok(getBeanMapper().map(result, User.class));
  }

}
