package com.app.repository.sql;

public class ClientDetailsQueries {

	public static final String getClientDetails = "select * from client where client_id = :clientId";

	public static final String updateClientDetails = "update client set client_name = :clientName, description= :description, address= :address, gstin= :gstin,"
			+ "phone= :phone, bank_name= :bankName, bank_branch= :bankBranch, bank_acc= :bankAcc, bank_ifsc= :bankIFSC, GHSN= :ghsn, SHSN= :shsn, "
			+ "sgst_rate= :sgst, cgst_rate = :cgst, igst_rate= :igst where client_id= :clientId";

}
