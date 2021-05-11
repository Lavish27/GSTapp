package com.app.common.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import com.app.common.utils.Constants;

public class ApiWebUtils {
	private static final String filterDelimitter = "%dlmtr%";
	
	public static Map<String, Object> createParamsFromFilters(Map<String, String> filters){
		Map<String, Object> params = new HashMap<>();
		
		for(Map.Entry<String, String> entry: filters.entrySet()) {
			String key = StringUtils.remove(entry.getKey(), '-');
			params.put(key, "");
			List<String> values = Arrays.asList(entry.getValue().split(filterDelimitter));
			for(int i = 0; i<values.size();i++) {
				params.put(key+i, values.get(i));
			}
			
		}
		
		//filters.entrySet().stream().map(entry -> params.put(StringUtils.remove(entry.getKey(), '-'), Arrays.asList(entry.getValue().split(filterDelimitter))));
		/*if(!CollectionUtils.isEmpty(filters)) {
				calibratePageSize(filters, params);	
			
		}*/
		return params;
	}
	private static void calibratePageSize(Map<String, String> filters, Map<String, Object> params) {
		if(StringUtils.isBlank(filters.get(Constants.fromRow))){
			params.put(Constants.fromRow, 1);
		}
		else {
		params.put(Constants.fromRow, filters.get(Constants.fromRow));
		}
		if(!StringUtils.isBlank(filters.get(Constants.pageSize)) && Integer.valueOf(filters.get(Constants.pageSize))<=Constants.maxPageSize) {
			params.put(Constants.toRow, Integer.valueOf(params.get(Constants.fromRow).toString()) + Integer.valueOf(filters.get(Constants.pageSize))-1);
		}
		else {
			params.put(Constants.toRow, Integer.valueOf(params.get(Constants.fromRow).toString()) + Constants.maxPageSize -1);
		}
		
	}

}
