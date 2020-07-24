package com.app.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.domain.ScreenerColumn;
import com.app.domain.ScreenerFilter;
import com.app.repository.BaseDao;
import com.app.repository.ScreenerDao;

@Repository
public class ScreenerDaoImpl extends BaseDao implements ScreenerDao {

	@Override
	public List<ScreenerColumn> getScreenerColumns(String screenerName, String portalName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScreenerFilter> getScreenerFilters(String screenerName, String portalName) {
		// TODO Auto-generated method stub
		return null;
	}

}
