package com.techelevator.tenmo.controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {



=======
import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;

@RestController
@RequestMapping("/account")
@PreAuthorize("isAuthenticated()")
public class AccountController {
    private final AccountDao accountDao;


    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @RequestMapping(path = "/balance", method = RequestMethod.GET)
    public BigDecimal showBalance(Principal principal) throws AccountNotFoundException, UserNotFoundException {
        String relevantUsername = principal.getName();
        Account relevantAccount = accountDao.findAccountByUsername(relevantUsername);
        int relevantUserId = relevantAccount.getUserId();
        return accountDao.getBalance(relevantUserId);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Account updateAccount(@RequestParam BigDecimal balance, @Valid @PathVariable int id) throws AccountNotFoundException {
        return accountDao.updateAccount(balance, id);
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public int findToAccountByUserId(@Valid @PathVariable int userId) throws AccountNotFoundException, UserNotFoundException {
        Account relevantAccount = accountDao.findAccountByUserId(userId);
        int relevantAccountId = relevantAccount.getAccountId();
        return relevantAccountId;
    }

    @RequestMapping (path = "/checkbalance", method = RequestMethod.GET)
    public BigDecimal checkBalanceTwo (@Valid @RequestParam int relevantUserId) throws UserNotFoundException {
        return accountDao.getBalance(relevantUserId);
    }
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
}
