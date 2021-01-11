package com.app.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_EMPTY)
public class ScreenerColumn {

	private Long columnId;
	
	@JsonProperty("columnName")
	private String name;
	
	private String columnMappingName;
	
	public Long getColumnId() {
		return columnId;
	}
	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColumnMappingName() {
		return columnMappingName;
	}
	public void setColumnMappingName(String columnMappingName) {
		this.columnMappingName = columnMappingName;
	}
	
}
