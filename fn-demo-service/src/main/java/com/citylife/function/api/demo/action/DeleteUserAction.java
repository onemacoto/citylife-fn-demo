package com.citylife.function.api.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citylife.common.model.RequestVO;
import com.citylife.common.model.ResponseVO;
import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.domain.dao.TblUserMapper;
import com.citylife.function.core.annotations.ActionTransactional;
import com.citylife.function.core.boot.template.context.IActionContext;

@ActionTransactional
@Component
public class DeleteUserAction  extends AbstractFunctionAction<RequestVO<Long>, ResponseVO<Integer>> {
  @Autowired
  private TblUserMapper tblUserMapper;

  @Override
  public ResultEntity<ResponseVO<Integer>> execute(IActionContext<RequestVO<Long>> context) {
    int result = tblUserMapper.deleteByPrimaryKey(context.getParameter().getData());
    return ResultEntity.ok(new ResponseVO<>(result));
  }
}