package com.app.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.common.utils.QueryUtils;
import com.app.domain.ScreenerColumn;
import com.app.domain.ScreenerFilter;
import com.app.repository.BaseDao;
import com.app.repository.ScreenerDao;
import com.app.repository.sql.AbstractScreenerQueries;

@Repository
public class ScreenerDaoImpl extends BaseDao implements ScreenerDao {

	@Override
	public List<ScreenerColumn> getScreenerColumns(String screenerName) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
        		.addValue("screenerName", screenerName);
		List<ScreenerColumn> columnList =  getNamedParameterJdbcTemplate().query(AbstractScreenerQueries.getColumns, paramSource, new ColumnsRowMapper());
		return columnList;
	}

	@Override
	public List<ScreenerFilter> getScreenerFilters(String screenerName) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
        		.addValue("screenerName", screenerName);
		List<ScreenerFilter> filterList =  getNamedParameterJdbcTemplate().query(AbstractScreenerQueries.getFilters, paramSource, new FiltersRowMapper());
		return filterList;
	}
	
	@Override
	public List<String> getFilterValues(String query, Map<String,String> filters) {
		return getNamedParameterJdbcTemplate().queryForList(query, new MapSqlParameterSource(filters), String.class);
	}
	
	@Override
	public List<Map<String, Object>> getScreenerData(String query, Map<String, Object> params) {
		return getNamedParameterJdbcTemplate().query(query, new MapSqlParameterSource(params), new ScreenerDataRowMapper());
	}
	
	
	//////////ROW MAPPERS //////

	private static class ColumnsRowMapper implements RowMapper<ScreenerColumn> {
		public ScreenerColumn mapRow(ResultSet rs, int rowNum) throws SQLException {
			ScreenerColumn column = new ScreenerColumn();
			column.setColumnId(rs.getLong("column_id"));
			column.setName(rs.getString("column_name"));
			column.setColumnMappingName(rs.getString("column_mapping_key"));
			return column;
		}
	}
	
	private static class FiltersRowMapper implements RowMapper<ScreenerFilter> {
		public ScreenerFilter mapRow(ResultSet rs, int rowNum) throws SQLException {
			ScreenerFilter filter = new ScreenerFilter();
			filter.setFilterId(rs.getLong("filter_id"));
			filter.setFilterName(rs.getString("filter_name"));
			filter.setFilterOptionsUriSuffix(rs.getString("filter_options_uri_suffix"));
			filter.setFilterType(rs.getString("filter_type"));
			return filter;
		}
	}
	
	private static class ScreenerDataRowMapper implements RowMapper<Map<String, Object>> {
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Map<String, Object> map = new HashMap<>();
			map.put("invoice_number", rs.getLong("invoice_number"));
			map.put("cust_name", rs.getString("cust_name"));
			map.put("aadhar", rs.getString("aadhar"));
			map.put("phone_number", rs.getString("phone_number"));
			map.put("bill_date", QueryUtils.formatDate(rs.getString("bill_date")));
			map.put("gold_wt", rs.getDouble("gold_wt"));
			map.put("silver_wt", rs.getDouble("silver_wt"));
			map.put("total_gst", rs.getDouble("total_gst"));
			map.put("grand_total", rs.getDouble("grand_total"));
			map.put("sub_total", rs.getDouble("sub_total"));
			map.put("rnum", rs.getLong("rnum"));
			return map;
		}
	}

	

	
			
	
	
}
