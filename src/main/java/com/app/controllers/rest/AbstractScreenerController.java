package com.app.controllers.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.factory.ResourceFactory;
import com.app.common.factory.ScreenerFactory;
import com.app.common.utils.QueryUtils;
import com.app.domain.Screener;
import com.app.domain.ScreenerColumn;
import com.app.domain.ScreenerFilter;
import com.app.repository.ScreenerDao;
import com.app.service.ResourceFilter;
import com.google.common.collect.ImmutableMap;


@RestController
public abstract class AbstractScreenerController implements ResourceFilter {
	
	@Autowired
	private ScreenerDao screenerDao;

	protected static final String DELIMITTER = "/";
	protected static final String FILTER_PATH_VARIABLE = "filter-name";
	protected static final String METADATA_LINK = DELIMITTER+"metadata";
	protected static final String FILTER_LINK = DELIMITTER+"filters"+DELIMITTER+"{"+FILTER_PATH_VARIABLE+"}";
	private static final Long FILTER_MAX_SIZE = 50L;

	private ScreenerFactory.Screener screener;
	private Class<? extends ResourceFilter> filterControllerClass;
	private AbstractScreenerController childControllerproxy;

	protected AbstractScreenerController(ScreenerFactory.Screener screener) {
		this.screener = screener;
		this.filterControllerClass = this.getClass();
		this.childControllerproxy = ControllerLinkBuilder.methodOn(this.getClass());
	}

	@RequestMapping(value = METADATA_LINK, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource<Screener>> getMetadata(){
		return new ResponseEntity<>(getMetaDataObject(), HttpStatus.OK);

	}

	private Resource<Screener> getMetaDataObject() {
		List<Resource<ScreenerFilter>> screenerFilterList = ResourceFactory.createScreenerFilterList(screener, filterControllerClass, screenerDao);
		List<Resource<ScreenerColumn>> screenerColumnList = ResourceFactory.createScreenerColumnList(screener, screenerDao);
		Screener screener = new Screener();
		screener.setColumns(new Resources<>(screenerColumnList));
		screener.setFilters(new Resources<>(screenerFilterList));
		Resource<Screener> screenerResource = new Resource<>(screener);
		
		//addLinksToResource(screenerResource);
		return screenerResource;
	}
	
	@RequestMapping(value = FILTER_LINK, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getFilterOptions(@PathVariable(value = FILTER_PATH_VARIABLE) String filterName, @RequestParam(required = false) Map<String, String> filters) {
		String query = validateFilterName(getFilterMap(), filterName);
		return screenerDao.getFilterValues(QueryUtils.manipulateQueryString(query, filters.keySet()), filters).stream().limit(FILTER_MAX_SIZE).collect(Collectors.toList());
	}
	
	protected Map<String, String> getFilterMap(){
		return ImmutableMap.of();
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String, Object>> getScreenerData(@RequestParam(required=false) Map<String, String> filters){
		return getScreener(filters);
	}
	
	protected abstract List<Map<String, Object>> getScreener(Map<String, String> filters);
	
	private String validateFilterName(Map<String, String> filterMap, String filterName) {
		String query = filterMap.get(filterName);
		if(StringUtils.isBlank(query))
			throw new IllegalArgumentException(String.format("Invalid Filter Name [%s]", filterName));
		return query;
	}

}
