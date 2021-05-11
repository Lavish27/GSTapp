package com.app.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class QueryUtils {

	public static String manipulateQueryString(String query, Set<String> filters) {
		
		while(StringUtils.contains(query, "if{")) {
			String parsedFilter = StringUtils.substringBetween(query, "if{", "}").trim();
			if(filters.contains(parsedFilter)) {
				query = StringUtils.replaceOnce(query, String.format("if{%s}",parsedFilter), "");
				query = StringUtils.replaceOnce(query, " endIf", " ");
			}
			else {
				query = StringUtils.removeFirst(query, String.format("if\\{%s\\}.*?endIf",parsedFilter));
			}
		}
		return query;
	}
	
	
	public static String manipulateQueryStringForMultipleInValues(String query, Set<String> filters) {
		
		while(StringUtils.contains(query, "if{")) {
			String parsedFilter = StringUtils.substringBetween(query, "if{", "}").trim();
			if(filters.contains(parsedFilter)) {
				filters.remove(parsedFilter);
				Set<String> parsedFilterKeys = filters.stream().filter(f -> f.startsWith(parsedFilter)).map(f -> ":"+f).collect(Collectors.toSet());
				query = StringUtils.replaceOnce(query, String.format("if{%s}",parsedFilter), "");
				query = StringUtils.replaceOnce(query, " endIf", " ");
				query = StringUtils.replaceOnce(query, "(:"+parsedFilter+")", "("+String.join(",", parsedFilterKeys)+")");
			}
			else {
				query = StringUtils.removeFirst(query, String.format("if\\{%s\\}.*?endIf",parsedFilter));
			}
		}
		return query;
	}
	
	
	public static List<Map<String, Object>> filterAsPerPagination(List<Map<String, Object>> screenerData, Long fromRow, Long toRow) {
		
		return screenerData.stream().filter(m -> Long.valueOf(m.get("rnum").toString()) >= fromRow &&
				Long.valueOf(m.get("rnum").toString()) <= toRow ).collect(Collectors.toList());
		
	}
	
	public static String formatDate(String billDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(billDate, dtf);
		String formattedBillDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		return formattedBillDate;
	}
}
