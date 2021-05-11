package com.app.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.common.utils.QueryUtils;
import com.app.domain.SaleBill;
import com.app.repository.BaseDao;
import com.app.repository.SaleDao;
import com.app.repository.sql.SaleBillQueries;

@Repository
public class SaleDaoImpl extends BaseDao implements SaleDao {
	
	public Long submitSaleData(SaleBill saleBill) {
		
		SqlParameterSource paramSource = new MapSqlParameterSource()
		.addValue("custName", saleBill.getCustName())
		.addValue("custAddress", saleBill.getCustAddress())
		.addValue("s_rt", saleBill.getS_rt())
		.addValue("g_rt", saleBill.getG_rt())
		.addValue("s_wt", saleBill.getS_wt())
		.addValue("g_wt", saleBill.getG_wt())
		.addValue("gHsn", saleBill.getgHsn())
		.addValue("sHsn", saleBill.getsHsn())
		.addValue("sgst", saleBill.getSgst())
		.addValue("cgst", saleBill.getCgst())
		.addValue("igst", saleBill.getIgst())
		.addValue("transport_mode", saleBill.getTransportMode())
		.addValue("vehicleNo", saleBill.getVehicleNo())
		.addValue("billDate", saleBill.getDate())
		.addValue("phoneNo", saleBill.getPhoneNo())
		.addValue("aadhar", saleBill.getAadhar())
		.addValue("state", saleBill.getState())
		.addValue("stateCode", saleBill.getStateCode())
		.addValue("sAmount", saleBill.getsAmount())
		.addValue("gAmount", saleBill.getgAmount())
		.addValue("subTotal", saleBill.getSubTotal())
		.addValue("sgstRate", saleBill.getSgstRate())
		.addValue("cgstRate", saleBill.getCgstRate())
		.addValue("igstRate", saleBill.getIgstRate())
		.addValue("totalGst", saleBill.getTotalGst())
		.addValue("grandTotal", saleBill.getGrandTotal())
		.addValue("roundOff", saleBill.getRoundOff())
		.addValue("grandTotalWords", saleBill.getGrandTotalWords());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		getNamedParameterJdbcTemplate().update(SaleBillQueries.submitSaleData, paramSource, keyHolder);
		return keyHolder.getKey().longValue();
	}

	
	public SaleBill getSaleData(int invoiceNo) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
        		.addValue("invoiceNo", invoiceNo);
		
		return getNamedParameterJdbcTemplate().queryForObject(SaleBillQueries.getSaleData, paramSource, new SaleDataRowMapper());
		
		
	}


	public void updateStock(SaleBill saleBill) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
        		.addValue("s_wt", saleBill.getS_wt())
        		.addValue("g_wt", saleBill.getG_wt());
		getNamedParameterJdbcTemplate().update(SaleBillQueries.subtGoldStock, paramSource);
		getNamedParameterJdbcTemplate().update(SaleBillQueries.subtSilverStock, paramSource);
		
		
	}
	
	
	
/////RowMappers//////
	
	private static class SaleDataRowMapper implements RowMapper<SaleBill> {
		public SaleBill mapRow(ResultSet rs, int rowNum) throws SQLException {
			SaleBill saleBill = new SaleBill();
			saleBill.setCustName(rs.getString("cust_name"));
			saleBill.setCustAddress(rs.getString("cust_address"));
			saleBill.setS_rt(rs.getDouble("s_rt"));
			saleBill.setG_rt(rs.getDouble("g_rt"));
			saleBill.setS_wt(rs.getDouble("s_wt"));
			saleBill.setG_wt(rs.getDouble("g_wt"));
			saleBill.setSgst(rs.getDouble("sgst"));
			saleBill.setCgst(rs.getDouble("cgst"));
			saleBill.setIgst(rs.getDouble("igst"));
			saleBill.setTransportMode(rs.getString("transport_mode"));
			saleBill.setVehicleNo(rs.getString("vehicle_no"));
			saleBill.setPhoneNo(rs.getString("phone"));
			saleBill.setAadhar(rs.getString("aadhar"));
			saleBill.setState(rs.getString("state"));
			saleBill.setStateCode(rs.getString("state_code"));
			saleBill.setsAmount(rs.getDouble("s_amount"));
			saleBill.setgAmount(rs.getDouble("g_amount"));
			saleBill.setgHsn(rs.getString("g_hsn"));
			saleBill.setsHsn(rs.getString("s_hsn"));
			saleBill.setSubTotal(rs.getDouble("sub_total"));
			saleBill.setDate(QueryUtils.formatDate(rs.getString("bill_date")));
			saleBill.setSgstRate(rs.getDouble("sgst_rate"));
			saleBill.setCgstRate(rs.getDouble("cgst_rate"));
			saleBill.setIgstRate(rs.getDouble("igst_rate"));
			saleBill.setTotalGst(rs.getDouble("total_gst"));
			saleBill.setGrandTotal(rs.getDouble("grand_total"));
			saleBill.setRoundOff(rs.getDouble("round_off"));
			saleBill.setGrandTotalWords(rs.getString("grand_total_in_words"));
			
			return saleBill;
		}
	}
	
	
	

}
