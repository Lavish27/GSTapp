package com.app.repository.sql;

public class AbstractScreenerQueries {

	public static final String getColumns = "select column_id, column_name, column_mapping_key from SCREENER_COLUMNS "
			+ "where screener_name = :screenerName order by display_order";
	
	public static final String getFilters = "select sf.filter_id , sf.filter_name, sf.filter_options_uri_suffix, rft.filter_type"
			+ " from SCREENER_FILTERS sf join REF_FILTER_TYPE rft on sf.filter_type_id = rft.filter_type_id"
			+ " where sf.screener_name = :screenerName order by sf.display_order";
}
