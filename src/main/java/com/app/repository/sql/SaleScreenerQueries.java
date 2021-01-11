package com.app.repository.sql;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class SaleScreenerQueries {

	public static final String submitSaleData = "insert into sell(cust_name, cust_address, s_rt, g_rt, s_wt, g_wt, hsn, sgst, cgst, igst, transport_mode, vehicle_no)"
			+ "values(:cust_name, :cust_address, :s_rt, :g_rt, :s_wt, :g_wt, :hsn, :sgst, :cgst, :igst, :transport_mode, :vehicle_no)";

	public static final String getSaleData = "select * from sell where invoice_no = :invoiceNo";
	
	
	public static final String filterInvoiceNo = "with temp as (select invoice_no as filterValue from sell)"
		+ " select filterValue from temp"
		+ " if{value} where upper(filterValue) like concat('%',upper(:value),'%') endIf "
		+ "order by filterValue ";
	
	
	public static final String filterCustName = "";
	public static final String filterAadhar = "";
	public static final String filterDate = "";
	public static final Map<String, String> filterMap = ImmutableMap.of("invoice-number", filterInvoiceNo, "customer-name", filterCustName,
			"aadhar", filterAadhar, "bill-date", filterDate);
	
	
	
}
