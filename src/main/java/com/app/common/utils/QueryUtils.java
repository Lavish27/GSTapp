package com.app.common.utils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class QueryUtils {

	public static String manipulateQueryString(String query, Map<String, String> filters) {
		
		while(StringUtils.contains(query, "if{")) {
			String parsedFilter = StringUtils.substringBetween(query, "if{", "}").trim();
			if(filters.containsKey(parsedFilter)) {
				query = StringUtils.replaceOnce(query, String.format("if{%s}",parsedFilter), "");
				query = StringUtils.replaceOnce(query, " endIf", " ");
			}
			else {
				query = StringUtils.removeFirst(query, String.format("if\\{%s\\}",parsedFilter)+".*endIf");
			}
		}
		return query;
	}
}
