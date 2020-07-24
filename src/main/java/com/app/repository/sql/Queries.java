package com.app.repository.sql;

public class Queries {

	public static final String submitSaleData = "insert into sell(cust_name, cust_address, s_rt, g_rt, s_wt, g_wt, hsn, sgst, cgst, igst, transport_mode, vehicle_no)"
			+ "values(:cust_name, :cust_address, :s_rt, :g_rt, :s_wt, :g_wt, :hsn, :sgst, :cgst, :igst, :transport_mode, :vehicle_no)";

	public static final String getSaleData = "select * from sell where invoice_no = :invoiceNo";

	public static final String subtGoldStock = "update STOCK set quantity = quantity - :g_wt where type = 'Gold'";

	public static final String subtSilverStock = "update STOCK set quantity = quantity - :s_wt where type = 'Silver'";

	public static final String addGoldStock = "update STOCK set quantity = quantity + :g_wt where type = 'Gold'";

	public static final String addSilverStock = "update STOCK set quantity = quantity + :s_wt where type = 'Silver'";

}
