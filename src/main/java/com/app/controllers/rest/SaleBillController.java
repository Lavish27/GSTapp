package com.app.controllers.rest;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.SaleBill;
import com.app.repository.SaleDao;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/sale-data")
public class SaleBillController {
	
	@Resource
	SaleDao saleDao;
	
	@RequestMapping(value ="/{invoiceNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SaleBill getSaleData(@PathVariable Object invoiceNo) throws Exception{
		
		int invoiceNumber;
		
		try {
			invoiceNumber = Integer.valueOf(invoiceNo.toString());
		}
		catch(NumberFormatException e)
		{
			throw new NumberFormatException("InvoiceNumber should be a number");
		}
		
		return saleDao.getSaleData(invoiceNumber);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public Long submitSaleData(@RequestBody SaleBill saleBill) {
		Long invoiceId = saleDao.submitSaleData(saleBill);
		saleDao.updateStock(saleBill);
		return invoiceId;
		
	}
	

}
