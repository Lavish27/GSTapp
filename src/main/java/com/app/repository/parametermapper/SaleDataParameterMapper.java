package com.app.repository.parametermapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.domain.SaleBill;

@Component
public class SaleDataParameterMapper {
	
	public Map submitSaleData(SaleBill saleBill) {
		
		Map<String,Object> params = new HashMap();
		
		params.put("cust_name", saleBill.getCustName());
		params.put("cust_address", saleBill.getCustAddress());
		params.put("s_rt", saleBill.getS_rt());
		params.put("g_rt", saleBill.getG_rt());
		params.put("s_wt", saleBill.getS_wt());
		params.put("g_wt", saleBill.getG_wt());
		params.put("hsn", saleBill.getHsn());
		params.put("sgst", saleBill.getSgst());
		params.put("cgst", saleBill.getCgst());
		params.put("igst", saleBill.getIgst());
		params.put("transport_mode", saleBill.getTransportMode());
		params.put("vehicle_no", saleBill.getVehicleNo());
		
		return params;
	}
	
public Map updateStock(SaleBill saleBill) {
		
		Map<String,Object> params = new HashMap();
		
		params.put("s_wt", saleBill.getS_wt());
		params.put("g_wt", saleBill.getG_wt());
		
		return params;
	}


}
