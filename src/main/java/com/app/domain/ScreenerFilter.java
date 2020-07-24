package com.app.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ScreenerFilter {
	
	private long filterId;
	private String filterName;
	private String filterType;
	private String filterOptionsUriSuffix;
	private String[] screenerFilterKeys;
	private boolean isConfigurable;
	private boolean isEnabled;
	
	
	public String getFilterName() {
		return filterName;
	}
	public String getFilterType() {
		return filterType;
	}
	public String getFilterOptionsUriSuffix() {
		return filterOptionsUriSuffix;
	}
	public String[] getScreenerFilterKeys() {
		return screenerFilterKeys;
	}
	public boolean getIsConfigurable() {
		return isConfigurable;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public Long getFilterId() {
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
	public void setScreenerFilterKeys(String[] screenerFilterKeys) {
		this.screenerFilterKeys = screenerFilterKeys;
	}
	public void setIsConfigurable(boolean isConfigurable) {
		this.isConfigurable = isConfigurable;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	

}
