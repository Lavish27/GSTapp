package com.app.domain;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Screener {

	private Resources<Resource<ScreenerFilter>> filters ;
	private Resources<Resource<ScreenerColumn>> columns ;
	
	public Resources<Resource<ScreenerFilter>> getFilters() {
		return filters;
	}
	
	public void setFilters(Resources<Resource<ScreenerFilter>> filters) {
		this.filters = filters;
	}
	
	public Resources<Resource<ScreenerColumn>> getColumns() {
		return columns;
	}
	
	public void setColumns(Resources<Resource<ScreenerColumn>> columns) {
		this.columns = columns;
	}
	
}
