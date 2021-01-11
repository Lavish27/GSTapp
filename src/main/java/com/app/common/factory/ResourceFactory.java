package com.app.common.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.app.domain.ScreenerColumn;
import com.app.domain.ScreenerFilter;
import com.app.repository.ScreenerDao;
import com.app.service.ResourceFilter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;


public class ResourceFactory {
	
	public static List<Resource<ScreenerColumn>> createScreenerColumnList( ScreenerFactory.Screener screener, ScreenerDao screenerDao) {

		
		List<ScreenerColumn> screenerColumns = screenerDao.getScreenerColumns(screener.getScreener());

		if (screenerColumns == null || screenerColumns.isEmpty()) {
			return ImmutableList.of();
		}

		List<Resource<ScreenerColumn>> screenerColumnList = Lists.newArrayList();
		for (ScreenerColumn screenerColumn : screenerColumns) {
			Resource<ScreenerColumn> screenerColumnResource = new Resource<>(screenerColumn);
			screenerColumnList.add(screenerColumnResource);
		}
		return screenerColumnList;
	}
	
	public static List<Resource<ScreenerFilter>> createScreenerFilterList( ScreenerFactory.Screener screener, Class<? extends ResourceFilter> proxyFilterClass, ScreenerDao screenerDao) {
		List<ScreenerFilter> screenerFilters = screenerDao.getScreenerFilters(screener.getScreener());
		
		if (screenerFilters == null || screenerFilters.isEmpty()) {
			return ImmutableList.of();
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

