package com.app.common.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.app.domain.ScreenerColumn;
import com.app.domain.ScreenerFilter;
import com.app.repository.ScreenerDao;
import com.app.service.ResourceFilter;
import com.google.common.collect.Lists;

public class ResourceFactory {

	@Autowired
	private static ScreenerDao screenerDao;
	
	public static List<Resource<ScreenerColumn>> createScreenerColumnList( ScreenerFactory.Screener screener) {

		/**Map<String, Object> queryParameters = new HashMap<>();
		queryParameters.put(USER_ID, userId);
		queryParameters.put("screenerName", screener.getScreener());
		queryParameters.put("portalName", screener.getPortal());
		queryParameters.put(IS_EXPORT, export);
		**/

		List<ScreenerColumn> screenerColumns = screenerDao.getScreenerColumns(screener.getScreener(), screener.getPortal());

		if (screenerColumns.isEmpty()) {
			return new ArrayList<>();
		}

		List<Resource<ScreenerColumn>> screenerColumnList = Lists.newArrayList();
		for (ScreenerColumn screenerColumn : screenerColumns) {
			Resource<ScreenerColumn> screenerColumnResource = new Resource<>(screenerColumn);
			screenerColumnList.add(screenerColumnResource);
		}
		return screenerColumnList;
	}
	
	public static List<Resource<ScreenerFilter>> createScreenerFilterList( ScreenerFactory.Screener screener, Class<? extends ResourceFilter> proxyFilterClass) {
		List<ScreenerFilter> screenerFilters = screenerDao.getScreenerFilters(screener.getScreener(), screener.getPortal());
		
		if (screenerFilters.isEmpty()) {
			return new ArrayList<>();
		}

        List<Resource<ScreenerFilter>> screenerFilterList = new ArrayList<>();
        for(ScreenerFilter filter : screenerFilters) {
        	Resource<ScreenerFilter> resource = new Resource<>(filter);
        	addLinkToResource(resource, proxyFilterClass);
        	screenerFilterList.add(resource);
        }
        return screenerFilterList;

		
	}

	private static void addLinkToResource(Resource<ScreenerFilter> filterResource, Class<? extends ResourceFilter> proxyFilterClass) {
		final String uriSuffix = filterResource.getContent().getFilterOptionsUriSuffix();
		if(!StringUtils.isBlank(uriSuffix)) {
		Link filterLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(proxyFilterClass).getFilterOptions(uriSuffix, null)).withRel("filter-options");
		filterResource.add(filterLink);
		}
		
	}
	}

