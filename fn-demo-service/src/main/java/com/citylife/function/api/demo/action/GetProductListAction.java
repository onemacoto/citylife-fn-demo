package com.citylife.function.api.demo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.client.entity.Product;
import com.citylife.function.api.demo.client.entity.GetProductListRequest;
import com.citylife.function.api.demo.domain.dao.TblDemoA01Mapper;
import com.citylife.function.api.demo.domain.model.TblDemoA01;
import com.citylife.function.core.annotations.ActionTransactional;
import com.citylife.function.core.boot.template.context.IActionContext;

@ActionTransactional
@Component
public class GetProductListAction extends AbstractFunctionAction<GetProductListRequest, List<Product>> {

	@Autowired
	private TblDemoA01Mapper tblDemoA01Mapper;

	@Override
	public ResultEntity<List<Product>> execute(IActionContext<GetProductListRequest> context) {

		List<TblDemoA01> result = tblDemoA01Mapper.selectAll();
		if (CollectionUtils.isEmpty(result)) {
			return ResultEntity.ok(new ArrayList<>());
		}
		return ResultEntity
				.ok(result.stream().map(p -> getBeanMapper().map(p, Product.class)).collect(Collectors.toList()));
	}

}
