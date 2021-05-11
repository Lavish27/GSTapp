package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.domain.ClientDetails;
import com.app.repository.ClientDetailsDao;
import com.app.service.ClientDetailsService;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService{

	@Autowired
	private ClientDetailsDao clientDetailsDao;
	
	@Override
	public ClientDetails getClientDetails(Long clientId) {
		return clientDetailsDao.getClientDetails(clientId);
	}

	@Override
	public void updateClientDetails(Long clientId, ClientDetails clientDetails) {
		
		clientDetailsDao.updateClientDetails(clientId, clientDetails);
	}

}
