package com.app.controllers.rest;

import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.factory.ScreenerFactory;
import com.app.repository.sql.SaleScreenerQueries;
import com.google.common.collect.Sets;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/screener/sale-screener")
public class SaleScreenerController extends AbstractScreenerController {
	private static final Set<String> filterExpectedParams = Sets.newHashSet("filter1","filter2");
	
	SaleScreenerController(){
	super(ScreenerFactory.getSaleScreener(), filterExpectedParams);
	}
	
	@Override
	public Map<String, String> getFilterMap(){
		return SaleScreenerQueries.filterMap;
	}
	

}
