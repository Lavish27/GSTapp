package com.app.repository.sql;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class SaleScreenerQueries {

	
	public static final String getSaleData = "select * from sell where invoice_no = :invoiceNo";
	public static final String getScreener = "with internal_t as ("
			+ "select invoice_no as 'invoice_number',"
			+ "cust_name , aadhar, "
			+ "phone as 'phone_number',"
			+ "bill_date, g_wt as 'gold_wt',"
			+ "s_wt as 'silver_wt', total_gst,"
			+ "round_off as 'grand_total', sub_total "
			+ "from sell where 1=1"
			+ "if{invoicenumber} and invoice_no in (:invoicenumber) endIf"
			+ "if{customername} and cust_name in (:customername) endIf"
			+ "if{aadhar} and aadhar in (:aadhar) endIf),"
			+ "internal_tt as ("
			+ "select t.* , "
			+ "row_number() over(order by t.invoice_number desc) as 'rnum'"
			+ "from internal_t t)"
			+ "select * from internal_tt ";
	
	
	public static final String filterInvoiceNo = "with temp as (select invoice_no as filterValue from sell)"
		+ " select filterValue from temp"
		+ " if{value} where upper(filterValue) like concat('%',upper(:value),'%') endIf "
		+ "order by filterValue desc ";
	
	
	public static final String filterCustName = "with temp as (select distinct cust_name as filterValue from sell)"
			+ " select filterValue from temp"
			+ " if{value} where upper(filterValue) like concat('%',upper(:value),'%') endIf "
			+ "order by filterValue ";
	
	public static final String filterAadhar = "with temp as (select distinct aadhar as filterValue from sell where aadhar is not null and trim(aadhar) <> '')"
			+ " select filterValue from temp"
			+ " if{value} where upper(filterValue) like concat('%',upper(:value),'%') endIf "
			+ "order by filterValue ";
	
	public static final String filterDate = "";
	public static final Map<String, String> filterMap = ImmutableMap.of("invoice-number", filterInvoiceNo, "customer-name", filterCustName,
			"aadhar", filterAadhar, "bill-date", filterDate);
	
	
	
}
