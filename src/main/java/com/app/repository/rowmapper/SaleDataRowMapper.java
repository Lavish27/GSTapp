package com.app.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.app.domain.SaleBill;

public class SaleDataRowMapper implements RowMapper<SaleBill> {

	@SuppressWarnings("deprecation")
	public SaleBill mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SaleBill saleBill = new SaleBill();
		
		saleBill.setInvoiceNo(rs.getInt("invoice_no"));
		saleBill.setCustName(rs.getString("cust_name"));
		saleBill.setCustAddress(rs.getString("cust_address"));
		saleBill.setS_rt(rs.getDouble("s_rt"));
		saleBill.setG_rt(rs.getDouble("g_rt"));
		saleBill.setS_wt(rs.getDouble("s_wt"));
		saleBill.setG_wt(rs.getDouble("g_wt"));
		saleBill.setHsn(rs.getInt("hsn"));
		saleBill.setSgst(rs.getDouble("sgst"));
		saleBill.setCgst(rs.getDouble("cgst"));
		saleBill.setIgst(rs.getDouble("igst"));
		saleBill.setTransportMode(rs.getString("transport_mode"));
		saleBill.setVehicleNo(rs.getString("vehicle_no"));
		saleBill.setDate(rs.getString("dt"));
		
		return saleBill;
	}

}
