package com.citylife.function.api.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citylife.common.model.RequestVO;
import com.citylife.common.model.ResponseVO;
import com.citylife.common.model.ResultEntity;
import com.citylife.common.model.builder.ResponseVOBuilder;
import com.citylife.common.utils.IDGeneratorUtils;
import com.citylife.function.api.demo.client.entity.User;
import com.citylife.function.api.demo.domain.dao.TblUserMapper;
import com.citylife.function.api.demo.domain.model.TblUser;
import com.citylife.function.core.annotations.ActionTransactional;
import com.citylife.function.core.boot.template.context.IActionContext;

@ActionTransactional
@Component
public class CreateUserAction extends AbstractFunctionAction<RequestVO<User>, ResponseVO<Long>> {

  @Autowired
  private TblUserMapper tblUserMapper;

  @Override
  public ResultEntity<ResponseVO<Long>> execute(IActionContext<RequestVO<User>> context) {
    TblUser user = getBeanMapper().map(context.getParameter(), TblUser.class);
    long userId = IDGeneratorUtils.getId();
    user.setUserid(userId);
    tblUserMapper.insert(user);
    return ResultEntity.ok(ResponseVOBuilder.build(userId));
  }
}
