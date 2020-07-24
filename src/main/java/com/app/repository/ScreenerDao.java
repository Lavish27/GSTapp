package com.app.repository;

import java.util.List;

import com.app.domain.ScreenerColumn;
import com.app.domain.ScreenerFilter;

public interface ScreenerDao {
	
	List<ScreenerColumn> getScreenerColumns(String screenerName, String portalName);

	List<ScreenerFilter> getScreenerFilters(String screenerName, String portalName);
}
