package com.app.repository;

import java.util.List;
import java.util.Map;

import com.app.domain.ScreenerColumn;
import com.app.domain.ScreenerFilter;

public interface ScreenerDao {
	
	List<ScreenerColumn> getScreenerColumns(String screenerName);

	List<ScreenerFilter> getScreenerFilters(String screenerName);
	
	List<String> getFilterValues(String query, Map<String, String> filters);
}
