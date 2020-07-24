package com.app.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class BaseDao extends NamedParameterJdbcDaoSupport {
	
	@Autowired
	public void bindDataSource(DataSource dataSource)
	{
		super.setDataSource(dataSource);
	}

}
