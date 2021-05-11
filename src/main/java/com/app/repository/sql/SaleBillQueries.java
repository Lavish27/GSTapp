package com.app.repository.sql;

public class SaleBillQueries {

	public static final String submitSaleData = "insert into sell(cust_name, cust_address, s_rt, g_rt, s_wt, g_wt, sgst, cgst, igst, transport_mode, vehicle_no,"
			+ "phone, aadhar, state, state_code, s_amount, g_amount, g_hsn, s_hsn, sub_total, bill_date, sgst_rate, cgst_rate, igst_rate, total_gst, grand_total, "
			+ "round_off, grand_total_in_words)"
			+ "values(:custName, :custAddress, :s_rt, :g_rt, :s_wt, :g_wt, :sgst, :cgst, :igst, :transport_mode, :vehicleNo, :phoneNo, :aadhar, :state, :stateCode, "
			+ ":sAmount, :gAmount, :gHsn, :sHsn, :subTotal, :billDate, :sgstRate, :cgstRate, :igstRate, :totalGst, :grandTotal, :roundOff, :grandTotalWords)";
	
	public static final String getSaleData = "select cust_name, cust_address, s_rt, g_rt, s_wt, g_wt, sgst, cgst, igst, transport_mode, vehicle_no, "
			+ "phone, aadhar, state, state_code, s_amount, g_amount, g_hsn, s_hsn, sub_total, bill_date, sgst_rate, cgst_rate, igst_rate, total_gst, grand_total, "
			+ "round_off, grand_total_in_words from sell where invoice_no = :invoiceNo ";

	public static final String subtGoldStock = "update STOCK set quantity = quantity - :g_wt where type = 'Gold'";

	public static final String subtSilverStock = "update STOCK set quantity = quantity - :s_wt where type = 'Silver'";

}
