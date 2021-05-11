package com.app.controllers.rest;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.factory.ScreenerFactory;
import com.app.common.utils.ApiWebUtils;
import com.app.common.utils.QueryUtils;
import com.app.repository.ScreenerDao;
import com.app.repository.sql.SaleScreenerQueries;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/screener/sale-screener")
public class SaleScreenerController extends AbstractScreenerController {
	
	@Resource
	private ScreenerDao screenerDao;
	
	SaleScreenerController(){
	super(ScreenerFactory.getSaleScreener());
	}
	
	@Override
	public Map<String, String> getFilterMap(){
		return SaleScreenerQueries.filterMap;
	}

	@Override
	protected List<Map<String, Object>> getScreener(Map<String, String> filters) {
		Map<String, Object> params = ApiWebUtils.createParamsFromFilters(filters);
		String query = QueryUtils.manipulateQueryStringForMultipleInValues(SaleScreenerQueries.getScreener, params.keySet());
		List<Map<String, Object>> screenerData =  screenerDao.getScreenerData(query, params);
		/*if(!CollectionUtils.isEmpty(screenerData) && params.containsKey(Constants.fromRow) && params.containsKey(Constants.toRow)) {
			screenerData =  QueryUtils.filterAsPerPagination(screenerData,Long.valueOf(params.get(Constants.fromRow).toString()), Long.valueOf(params.get(Constants.toRow).toString()));
		}
		*/
		
		return screenerData;
		
	}
	
	
	

}
