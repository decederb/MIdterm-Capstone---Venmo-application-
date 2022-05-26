package com.techelevator.tenmo.controller;

<<<<<<< HEAD
//imports copied from Authentication Controller, changed 'Login' and 'Registered User' to
//'Transfer' and 'Account'

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;

import com.techelevator.tenmo.exception.TransferNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.*;

import java.security.Principal;
import java.util.List;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@PreAuthorize("isAuthenticated()")
public class TransferController {

    private AccountDao accountDao;
    private UserDao userDao;
    private TransferDao transferDao;


    @RequestMapping(path = "/transfer", method = RequestMethod.POST)
    public Transfer transfer(@RequestBody Transfer transfer) {
        System.out.println("In transfer " + transfer);
        return null;
    }

    @RequestMapping(path = "/transfer", method = RequestMethod.PUT)
    public Transfer processTransfer(@RequestBody Transfer transfer) {
        System.out.println(transfer);
        return transferDao.createTransfer(transfer);
    }

    @RequestMapping(path = "/transfer", method = RequestMethod.GET)
    public Transfer getTransferHistory(Principal principal) throws TransferNotFoundException {
        int id = userDao.findIdByUsername(principal.getName());
        return transferDao.getTransfer(id);
    }

    @RequestMapping(path = "/transfer/{id}", method = RequestMethod.GET)
    public TransferStatus getTransferDetailById(@PathVariable int id) {
        return transferDao.getTransferStatus(id);
    }
}

    /*
    @RequestMapping(path = "/balance", method = RequestMethod.GET)
    public Account getAccount(Principal principal) {
        long id = userDao.findIdByUsername(principal.getName());
        return accountDao.getAccount(id);
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUserIdAndName(Principal principal) {
        long id = userDao.findIdByUsername(principal.getName());
        return userDao.findIdByUsername(id);
    }
     */

=======
import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.exception.TransferNotFoundException;
import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/transfer")
@PreAuthorize("isAuthenticated()")
public class TransferController {
    private final TransferDao transferDao;
    private final AccountDao accountDao;

    public TransferController(TransferDao transferDao, AccountDao accountDao) {
        this.transferDao = transferDao;
        this.accountDao = accountDao;
    }

    @GetMapping(path = "/recipients")
    public List<String> listRecipients(Principal principal) {
        return transferDao.listRecipients(principal);
    }

    @GetMapping(path = "/history")
    public List<Transfer> getTransferHistory(Principal principal) throws UserNotFoundException, AccountNotFoundException {
        int relevantUserId = accountDao.findAccountByUsername(principal.getName()).getUserId();
        return transferDao.seeTransfersSentOrReceived(relevantUserId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "")
    public Transfer processTransfer(Principal principal, @Valid @RequestBody Transfer transfer) throws AccountNotFoundException {
        int relevantAccountFromId = accountDao.findAccountByUsername(principal.getName()).getAccountId();
        Integer transferId = transferDao.createTransfer(relevantAccountFromId, transfer.getAccountTo(), transfer.getTransferAmount());
        return getTransferById(transferId);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Transfer getTransferById(@Valid @PathVariable int id) throws TransferNotFoundException {
        return transferDao.getTransfer(id);
    }

    @RequestMapping(path = "/check", method = RequestMethod.GET)
    public boolean isBalanceSufficient(@Valid @RequestBody int fromId, BigDecimal amountToTransfer) throws AccountNotFoundException {
        return (accountDao.getBalance(fromId).compareTo(amountToTransfer)) >= 0;
    }
}
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
