package com.techelevator.tenmo.dao;

<<<<<<< HEAD
import com.techelevator.tenmo.exception.TransferNotFoundException;
import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferStatus;
import com.techelevator.tenmo.model.User;
=======
import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.exception.TransferNotFoundException;
import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Transfer;
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface TransferDao {

<<<<<<< HEAD
    public Transfer createTransfer(Transfer transfer);  //think of this as equivalent to create

=======
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
    public Transfer getTransfer(int transferId) throws TransferNotFoundException;

    public List<String> listRecipients(Principal principal);

    public List<Transfer> seeTransfersSentOrReceived(int userId) throws UserNotFoundException;

    public Transfer updateTransfer(Transfer transfer) throws TransferNotFoundException;

<<<<<<< HEAD
    TransferStatus getTransferStatus(int id);
}








=======
    public Integer createTransfer(int relevantAccountFromId, int accountTo, BigDecimal transferAmount);

    }
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
