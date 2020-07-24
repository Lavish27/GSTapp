package com.app.service;

import java.util.List;
import java.util.Map;

public interface ResourceFilter {

	List<String> getFilterOptions(String filterName, Map<String, String> filters);
}
