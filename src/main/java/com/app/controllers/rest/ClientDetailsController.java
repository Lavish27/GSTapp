package com.app.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.ClientDetails;
import com.app.service.ClientDetailsService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value= "client-details")
public class ClientDetailsController {
	private static final Long clientId = 1L;
	@Autowired
	private ClientDetailsService clientDetailsService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientDetails getClientDetails() {
		return clientDetailsService.getClientDetails(clientId);
}
	
	@RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateClientDetails(@RequestBody() ClientDetails clientDetails) {
		clientDetailsService.updateClientDetails(clientId, clientDetails);
}
}
