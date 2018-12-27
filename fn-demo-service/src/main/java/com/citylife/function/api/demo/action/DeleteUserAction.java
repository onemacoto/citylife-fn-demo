package com.citylife.function.api.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.domain.dao.TblUserMapper;
import com.citylife.function.core.annotations.ActionTransactional;
import com.citylife.function.core.boot.template.context.IActionContext;

@ActionTransactional
@Component
public class DeleteUserAction  extends AbstractFunctionAction<Long, Integer> {
  @Autowired
  private TblUserMapper tblUserMapper;

  @Override
  public ResultEntity<Integer> execute(IActionContext<Long> context) {
    int result = tblUserMapper.deleteByPrimaryKey(context.getParameter());
    return ResultEntity.ok(result);
  }
}