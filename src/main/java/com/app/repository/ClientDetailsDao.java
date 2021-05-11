package com.app.repository;

import com.app.domain.ClientDetails;

public interface ClientDetailsDao {

	ClientDetails getClientDetails(Long clientId);
	void updateClientDetails(Long clientId, ClientDetails clientDetails);
}
