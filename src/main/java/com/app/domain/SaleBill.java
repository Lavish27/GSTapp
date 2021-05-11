package com.app.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SaleBill {
	
	private int invoiceNo;
	private String custName;
	private String custAddress;
	private double s_rt;
	private double g_rt;
	private double s_wt;
	private double g_wt;
	private String gHsn;
	private String sHsn;
	private double sgst;
	private double cgst;
	private double igst;
	private String transportMode;
	private String vehicleNo;
	private String date;
	private String phoneNo;
	private String aadhar;
	private String state;
	private String stateCode;
	private double sAmount;
	private double gAmount;
	private double subTotal;
	private double sgstRate;
	private double cgstRate;
	private double igstRate;
	private double totalGst;
	private double grandTotal;
	private double roundOff;
	private String grandTotalWords;
	
	
	
	public double getRoundOff() {
		return roundOff;
	}


	public void setRoundOff(double roundOff) {
		this.roundOff = roundOff;
	}


	public String getGrandTotalWords() {
		return grandTotalWords;
	}


	public void setGrandTotalWords(String grandTotalWords) {
		this.grandTotalWords = grandTotalWords;
	}


	public String getgHsn() {
		return gHsn;
	}


	public void setgHsn(String gHsn) {
		this.gHsn = gHsn;
	}


	public String getsHsn() {
		return sHsn;
	}


	public void setsHsn(String sHsn) {
		this.sHsn = sHsn;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAadhar() {
		return aadhar;
	}


	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getStateCode() {
		return stateCode;
	}


	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


	public double getsAmount() {
		return sAmount;
	}


	public void setsAmount(double sAmount) {
		this.sAmount = sAmount;
	}


	public double getgAmount() {
		return gAmount;
	}


	public void setgAmount(double gAmount) {
		this.gAmount = gAmount;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public double getSgstRate() {
		return sgstRate;
	}


	public void setSgstRate(double sgstRate) {
		this.sgstRate = sgstRate;
	}


	public double getCgstRate() {
		return cgstRate;
	}


	public void setCgstRate(double cgstRate) {
		this.cgstRate = cgstRate;
	}


	public double getIgstRate() {
		return igstRate;
	}


	public void setIgstRate(double igstRate) {
		this.igstRate = igstRate;
	}


	public double getTotalGst() {
		return totalGst;
	}


	public void setTotalGst(double totalGst) {
		this.totalGst = totalGst;
	}


	public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}


	public int getInvoiceNo() {
		return invoiceNo;
	}
	

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getCustAddress() {
		return custAddress;
	}
	
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	public double getS_rt() {
		return s_rt;
	}
	
	public void setS_rt(double s_rt) {
		this.s_rt = s_rt;
	}
	
	public double getG_rt() {
		return g_rt;
	}
	
	public void setG_rt(double g_rt) {
		this.g_rt = g_rt;
	}
	
	public double getS_wt() {
		return s_wt;
	}
	
	public void setS_wt(double s_wt) {
		this.s_wt = s_wt;
	}
	
	public double getG_wt() {
		return g_wt;
	}
	
	public void setG_wt(double g_wt) {
		this.g_wt = g_wt;
	}
	
	
	public double getSgst() {
		return sgst;
	}
	
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}
	
	public double getCgst() {
		return cgst;
	}
	
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	
	public double getIgst() {
		return igst;
	}
	
	public void setIgst(double igst) {
		this.igst = igst;
	}
	
	public String getTransportMode() {
		return transportMode;
	}
	
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	public String getDate() {
		return this.date;
	}
	
	
	public void setDate(String date) {
		this.date = date;
	}

}
