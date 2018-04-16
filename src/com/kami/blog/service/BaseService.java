package com.kami.blog.service;

import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;

public interface BaseService<T> {
	public DatatablesView<T> getData(QueryCondition queryCondition);
}
