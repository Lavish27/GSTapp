package com.app.repository.impl;

import static com.app.repository.sql.ClientDetailsQueries.getClientDetails;
import static com.app.repository.sql.ClientDetailsQueries.updateClientDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.domain.ClientDetails;
import com.app.repository.BaseDao;
import com.app.repository.ClientDetailsDao;

@Repository
public class ClientDetailsDaoImpl extends BaseDao implements ClientDetailsDao {

	@Override
	public ClientDetails getClientDetails(Long clientId) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
        		.addValue("clientId", clientId);
		return getNamedParameterJdbcTemplate().queryForObject(getClientDetails, paramSource, new ClientDetailsRowMapper());
		
	}

	@Override
	public void updateClientDetails(Long clientId, ClientDetails clientDetails) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("clientId", clientId)
        		.addValue("clientName", clientDetails.getClientName())
        		.addValue("description", clientDetails.getDescription())
        		.addValue("address", clientDetails.getAddress())
        		.addValue("gstin", clientDetails.getGstin())
        		.addValue("phone", clientDetails.getPhone())
        		.addValue("bankName", clientDetails.getBankName())
        		.addValue("bankBranch", clientDetails.getBankBranch())
        		.addValue("bankAcc", clientDetails.getBankAccNo())
        		.addValue("bankIFSC", clientDetails.getBankIFSC())
        		.addValue("ghsn", clientDetails.getGhsn())
        		.addValue("shsn", clientDetails.getShsn())
        		.addValue("sgst", clientDetails.getSgst())
        		.addValue("cgst", clientDetails.getCgst())
        		.addValue("igst", clientDetails.getIgst());
		getNamedParameterJdbcTemplate().update(updateClientDetails, paramSource);
		
	}
	
	/////RowMappers//////
	
	private static class ClientDetailsRowMapper implements RowMapper<ClientDetails> {
		public ClientDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			ClientDetails clientDetails = new ClientDetails();
			clientDetails.setClientId(rs.getLong("client_id"));
			clientDetails.setClientName(rs.getString("client_name"));
			clientDetails.setDescription(rs.getString("description"));
			clientDetails.setAddress(rs.getString("address"));
			clientDetails.setGstin(rs.getString("gstin"));
			clientDetails.setPhone(rs.getString("phone"));
			clientDetails.setBankName(rs.getString("bank_name"));
			clientDetails.setBankBranch(rs.getString("bank_branch"));
			clientDetails.setBankAccNo(rs.getString("bank_acc"));
			clientDetails.setBankIFSC(rs.getString("bank_ifsc"));
			clientDetails.setGhsn(rs.getString("GHSN"));
			clientDetails.setShsn(rs.getString("SHSN"));
			clientDetails.setSgst(rs.getDouble("sgst_rate"));
			clientDetails.setCgst(rs.getDouble("cgst_rate"));
			clientDetails.setIgst(rs.getDouble("igst_rate"));
			return clientDetails;
		}
	}
	

}
