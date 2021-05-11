package com.app.repository;

import com.app.domain.SaleBill;

public interface SaleDao {
	
	Long submitSaleData(SaleBill saleBil);
	
	void updateStock(SaleBill saleBill);
	
	SaleBill getSaleData(int invoiceNo);

}
