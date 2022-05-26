package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.TransferStatusNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class JdbcTransferStatusDao implements TransferStatusDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createTransferStatus (String transferStatusDesc) {
        String sql = "INSERT INTO transfer_status (transfer_status_desc) VALUES (?) RETURNING transfer_status_id;";
        int transferStatusId = 0;
        try {
            transferStatusId = jdbcTemplate.queryForObject(sql, int.class, transferStatusDesc);
            return transferStatusId;
        } catch (DataAccessException e) {
            return 0;
        }
    }

    @Override
    public TransferStatus getTransferStatus(int transferStatusId) throws TransferStatusNotFoundException {
        String sql = "SELECT transfer_status_desc FROM transfer_status WHERE transfer_status_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferStatusId);

        if (results != null) {
            return mapRowToTransferStatus(results);
        }
        throw new TransferStatusNotFoundException("Transfer " + transferStatusId + " was not found.");
    }

    @Override
    public TransferStatus updateTransferStatus(TransferStatus transferStatus) throws TransferStatusNotFoundException {
        String sql = "UPDATE transfer_status " +
                "SET transfer_status_desc = ? " +
                "WHERE transfer_status_id = ?;";
        jdbcTemplate.update(sql, transferStatus.getTransferStatusDesc(), transferStatus.getTransferStatusId());
        return getTransferStatus(transferStatus.getTransferStatusId());
    }

    @Override
    public void deleteTransferStatus(int transferStatusId) {

    }
//This is where confusion on DELETE formatting causes related issues.
    /*
    @Override
    public void deleteTransferStatus(int transferStatusId) {
    //Brian can you complete?
        String sql = "DELETE FROM transfer " +
                     "WHERE transfer_id = ?;";
        int rowsAffected = jdbcTemplate.update(sql, transferStatusId);
        if (rowsAffected == 0) throw new TransferStatusNotFoundException();
    }
     */

    private TransferStatus mapRowToTransferStatus(SqlRowSet rowSet) {
        TransferStatus transferStatus = new TransferStatus();
        transferStatus.setTransferStatusId(rowSet.getInt("transfer_status_id"));
        transferStatus.setTransferStatusDesc(rowSet.getString("transfer_status_desc"));
        return transferStatus;
    }


}
