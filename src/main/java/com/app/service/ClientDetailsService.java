package com.app.service;

import com.app.domain.ClientDetails;

public interface ClientDetailsService {

	ClientDetails getClientDetails(Long clientId);
	void updateClientDetails(Long clientId, ClientDetails clientDetails);
}
