package com.app.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.domain.SaleBill;
import com.app.repository.BaseDao;
import com.app.repository.SaleDao;
import com.app.repository.parametermapper.SaleDataParameterMapper;
import com.app.repository.rowmapper.SaleDataRowMapper;
import com.app.repository.sql.Queries;

@Repository
public class SaleDaoImpl extends BaseDao implements SaleDao {

	@Autowired
	SaleDataParameterMapper saleDataParameterMapper;
	
	
	public void submitSaleData(SaleBill saleBill) {
		
		Map params = saleDataParameterMapper.submitSaleData(saleBill);
		getNamedParameterJdbcTemplate().update(Queries.submitSaleData,params);
	}

	
	public SaleBill getSaleData(int invoiceNo) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
        		.addValue("invoiceNo", invoiceNo);
		
		return getNamedParameterJdbcTemplate().queryForObject(Queries.getSaleData, paramSource, new SaleDataRowMapper());
		
	}


	public void updateStock(SaleBill saleBill) {
		
		Map params = saleDataParameterMapper.updateStock(saleBill);
		getNamedParameterJdbcTemplate().update(Queries.subtGoldStock, params);
		getNamedParameterJdbcTemplate().update(Queries.subtSilverStock, params);
		
		
	}
	
	

}
