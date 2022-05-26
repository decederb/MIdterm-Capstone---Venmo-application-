package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.TransferStatusNotFoundException;
import com.techelevator.tenmo.exception.TransferTypeNotFoundException;
import com.techelevator.tenmo.model.TransferStatus;
import com.techelevator.tenmo.model.TransferType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcTransferTypeDao implements TransferTypeDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createTransferType (String transferTypeDesc) {
        String sql = "INSERT INTO transfer_type (transfer_type_desc) VALUES (?) RETURNING transfer_type_id;";
        int transferTypeId = 0;
        try {
            transferTypeId = jdbcTemplate.queryForObject(sql, int.class, transferTypeDesc);
            return transferTypeId;
        } catch (DataAccessException e) {
            return 0;
        }
    }

    @Override
    public TransferType getTransferType(int transferTypeId) throws TransferTypeNotFoundException {
        String sql = "SELECT transfer_status_desc FROM transfer_status WHERE transfer_status_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferTypeId);

        if (results != null) {
            return mapRowToTransferType(results);
        }
        throw new TransferTypeNotFoundException("Transfer " + transferTypeId + " was not found.");
    }

    @Override
    public TransferType updateTransferType(TransferType transferType) throws TransferTypeNotFoundException {
        String sql = "UPDATE transfer_type " +
                "SET transfer_type_desc = ? " +
                "WHERE transfer_type_id = ?;";
        jdbcTemplate.update(sql, transferType.getTransferTypeDesc(), transferType.getTransferTypeId());
        return getTransferType(transferType.getTransferTypeId());
    }

    @Override
    public void deleteTransferType(int transferTypeId) {

    }

    //This is where confusion on DELETE formatting causes related issues.
    /*
    @Override
    public void deleteTransferType(int transferTypeId) throws TransferTypeNotFoundException {
        String sql = "DELETE FROM transfer " +
                     "WHERE transfer_id = ?;";
        int rowsAffected = jdbcTemplate.update(sql, transferTypeId);
        if (rowsAffected == 0) throw new TransferTypeNotFoundException();
    }
     */
    private TransferType mapRowToTransferType(SqlRowSet rowSet) {
        TransferType transferType = new TransferType();
        transferType.setTransferTypeId(rowSet.getInt("transfer_type_id"));
        transferType.setTransferTypeDesc(rowSet.getString("transfer_type_desc"));
        return transferType;
    }



}
