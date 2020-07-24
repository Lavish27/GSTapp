package com.app.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.app.domain.Screener;
import com.app.domain.ScreenerColumn;
import com.app.domain.ScreenerFilter;
import com.app.service.ResourceFilter;

@RestController
public abstract class AbstractScreenerController implements ResourceFilter {

	protected static final String DELIMITTER = "/";
	protected static final String FILTER_PATH_VARIABLE = "filter-name";
	protected static final String METADATA_LINK = DELIMITTER+"metadata";
	protected static final String FILTER_LINK = DELIMITTER+"filters"+DELIMITTER+"{"+FILTER_PATH_VARIABLE+"}";

	private ScreenerFactory.Screener screener;
	private Set<String> expectedFilterParams;
	private Class<? extends ResourceFilter> filterControllerClass;
	private AbstractScreenerController childControllerproxy;

	protected AbstractScreenerController(ScreenerFactory.Screener screener, Set<String> filterexpectedparams) {
		this.screener = screener;
		this.expectedFilterParams = filterexpectedparams;
		this.filterControllerClass = this.getClass();
		this.childControllerproxy = ControllerLinkBuilder.methodOn(this.getClass());
	}

	@RequestMapping(value = METADATA_LINK, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource<Screener>> getMetadata(){
		return new ResponseEntity<>(getMetaDataObject(), HttpStatus.OK);

	}

	private Resource<Screener> getMetaDataObject() {
		List<Resource<ScreenerFilter>> screenerFilterList = ResourceFactory.createScreenerFilterList(screener, filterControllerClass);
		List<Resource<ScreenerColumn>> screenerColumnList = ResourceFactory.createScreenerColumnList(screener);
		Screener screener = new Screener();
		screener.setColumns(new Resources<>(screenerColumnList));
		screener.setFilters(new Resources<>(screenerFilterList));
		Resource<Screener> screenerResource = new Resource<>(screener);
		
		//addLinksToResource(screenerResource);
		return screenerResource;
	}
	
	@RequestMapping(value = FILTER_LINK, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getFilterOptions(@PathVariable(value = FILTER_PATH_VARIABLE) String filterName, @RequestParam(required = false) Map<String, String> filters) {
		return new ArrayList<String>();
	}

}
