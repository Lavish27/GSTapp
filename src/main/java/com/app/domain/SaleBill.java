package com.app.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private int hsn;
	private double sgst;
	private double cgst;
	private double igst;
	private String transportMode;
	private String vehicleNo;
	private String date;
	
	
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
	
	public int getHsn() {
		return hsn;
	}
	
	public void setHsn(int hsn) {
		this.hsn = hsn;
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
		return date.substring(0, 10);
	}
	
	
	public void setDate(String date) {
		this.date = date;
	}

}
