package com.techelevator.tenmo.dao;

<<<<<<< HEAD
=======
import com.techelevator.tenmo.exception.AccountNotFoundException;
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
import com.techelevator.tenmo.exception.TransferNotFoundException;
import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
<<<<<<< HEAD
import com.techelevator.tenmo.model.TransferStatus;
=======
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
import com.techelevator.tenmo.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
<<<<<<< HEAD

=======
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class JdbcTransferDao implements TransferDao {
    private JdbcUserDao jdbcUserDao;
    private JdbcTemplate jdbcTemplate;


    @Override
    public Transfer createTransfer(Transfer transfer) {
        String sql = "INSERT INTO transfer (account_from, account_to, amount) VALUES (?, ?, ?) RETURNING transfer_id;";
        Integer newTransferId;
        try {
            newTransferId = jdbcTemplate.queryForObject(sql, Integer.class, transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getTransferAmount());
            return getTransfer(newTransferId);
        } catch (DataAccessException | TransferNotFoundException e) {
            return null;
=======
@Component
public class JdbcTransferDao implements TransferDao {
    private JdbcAccountDao jdbcAccountDao;
    private JdbcUserDao jdbcUserDao;
    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcAccountDao jdbcAccountDao, JdbcUserDao jdbcUserDao, JdbcTemplate jdbcTemplate) {
    this.jdbcAccountDao = jdbcAccountDao;
    this.jdbcUserDao = jdbcUserDao;
    this.jdbcTemplate = jdbcTemplate;
}

    @Override
    public Integer createTransfer(int accountFromId, int accountToId, BigDecimal amountToTransfer) {
        Integer newTransferId;
        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (2, 2, ?, ?, ?) RETURNING transfer_id;";
        try {
            newTransferId = jdbcTemplate.queryForObject(sql, Integer.class, accountFromId, accountToId, amountToTransfer);
            return newTransferId;
        } catch (DataAccessException e) {
            return -1;
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
        }
    }

    @Override
<<<<<<< HEAD
    public Transfer getTransfer(int transferId) throws TransferNotFoundException {
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfer WHERE transfer_id = ?;";
        Transfer transfer = mapRowToTransfer(jdbcTemplate.queryForRowSet(sql, transferId));
=======
    public Transfer getTransfer(int id) {
        Transfer transfer = null;
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfer WHERE transfer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            transfer = mapRowToTransfer(results);
        } else {
            throw new TransferNotFoundException();
        }
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
        return transfer;
    }

    @Override
    public List<String> listRecipients(Principal principal) {
        List<String> recipients = new ArrayList<>();
        List<User> users = jdbcUserDao.findAll();
        for (User user : users) {
            if (!user.getUsername().equalsIgnoreCase(principal.getName())) {
                recipients.add(user.getUsername());
            }
        }
        return recipients;
    }

    @Override
    public List<Transfer> seeTransfersSentOrReceived(int userId) throws UserNotFoundException {
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
<<<<<<< HEAD
                "FROM transfer WHERE account_from = (SELECT account_id FROM account WHERE user_id = ?) || account_to = (SELECT account_id FROM account WHERE user_id = ?);";
=======
                "FROM transfer WHERE account_from IN (SELECT account_id FROM account WHERE user_id = ?) OR account_to IN (SELECT account_id FROM account WHERE user_id = ?);";
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
        List<Transfer> transfers = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId, userId);
        while (rowSet.next()) {
            transfers.add(mapRowToTransfer(rowSet));
        }
        return transfers;
    }

    @Override
    public Transfer updateTransfer(Transfer transfer) throws TransferNotFoundException {
        String sql = "UPDATE transfer " +
                "SET transfer_type_id = ?, " +
                "transfer_status_id = ?, " +
                "account_from = ?, " +
                "account_to = ?, " +
                "amount = ? " +
                "WHERE transfer_id = ?;";
        jdbcTemplate.update(sql, transfer.getTransferId(),
                transfer.getTransferTypeId(),
                transfer.getTransferStatusId(),
                transfer.getAccountFrom(),
                transfer.getAccountTo(),
                transfer.getTransferAmount());
        return getTransfer(transfer.getTransferId());
    }

<<<<<<< HEAD
    @Override
    public TransferStatus getTransferStatus(int id) {
        return null;
    }
=======


>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b

    private Transfer mapRowToTransfer(SqlRowSet rowSet) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rowSet.getInt("transfer_id"));
        transfer.setTransferTypeId(rowSet.getInt("transfer_type_id"));
        transfer.setTransferStatusId(rowSet.getInt("transfer_status_id"));
        transfer.setAccountFrom(rowSet.getInt("account_from"));
        transfer.setAccountTo(rowSet.getInt("account_to"));
        transfer.setTransferAmount(rowSet.getBigDecimal("amount"));
        return transfer;
    }

<<<<<<< HEAD
}
=======

/*
    @Override
    public Transfer completeTransfer(int fromId, int toId, BigDecimal amountToTransfer) throws AccountNotFoundException {
        Transfer newTransfer = null;
        if (isBalanceSufficient(fromId, amountToTransfer)) {
            adjustBalances(fromId, toId, amountToTransfer);
            newTransfer = recordTransfer(fromId, toId, amountToTransfer);
        }
        return newTransfer;
    }*/
    }

>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
