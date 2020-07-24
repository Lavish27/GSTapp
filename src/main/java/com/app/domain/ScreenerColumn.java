package com.app.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ScreenerColumn {

	private Long columnId;
	private String name;
	private String columnMappingName;
	private boolean isConfigurable;
	private boolean isEnabled;
	private String[] columnSettings;
	private String groupName;
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
	public boolean isConfigurable() {
		return isConfigurable;
	}
	public void setConfigurable(boolean isConfigurable) {
		this.isConfigurable = isConfigurable;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public String[] getColumnSettings() {
		return columnSettings;
	}
	public void setColumnSettings(String[] columnSettings) {
		this.columnSettings = columnSettings;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
