package com.techelevator.tenmo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Transfer not found.")
<<<<<<< HEAD
public class TransferNotFoundException extends Exception {
=======
public class TransferNotFoundException extends RuntimeException {
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
    private static final long serialVersionUID = 1L;

    public TransferNotFoundException() {
        super("Transfer not found.");
    }
}
