package com.techelevator.tenmo.dao;

<<<<<<< HEAD
import com.techelevator.tenmo.model.Account;
//Changed 'User' to 'Account'
import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.exception.UserNotFoundException;
=======
import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Account;
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b

import java.math.BigDecimal;
import java.util.List;

<<<<<<< HEAD

public interface AccountDao {

    Account getAccount (int id);

=======
public interface AccountDao {

>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
    BigDecimal getBalance(int accountId) throws AccountNotFoundException;

    List<Account> listAllAccounts();

<<<<<<< HEAD
    Account findAccountByUserId(int userId) throws UserNotFoundException;
=======
    Account findAccountByUsername(String username) throws UserNotFoundException, AccountNotFoundException;

    Account findAccountByUserId(int userId) throws AccountNotFoundException;
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b

    Account findAccountByAccountId(int accountId) throws AccountNotFoundException;

    Integer createAccount(Account account);

<<<<<<< HEAD
    Account updateAccount(Account account) throws AccountNotFoundException;

    void deleteAccount(int AccountId);

}
=======
    Account updateAccount(BigDecimal balance, int userId) throws UserNotFoundException;

    void deleteAccount(int AccountId);


}
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
