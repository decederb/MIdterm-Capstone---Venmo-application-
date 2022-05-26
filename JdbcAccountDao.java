package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Component;
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class JdbcAccountDao implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account getAccount(int id) {
        return null;
    }

    @Override
    public BigDecimal getBalance(int accountId) throws AccountNotFoundException {
        String sql = "SELECT balance FROM account WHERE account_id = ?;";
        BigDecimal balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, accountId);
        return balance;
    }
=======
@Component
public class JdbcAccountDao implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public BigDecimal getBalance(int userId) throws AccountNotFoundException {
        String sql = "SELECT balance FROM account WHERE user_id = ?;";
            BigDecimal balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, userId);
            return balance;
        }
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b

    @Override
    public List<Account> listAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, user_id, balance FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
<<<<<<< HEAD
        while (results.next()) {
=======
        while(results.next()) {
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
            Account account = mapRowToAccount(results);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
<<<<<<< HEAD
    public Account findAccountByUserId(int userId) throws UserNotFoundException {
        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = ?;";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        return mapRowToAccount(results);
=======
    public Account findAccountByUsername(String username) throws AccountNotFoundException {
        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = " +
                "(SELECT user_id FROM tenmo_user WHERE username = ?);";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        Account newAccount = null;
        if (results.next()) {
            newAccount = mapRowToAccount(results);
        } else {
            throw new AccountNotFoundException();
        } return newAccount;
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
    }

    @Override
    public Account findAccountByAccountId(int accountId) throws AccountNotFoundException {
        String sql = "SELECT account_id, user_id, balance FROM account WHERE account_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
<<<<<<< HEAD
        return mapRowToAccount(results);
=======
        Account newAccount = null;
        if (results.next()) {
            newAccount = mapRowToAccount(results);
        } else {
            throw new AccountNotFoundException();
        } return newAccount;
    }

    @Override
    public Account findAccountByUserId(int userId) throws AccountNotFoundException {
        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        Account newAccount = null;
        if (results.next()) {
            newAccount = mapRowToAccount(results);
        } else {
            throw new AccountNotFoundException();
        } return newAccount;
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
    }

    @Override
    public Integer createAccount(Account account) {
        String sql = "INSERT INTO account (user_id, balance) VALUES (?, ?) RETURNING account_id";

        Integer newAccountId;
        try {
            newAccountId = jdbcTemplate.queryForObject(sql, Integer.class, account.getUserId(), account.getBalance());
            return newAccountId;
        } catch (DataAccessException e) {
            return -1;
        }
    }

    @Override
<<<<<<< HEAD
    public Account updateAccount(Account account) throws AccountNotFoundException {
        String sql = "UPDATE account " +
                "SET user_id = ?," +
                "balance = ? " +
                "WHERE account_id = ?;";
        jdbcTemplate.update(sql,
                account.getUserId(),
                account.getBalance(),
                account.getAccountId());
        return findAccountByAccountId((int) account.getAccountId());
=======
    public Account updateAccount(BigDecimal balance, int userId) throws AccountNotFoundException {
        String sql = "UPDATE account " +
                "SET balance = ? " +
                "WHERE user_id = ?;";
        jdbcTemplate.update(sql,
                balance,
                userId);
        return findAccountByUserId(userId);
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
    }

    @Override
    public void deleteAccount(int AccountId) {
        //nec'y? TBD
    }

<<<<<<< HEAD
    private Account mapRowToAccount(SqlRowSet results) {
        Account account = new Account();
        account.setAccountId(results.getInt("account_id"));
        account.setUserId(results.getInt("user_id"));
        account.setBalance(results.getBigDecimal("balance"));
        return account;
    }

=======
    private Account mapRowToAccount(SqlRowSet row) {
        Account account = new Account();
        account.setAccountId(row.getInt("account_id"));
        account.setUserId(row.getInt("user_id"));
        account.setBalance(row.getBigDecimal("balance"));
        return account;
    }
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
}
