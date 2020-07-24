package com.app.controllers.rest;

import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.factory.ScreenerFactory;
import com.google.common.collect.Sets;

@RestController
@RequestMapping("/screener/sale-screener")
public class SaleScreenerController extends AbstractScreenerController {
	private static final Set<String> filterExpectedParams = Sets.newHashSet("filter1","filter2");
	
	SaleScreenerController(){
	super(ScreenerFactory.getSaleScreener(), filterExpectedParams);
	}
}
