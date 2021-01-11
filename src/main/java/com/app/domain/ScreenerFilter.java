package com.app.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ScreenerFilter {
	
	private long filterId;
	private String filterName;
	private String filterType;
	private String filterOptionsUriSuffix;
	
	
	public String getFilterName() {
		return filterName;
	}
	public String getFilterType() {
		return filterType;
	}
	public String getFilterOptionsUriSuffix() {
		return filterOptionsUriSuffix;
	}
	public long getFilterId() {
		return filterId;
	}
	public void setFilterId(long filterId) {
		this.filterId = filterId;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	public void setFilterOptionsUriSuffix(String filterOptionsUriSuffix) {
		this.filterOptionsUriSuffix = filterOptionsUriSuffix;
	}
	
}
